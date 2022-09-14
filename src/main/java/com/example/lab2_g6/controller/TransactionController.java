package com.example.lab2_g6.controller;

import com.example.lab2_g6.repository.CurrencyRepository;
import com.example.lab2_g6.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("transaption")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @GetMapping(value = {"/list"})
    public String listarTransportistas(Model model){
        model.addAttribute("listaTransaption",transactionRepository.findAll());
        return "transacciones";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model) {

        model.addAttribute("listaCriptomonedas", transactionRepository.buscarCriptomonedas());
        model.addAttribute("listaAmount",transactionRepository.buscarCantidad() );
        model.addAttribute("listaNetwork",transactionRepository.buscarNetwork());
        model.addAttribute("listaTransapcioes",transactionRepository.buscarTrapsactiones());
        return "form";
    }

}
