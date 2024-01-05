package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

}