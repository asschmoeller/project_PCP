package com.example.pcpImatik.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Produto;
import com.example.pcpImatik.entity.Equipamento;
import com.example.pcpImatik.service.ProdutoService;
import com.example.pcpImatik.service.EquipamentoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView listarEquipamentos (@RequestParam(required = false) String nome) {
        List<Equipamento> listaEquipamentos;

        if (nome != null && !nome.isEmpty()) {
            listaEquipamentos = service.findByNome(nome);
        } else {
            listaEquipamentos = service.getAll();
        }

        ModelAndView model = new ModelAndView("equipamento/index");
        model.addObject("listaEquipamentos", listaEquipamentos);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        Equipamento novoEquipamento = new Equipamento();
        novoEquipamento.setProdutos(new HashSet<>());

        ModelAndView model = new ModelAndView("equipamento/form");
        model.addObject("equipamento", novoEquipamento);

        List<Produto> listaProduto = produtoService.getAll();
        model.addObject("listaProduto", listaProduto);

        return model;
    }

    @PostMapping
    public ModelAndView salvar(
        @Valid @ModelAttribute("equipamento") Equipamento equipamento,
        BindingResult result,
        @RequestParam(required = false, name = "produtosIds") List<Long> produtosIds) {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("equipamento/form");

            List<Produto> listaProduto = produtoService.getAll();
            model.addObject("listaProduto", listaProduto);

            return model;
        }

        if (produtosIds != null && !produtosIds.isEmpty()) {
            Set<Produto> produtos = new HashSet<>(produtoService.findAllByIds(produtosIds));
            equipamento.setProdutos(produtos);
        } else {
            equipamento.setProdutos(new HashSet<>());
        }

        service.save(equipamento);

        return new ModelAndView("redirect:/equipamentos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Equipamento equipamento) {
        ModelAndView model = new ModelAndView("equipamento/form");
        model.addObject("equipamento", equipamento);

        List<Produto> listaProduto = produtoService.getAll();
        model.addObject("listaProduto", listaProduto);

        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Equipamento equipamento) {
        service.delete(equipamento);
        return new ModelAndView("redirect:/equipamentos");
    }
}
