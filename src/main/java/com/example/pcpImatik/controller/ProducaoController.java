package com.example.pcpImatik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/producao")

public class ProducaoController {
    @GetMapping
    public ModelAndView index() {


        return new ModelAndView("producao/index");
    }    
}
