package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.MateriaPrima;
import com.example.pcpImatik.entity.UnidadeMedida;
import com.example.pcpImatik.service.MateriaPrimaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/materiasPrimas")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService service;

    @GetMapping
    public ModelAndView listarMateriasPrimas(@RequestParam(required = false) String nome) {
        List<MateriaPrima> listaMateriasPrimas;

        if (nome != null && !nome.isEmpty()) {
            listaMateriasPrimas = service.findByNome(nome); // faço isso para habilitar a busca do nome da matéria prima
                                                            // na página index
        } else {
            listaMateriasPrimas = service.getAll();
        }

        ModelAndView model = new ModelAndView("materiaPrima/index");
        model.addObject("listaMateriasPrimas", listaMateriasPrimas);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoMateriaPrima = new MateriaPrima();

        ModelAndView model = new ModelAndView("materiaPrima/form");
        model.addObject("materiaPrima", novoMateriaPrima);
        model.addObject("unidades", UnidadeMedida.values());
        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid @ModelAttribute("materiaPrima") MateriaPrima materiaPrima, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("materiaPrima/form");
            model.addObject("unidades", UnidadeMedida.values());
            return model;
        }
        service.save(materiaPrima);
        return new ModelAndView("redirect:/materiasPrimas");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") MateriaPrima materiaPrima) {
        ModelAndView model = new ModelAndView("materiaPrima/form");
        model.addObject("materiaPrima", materiaPrima);
        model.addObject("unidades", UnidadeMedida.values());
        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") MateriaPrima materiaPrima) {
        service.delete(materiaPrima);
        return new ModelAndView("redirect:/materiasPrimas");
    }
}
