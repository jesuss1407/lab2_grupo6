package com.example.lab2_g6.controller;

import com.example.lab2_g6.entity.Transaction;
import com.example.lab2_g6.repository.CurrencyRepository;
import com.example.lab2_g6.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("transaccion")
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

        model.addAttribute("listaCriptomonedas", currencyRepository.findAll());
        model.addAttribute("listaNtransacciones",transactionRepository.numeroTransaccion());
        /*model.addAttribute("listaNetwork",transactionRepository.buscarNetwork());*/
        /*model.addAttribute("listaTransacciones",transactionRepository.buscarTrapsactiones());*/
        /* model.addAttribute("listaNtransacciones",transactionRepository.numeroTransaccion());*/
        model.addAttribute("listaStatus",transactionRepository.buscarStatus());
        return "form";
    }


    @PostMapping("/save")
    public String guardarNuevoTransportista(Transaction transaction, RedirectAttributes attr) {
        transactionRepository.save(transaction);
        return "redirect:/transaccion/list";
    }


}
