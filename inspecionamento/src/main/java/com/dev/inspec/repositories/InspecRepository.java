package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Cadastro;

public interface InspecRepository extends JpaRepository<Cadastro, Long> {

}
