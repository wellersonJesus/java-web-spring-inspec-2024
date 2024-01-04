package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}