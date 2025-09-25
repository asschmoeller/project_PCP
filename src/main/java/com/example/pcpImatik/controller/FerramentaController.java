package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Ferramenta;
import com.example.pcpImatik.entity.TipoManFerramenta;
import com.example.pcpImatik.service.FerramentaService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/ferramentas")

public class FerramentaController {

    @Autowired
    private FerramentaService service;

    @GetMapping
    public ModelAndView listarFerramentas(@RequestParam(required = false) String nome) {
        List<Ferramenta> listaFerramentas;

        if (nome != null && !nome.isEmpty()) {
            listaFerramentas = service.findByNome(nome); // faço isso para habilitar a busca do nome da ferramenta
                                                            // na página index
        } else {
            listaFerramentas = service.getAll();
        }

        ModelAndView model = new ModelAndView("ferramenta/index");
        model.addObject("listaFerramentas", listaFerramentas);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoFerramenta = new Ferramenta();

        ModelAndView model = new ModelAndView("ferramenta/form");
        model.addObject("ferramenta", novoFerramenta);
        model.addObject("tiposman", TipoManFerramenta.values());
        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid @ModelAttribute("ferramenta") Ferramenta ferramenta, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("ferramenta/form");
            model.addObject("tiposman", TipoManFerramenta.values());
            return model;
        }
        service.save(ferramenta);
        return new ModelAndView("redirect:/ferramentas");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Ferramenta ferramenta) {
        ModelAndView model = new ModelAndView("ferramenta/form");
        model.addObject("ferramenta", ferramenta);
        model.addObject("tiposman", TipoManFerramenta.values());
        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Ferramenta ferramenta) {
        service.delete(ferramenta);
        return new ModelAndView("redirect:/ferramentas");
    }
}