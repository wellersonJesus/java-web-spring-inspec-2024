package com.dev.inspec.dto;

public class ClienteDTO {
	private Long id;
	private String contato;
	private tipo_cadastroDTO tipoCadastro;

	public ClienteDTO(Long id, String contato, tipo_cadastroDTO tipoClienteDTO) {
		this.id = id;
		this.setContato(contato);
		this.tipoCadastro = tipoClienteDTO;
	}

	public ClienteDTO(Long id2, String cliente, tipo_clienteDTO tipoClienteDTO) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public tipo_cadastroDTO getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(tipo_cadastroDTO tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
}
