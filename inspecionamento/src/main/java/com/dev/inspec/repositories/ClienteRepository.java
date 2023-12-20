package com.dev.inspec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Cliente;
import com.dev.inspec.entities.TipoCliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByTipoCliente(TipoCliente tipoCliente);
}
