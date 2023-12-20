package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cliente")
public class TipoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pessoaFisica;
	private String pessoaJuridica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(String pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public String getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(String pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getNome() {
		return null;
	}

	public void setNome(String nome) {
	}

}