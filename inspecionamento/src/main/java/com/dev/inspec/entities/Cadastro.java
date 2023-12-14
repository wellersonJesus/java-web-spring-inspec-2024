package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contato;
	private String cpfoucnpj;
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "tipo_cadastro_id")
	private TipoCadastro tipoCadastro;
	
	public Cadastro() {
	}

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

	public String getCpfoucnpj() {
		return cpfoucnpj;
	}

	public void setCpfoucnpj(String cpfoucnpj) {
		this.cpfoucnpj = cpfoucnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoCadastro getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
}
