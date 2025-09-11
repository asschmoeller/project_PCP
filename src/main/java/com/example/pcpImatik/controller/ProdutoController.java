package com.example.pcpImatik.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.MateriaPrima;
import com.example.pcpImatik.entity.Produto;
import com.example.pcpImatik.entity.UnidadeMedida;
import com.example.pcpImatik.service.MateriaPrimaService;
import com.example.pcpImatik.service.ProdutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @GetMapping
    public ModelAndView listarProdutos(@RequestParam(required = false) String nome) {
        List<Produto> listaProdutos;

        if (nome != null && !nome.isEmpty()) {
            listaProdutos = service.findByNome(nome);
        } else {
            listaProdutos = service.getAll();
        }

        ModelAndView model = new ModelAndView("produto/index");
        model.addObject("listaProdutos", listaProdutos);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        Produto novoProduto = new Produto();
        novoProduto.setMateriasPrimas(new HashSet<>());

        ModelAndView model = new ModelAndView("produto/form");
        model.addObject("produto", novoProduto);
        model.addObject("unidades", UnidadeMedida.values());

        List<MateriaPrima> listaMateriaPrima = materiaPrimaService.getAll();
        model.addObject("listaMateriaPrima", listaMateriaPrima);

        return model;
    }

    @PostMapping
    public ModelAndView salvar(
        @Valid @ModelAttribute("produto") Produto produto,
        BindingResult result,
        @RequestParam(required = false, name = "materiasPrimasIds") List<Long> materiasPrimasIds) {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("produto/form");
            model.addObject("unidades", UnidadeMedida.values());

            List<MateriaPrima> listaMateriaPrima = materiaPrimaService.getAll();
            model.addObject("listaMateriaPrima", listaMateriaPrima);

            return model;
        }

        if (materiasPrimasIds != null && !materiasPrimasIds.isEmpty()) {
            Set<MateriaPrima> materiasPrimas = new HashSet<>(materiaPrimaService.findAllByIds(materiasPrimasIds));
            produto.setMateriasPrimas(materiasPrimas);
        } else {
            produto.setMateriasPrimas(new HashSet<>());
        }

        service.save(produto);

        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto) {
        ModelAndView model = new ModelAndView("produto/form");
        model.addObject("produto", produto);
        model.addObject("unidades", UnidadeMedida.values());

        List<MateriaPrima> listaMateriaPrima = materiaPrimaService.getAll();
        model.addObject("listaMateriaPrima", listaMateriaPrima);

        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Produto produto) {
        service.delete(produto);
        return new ModelAndView("redirect:/produtos");
    }
}
