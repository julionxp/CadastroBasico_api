package com.CadastroBasico.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CadastroBasico.api.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    Cadastro findByEmail(String email);
    
}
