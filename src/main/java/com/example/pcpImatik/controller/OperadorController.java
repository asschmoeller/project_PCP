package com.example.pcpImatik.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Equipamento;
import com.example.pcpImatik.entity.Operador;
import com.example.pcpImatik.service.EquipamentoService;
import com.example.pcpImatik.service.FuncionarioService;
import com.example.pcpImatik.service.OperadorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/operadores")
public class OperadorController {

    @Autowired
    private OperadorService service;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public ModelAndView listarOperadores(@RequestParam(required = false) String nome) {
        List<Operador> listaOperadores;

        if (nome != null && !nome.isEmpty()) {
            listaOperadores = service.findByNome(nome);
        } else {
            listaOperadores = service.getAll();
        }

        ModelAndView model = new ModelAndView("operador/index");
        model.addObject("listaOperadores", listaOperadores);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        Operador novoOperador = new Operador();
        var listaFuncionario = funcionarioService.getAll(); // para puxar 1 funcionário
        novoOperador.setEquipamentos(new HashSet<>());

        ModelAndView model = new ModelAndView("operador/form");
        model.addObject("operador", novoOperador);

        List<Equipamento> listaEquipamento = equipamentoService.getAll();
        model.addObject("listaEquipamento", listaEquipamento); // para puxar vários equipamentos

        model.addObject("listaFuncionario", listaFuncionario); // para puxar 1 funcionário

        return model;
    }

    @PostMapping
    public ModelAndView salvar(
            @Valid @ModelAttribute("operador") Operador operador,
            BindingResult result,
            @RequestParam(required = false, name = "equipamentosIds") List<Long> equipamentosIds) {

        if (result.hasErrors()) {
            var listaFuncionario = funcionarioService.getAll(); // para puxar 1 funcionário
            ModelAndView model = new ModelAndView("operador/form");

            List<Equipamento> listaEquipamento = equipamentoService.getAll();
            model.addObject("listaEquipamento", listaEquipamento); // para puxar vários equipamentos

            model.addObject("listaFuncionario", listaFuncionario); // para puxar 1 funcionário

            return model;
        }

        if (equipamentosIds != null && !equipamentosIds.isEmpty()) {
            Set<Equipamento> equipamentos = new HashSet<>(equipamentoService.findAllByIds(equipamentosIds));
            operador.setEquipamentos(equipamentos); // para puxar vários equipamentos
        } else {
            operador.setEquipamentos(new HashSet<>()); // para puxar vários equipamentos
        }

        service.save(operador);

        return new ModelAndView("redirect:/operadores");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id) {
        Optional<Operador> operadorOpt = service.findById(id);
        if (operadorOpt.isEmpty()) {
            return new ModelAndView("redirect:/operadores");
        }

        Operador operador = operadorOpt.get();
        ModelAndView model = new ModelAndView("operador/form");
        model.addObject("operador", operador);
        model.addObject("listaEquipamento", equipamentoService.getAll());
        model.addObject("listaFuncionario", funcionarioService.getAll());

        return model;
    }

    @GetMapping("/remover/{id}")
public ModelAndView remover(@PathVariable Long id) {
    Optional<Operador> operadorOpt = service.findById(id);
    operadorOpt.ifPresent(service::delete);
    return new ModelAndView("redirect:/operadores");
}

}
