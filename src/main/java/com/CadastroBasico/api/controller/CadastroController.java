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
public class CadastroController {
    
    @Autowired
    private CadastroRepository cadastroRepository;

    
    
    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "cadastro";
    }

    @PostMapping("/usuario")
    public String salvarCadstro(@ModelAttribute Cadastro usuario) {
        cadastroRepository.save(usuario);
        return "redirect:/successfulCadastro";
    }



    





}
