package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.OrdemProducao;
import com.example.pcpImatik.service.OperadorService;
import com.example.pcpImatik.service.OrdemProducaoService;
import com.example.pcpImatik.service.ProdutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ordensProducao")
public class OrdemProducaoController {

    @Autowired
    private OrdemProducaoService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private OperadorService operadorService;

    @GetMapping
    public ModelAndView listarOrdensProducao(@RequestParam(required = false) Long id) {
        List<OrdemProducao> listaOrdensProducao;

        if (id != null) {
            var ordem = service.findById(id);
            listaOrdensProducao = ordem.map(List::of).orElse(List.of());
        } else {
            listaOrdensProducao = service.getAll();
        }

        ModelAndView model = new ModelAndView("ordemProducao/index");
        model.addObject("listaOrdensProducao", listaOrdensProducao);

        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        OrdemProducao novoOrdemProducao = new OrdemProducao();
        var listaProduto = produtoService.getAll();
        var listaOperador = operadorService.getAll();

        ModelAndView model = new ModelAndView("ordemProducao/form");
        model.addObject("ordemProducao", novoOrdemProducao);

        model.addObject("listaProduto", listaProduto);
        model.addObject("listaOperador", listaOperador);

        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid @ModelAttribute("ordemProducao") OrdemProducao ordemProducao,
            BindingResult result) {
        if (result.hasErrors()) {
            var listaProduto = produtoService.getAll();
            var listaOperador = operadorService.getAll();
            ModelAndView model = new ModelAndView("ordemProducao/form");
            model.addObject("listaProduto", listaProduto);
            model.addObject("listaOperador", listaOperador);
            return model;
        }
        service.save(ordemProducao);

        return new ModelAndView("redirect:/ordensProducao");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") OrdemProducao ordemProducao) {
        ModelAndView model = new ModelAndView("ordemProducao/form");
        model.addObject("ordemProducao", ordemProducao);
        model.addObject("listaProduto", produtoService.getAll());
        model.addObject("listaOperador", operadorService.getAll());
        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") OrdemProducao ordemProducao) {
        service.delete(ordemProducao);
        return new ModelAndView("redirect:/ordensProducao");
    }

}
