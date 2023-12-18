package com.dev.inspec.dto;

public class CadastroDTO {
	private Long id;
	private String contato;

	public CadastroDTO(Long id, String contato) {
		this.id = id;
		this.contato = contato;
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

}
