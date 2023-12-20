package com.dev.inspec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.Cadastro;
import com.dev.inspec.entities.TipoCadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	List<Cadastro> findByTipoCadastro(TipoCadastro tipoCadastro);
}
