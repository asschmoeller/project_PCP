package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Funcionario;
import com.example.pcpImatik.service.FuncionarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ModelAndView listarFuncionarios(@RequestParam(required = false) String nome) {
        List<Funcionario> listaFuncionarios;

        if (nome != null && !nome.isEmpty()) {
            listaFuncionarios = service.findByNome(nome); // faço isso para habilitar a busca do nome do funcionário
                                                            // na página index
        } else {
            listaFuncionarios = service.getAll();
        }

        ModelAndView model = new ModelAndView("funcionario/index");
        model.addObject("listaFuncionarios", listaFuncionarios);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoFuncionario = new Funcionario();

        ModelAndView model = new ModelAndView("funcionario/form");
        model.addObject("funcionario", novoFuncionario);
        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("funcionario/form");
            return model;
        }
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Funcionario funcionario) {
        ModelAndView model = new ModelAndView("funcionario/form");
        model.addObject("funcionario", funcionario);
        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Funcionario funcionario) {
        service.delete(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }
}
