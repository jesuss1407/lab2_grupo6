package com.example.lab2_g6.controller;

import com.example.lab2_g6.entity.User;
import com.example.lab2_g6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/inicio")
    public String index(){
        return "inicio2";
    }

    @PostMapping("/inicioSesion")
    public String verificarLogin(@RequestParam("correo") String correo,
                                 @RequestParam("contrasena") String contrasena){
        User user = userRepository.encontrarUsuario(correo, contrasena);

        if (user != null) {
            return "principal";
        }else{
            return "redirect:/login/inicio";
        }
    }
}