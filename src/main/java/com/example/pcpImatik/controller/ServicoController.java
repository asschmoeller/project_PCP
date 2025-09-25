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

import com.example.pcpImatik.entity.Servico;
import com.example.pcpImatik.service.ServicoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicos")

public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ModelAndView listarServicos(@RequestParam(required = false) String nome) {
        List<Servico> listaServicos;

        if (nome != null && !nome.isEmpty()) {
            listaServicos = service.findByNome(nome); // faço isso para habilitar a busca do nome do servico
                                                            // na página index
        } else {
            listaServicos = service.getAll();
        }

        ModelAndView model = new ModelAndView("servico/index");
        model.addObject("listaServicos", listaServicos);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoServico = new Servico();
        return new ModelAndView("servico/form", "servico", novoServico);
    }

    @PostMapping
    public ModelAndView save(@Valid @ModelAttribute("servico") Servico servico, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("servico/form");
            return model;
        }
        service.save(servico);
        return new ModelAndView("redirect:/servicos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Servico servico) {
        return new ModelAndView("servico/form", "servico", servico);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Servico servico) {
        service.delete(servico);
        return new ModelAndView("redirect:/servicos");
    }
}