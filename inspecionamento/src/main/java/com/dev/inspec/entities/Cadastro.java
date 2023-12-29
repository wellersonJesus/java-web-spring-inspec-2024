package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contato;
	private String cpf_ou_cnpj;
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "tipoCadastro_id")
	private TipoCliente tipoCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf_ou_cnpj() {
		return cpf_ou_cnpj;
	}

	public void setCpf_ou_cnpj(String cpf_ou_cnpj) {
		this.cpf_ou_cnpj = cpf_ou_cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoCliente getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCliente tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
}
