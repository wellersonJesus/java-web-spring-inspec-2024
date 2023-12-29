package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {

}
