package com.example.lab2_g6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cripto")
public class CriptoController {

    @GetMapping("/listar")
    public String index(){
        return "principal";
    }
}