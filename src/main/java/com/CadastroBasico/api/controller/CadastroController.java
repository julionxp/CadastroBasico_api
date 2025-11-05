package com.CadastroBasico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CadastroBasico.api.model.Cadastro;
import com.CadastroBasico.api.repositories.CadastroRepository;

@Controller
public class CadastroController {
    
    @Autowired
    private CadastroRepository cadastroRepository;





    @GetMapping("/home")
    public String mostrarHome(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "home";
    }

    // @GetMapping("/final")
    // public String mostrarFinal() {
    //     return "final";
    // }






    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String salvarCadstro(@ModelAttribute Cadastro usuario) {
        cadastroRepository.save(usuario);
        return "redirect:/login";
    }




    

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(@ModelAttribute Cadastro cadastro, Model model) {

        Cadastro usuario = cadastroRepository.findByEmailAndSenha(
            cadastro.getEmail(),
            cadastro.getSenha()
        );

        if (usuario != null) {
            return "redirect:/final";
        
        } else {
            model.addAttribute("erro", "Email ou senha incorretos!");
            return "login";
        }
    }



    @GetMapping("/final")
    public String mostrarAgradecimento(Model model) {
        model.addAttribute("mensagem", "Login efetuado com sucesso. Obrigado por acessar!");
        return "final";
    
    }


}
