package com.example.lab2_g6.controller;

import com.example.lab2_g6.entity.Transaction;
import com.example.lab2_g6.repository.CurrencyRepository;
import com.example.lab2_g6.repository.TransactionRepository;
import com.example.lab2_g6.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("transaccion")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletRepository walletRepository;
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
        model.addAttribute("listaWallet", walletRepository.findAll());
        return "form";
    }


    @PostMapping("/save")
    public String guardarNuevoTransportista(Transaction transaction, RedirectAttributes attr) {
        transactionRepository.save(transaction);
        return "redirect:/transaccion/list";
    }


    @PostMapping("/buscarTrans")
    public String buscarTrans(@RequestParam("searchField") int searchField,
                                      Model model) {

        List<Transaction> listaTrans = transactionRepository.buscarTrans(searchField);
        model.addAttribute("listaTransaption", listaTrans);

        return "transacciones";
    }
    @GetMapping("wallet")
    public String wallet(Model model, @RequestParam("id") int id) {
        model.addAttribute("listaWallet",walletRepository.obtenerMyWalletDto(id));
        return "wallet";
    }

}
