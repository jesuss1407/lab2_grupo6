package com.example.lab2_g6.controller;

import com.example.lab2_g6.entity.Currency;
import com.example.lab2_g6.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cripto")
public class CriptoController {


    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/listar")
    public String index(Model model){

        List<Currency> lista = CurrencyRepository.findAll();
        model.addAttribute("criptoList", lista);


        return "principal";
    }
}