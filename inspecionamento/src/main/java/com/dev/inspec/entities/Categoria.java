package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoria;

	@ManyToOne
	@JoinColumn(name = "vaso_pressao_id")
	private VasoPressao vaso_pressao;

	public Long getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VasoPressao getVaso_pressao() {
		return vaso_pressao;
	}

	public void setVaso_pressao(VasoPressao vaso_pressao) {
		this.vaso_pressao = vaso_pressao;
	}
}
