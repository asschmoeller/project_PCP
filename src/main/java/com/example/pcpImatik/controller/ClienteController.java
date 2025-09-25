package com.example.pcpImatik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pcpImatik.entity.Cliente;
import com.example.pcpImatik.service.ClienteService;

@Controller
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView listarClientes(@RequestParam(required = false) String nome) {
        List<Cliente> listaClientes;

        if (nome != null && !nome.isEmpty()) {
            listaClientes = service.findByNome(nome); // faço isso para habilitar a busca do nome do cliente
                                                            // na página index
        } else {
            listaClientes = service.getAll();
        }

        ModelAndView model = new ModelAndView("cliente/index");
        model.addObject("listaClientes", listaClientes);
        return model;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoCliente = new Cliente();
        return new ModelAndView("cliente/form", "cliente", novoCliente);
    }

    @PostMapping
    public ModelAndView save(Cliente cliente) {
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Cliente cliente) {
        return new ModelAndView("cliente/form", "cliente", cliente);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Cliente cliente) {
        service.delete(cliente);
        return new ModelAndView("redirect:/clientes");
    }
}