package com.dev.inspec.dto;

public class tipo_clienteDTO {
	private Long id;
	private String PESSOAFISICA;
	private String PESSOAJURIDICA;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPESSOAFISICA() {
		return PESSOAFISICA;
	}

	public void setPESSOAFISICA(String pESSOAFISICA) {
		PESSOAFISICA = pESSOAFISICA;
	}

	public String getPESSOAJURIDICA() {
		return PESSOAJURIDICA;
	}

	public void setPESSOAJURIDICA(String pESSOAJURIDICA) {
		PESSOAJURIDICA = pESSOAJURIDICA;
	}
}
