package com.example.pcpImatik.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.MateriaPrima;
import com.example.pcpImatik.entity.MateriaPrimaProduto;
import com.example.pcpImatik.entity.MateriaPrimaProdutoId;
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
        novoProduto.setProdutoMateriaPrima(new HashSet<>());

        ModelAndView model = new ModelAndView("produto/form");
        model.addObject("produto", novoProduto);
        model.addObject("unidades", UnidadeMedida.values());

        List<MateriaPrima> listaMateriaPrima = materiaPrimaService.getAll();
        model.addObject("listaMateriaPrima", listaMateriaPrima);

        Map<Long, String> nomesMateriaPrima = new HashMap<>();
        for (MateriaPrima mp : listaMateriaPrima) {
            nomesMateriaPrima.put(mp.getId(), mp.getNomeMateriaPrima());
        }
        model.addObject("nomesMateriaPrima", nomesMateriaPrima);

        model.addObject("quantidadesMateriaPrima", new HashMap<Long, Double>());

        return model;
    }

    @PostMapping
    public ModelAndView salvar(
            @Valid @ModelAttribute("produto") Produto produto,
            BindingResult result,
            @RequestParam(required = false, name = "materiaPrimasIds") List<Long> materiasPrimasIds,
            @RequestParam(required = false) Map<String, String> quantidades) {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("produto/form");
            model.addObject("produto", produto);
            model.addObject("unidades", UnidadeMedida.values());

            List<MateriaPrima> listaMateriaPrima = materiaPrimaService.getAll();
            model.addObject("listaMateriaPrima", listaMateriaPrima);

            // Adiciona o mapa de nomes
            Map<Long, String> nomesMateriaPrima = new HashMap<>();
            for (MateriaPrima mp : listaMateriaPrima) {
                nomesMateriaPrima.put(mp.getId(), mp.getNomeMateriaPrima());
            }
            model.addObject("nomesMateriaPrima", nomesMateriaPrima);

            // Montar o mapa de quantidades para o formulário (mesmo que vazio)
            Map<Long, Double> quantidadesMateriaPrima = new HashMap<>();
            if (produto.getProdutoMateriaPrima() != null) {
                for (MateriaPrimaProduto mpp : produto.getProdutoMateriaPrima()) {
                    quantidadesMateriaPrima.put(mpp.getMateriaProdutoId().getMateriaPrima().getId(), mpp.getQuantity());
                }
            }
            model.addObject("quantidadesMateriaPrima", quantidadesMateriaPrima);

            return model;
        }

        if (materiasPrimasIds != null && !materiasPrimasIds.isEmpty()) {
            Set<MateriaPrimaProduto> materiasPrimasProdutos = new HashSet<>();
            List<MateriaPrima> materiasPrimas = materiaPrimaService.findAllByIds(materiasPrimasIds);

            for (MateriaPrima mp : materiasPrimas) {
                String q = quantidades.get("quantidades[" + mp.getId() + "]");
                Double quantidade = (q != null && !q.isEmpty()) ? Double.valueOf(q) : 0.0;

                MateriaPrimaProdutoId id = new MateriaPrimaProdutoId(produto, mp);
                MateriaPrimaProduto mpp = new MateriaPrimaProduto(id, quantidade);
                materiasPrimasProdutos.add(mpp);
            }
            produto.setProdutoMateriaPrima(materiasPrimasProdutos);
        } else {
            produto.setProdutoMateriaPrima(new HashSet<>());
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

        // Mapeia id -> nome para exibir corretamente
        Map<Long, String> nomesMateriaPrima = new HashMap<>();
        for (MateriaPrima mp : listaMateriaPrima) {
            nomesMateriaPrima.put(mp.getId(), mp.getNomeMateriaPrima());
        }
        model.addObject("nomesMateriaPrima", nomesMateriaPrima);

        // Mapa de quantidades
        Map<Long, Double> quantidadesMateriaPrima = new HashMap<>();
        if (produto.getProdutoMateriaPrima() != null) {
            for (MateriaPrimaProduto mpp : produto.getProdutoMateriaPrima()) {
                quantidadesMateriaPrima.put(
                        mpp.getMateriaProdutoId().getMateriaPrima().getId(),
                        mpp.getQuantity());
            }
        }
        model.addObject("quantidadesMateriaPrima", quantidadesMateriaPrima);

        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Produto produto) {
        service.delete(produto);
        return new ModelAndView("redirect:/produtos");
    }
}
