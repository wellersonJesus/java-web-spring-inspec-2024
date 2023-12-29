package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
