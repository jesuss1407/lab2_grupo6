package com.example.lab2_g6.controller;

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

    @GetMapping(value = {"/list"})
    public String listarTransportistas(Model model){
        model.addAttribute("listaTransaption",transactionRepository.findAll());
        return "wallet";
    }

}
