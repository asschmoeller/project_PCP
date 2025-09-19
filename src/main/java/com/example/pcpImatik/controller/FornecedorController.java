package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Fornecedor;
import com.example.pcpImatik.entity.TipoFornecedor;
import com.example.pcpImatik.service.FornecedorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ModelAndView listarFornecedores(@RequestParam(required = false) String nome) {
        List<Fornecedor> listaFornecedores;

        if (nome != null && !nome.isEmpty()) {
            listaFornecedores = service.findByNome(nome); // faço isso para habilitar a busca do nome do funcionário
                                                            // na página index
        } else {
            listaFornecedores = service.getAll();
        }

        ModelAndView model = new ModelAndView("fornecedor/index");
        model.addObject("listaFornecedores", listaFornecedores);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoFornecedor = new Fornecedor();

        ModelAndView model = new ModelAndView("fornecedor/form");
        model.addObject("fornecedor", novoFornecedor);
        model.addObject("tipos", TipoFornecedor.values());
        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid @ModelAttribute("fornecedor") Fornecedor fornecedor, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("fornecedor/form");
            model.addObject("tipos", TipoFornecedor.values());
            return model;
        }
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Fornecedor fornecedor) {
        ModelAndView model = new ModelAndView("fornecedor/form");
        model.addObject("fornecedor", fornecedor);
        model.addObject("tipos", TipoFornecedor.values());
        return model;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Fornecedor fornecedor) {
        service.delete(fornecedor);
        return new ModelAndView("redirect:/fornecedores");
    }
}
