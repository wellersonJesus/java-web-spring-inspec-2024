package com.dev.inspec.dto;

public class CadastroDTO {
	private Long id;
	private String contato;
	private tipo_cadastroDTO tipoCadastro;

	public CadastroDTO(Long id, String contato, tipo_cadastroDTO tipoCadastro) {
		this.id = id;
		this.contato = contato;
		this.tipoCadastro = tipoCadastro;
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

	public tipo_cadastroDTO getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(tipo_cadastroDTO tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

}
