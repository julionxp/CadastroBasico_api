package com.CadastroBasico.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class successfulLoginController {
    
    @GetMapping("/successfulLogin")
    public String pagesuccessfulLogin(Model model) {
        model.addAttribute("successfulLogin", new successfulLoginController());
        return "successfulLogin";
    }

}
