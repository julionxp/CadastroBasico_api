package com.CadastroBasico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CadastroBasico.api.model.Cadastro;
import com.CadastroBasico.api.repositories.CadastroRepository;

@Controller
public class LoginController {
    
    @Autowired
    private CadastroRepository cadastroRepository;

    public LoginController(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }



    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("login", new Cadastro());
        return "login";
    }


    @PostMapping("/loginUsuario")
    public String validarLogin(@ModelAttribute("login") Cadastro login, Model model) {
        Cadastro usuario = cadastroRepository
                .findByEmail(login.getEmail());

        if (usuario != null && usuario.getSenha().equals(login.getSenha())) {
            return "redirect:/successfulLogin";

        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login";
        }

    }

}
