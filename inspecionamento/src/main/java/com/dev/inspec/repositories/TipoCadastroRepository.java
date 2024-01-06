package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.TipoCadastro;

public interface TipoCadastroRepository extends JpaRepository<TipoCadastro, Long> {

}