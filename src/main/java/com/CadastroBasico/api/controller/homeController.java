package com.CadastroBasico.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    
    @GetMapping("/home")
    public String pagehome(Model model) {
        model.addAttribute("home", new homeController());
        return "home";
    }

}
