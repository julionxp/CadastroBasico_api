package com.CadastroBasico.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class successfulCadastroController {

    @GetMapping("/successfulCadastro")
    public String pagesuccessfulCadastro(Model model) {
        model.addAttribute("successfulCadastro", new successfulCadastroController());
        return "successfulCadastro";
    }
}
