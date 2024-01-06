package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Inspecao;

public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {

}