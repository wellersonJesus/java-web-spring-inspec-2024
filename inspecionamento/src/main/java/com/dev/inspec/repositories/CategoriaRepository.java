package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}