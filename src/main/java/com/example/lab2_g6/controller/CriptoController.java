package com.example.lab2_g6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CriptoController {

    @GetMapping("")
    public String index(){
        return "index";
    }
}