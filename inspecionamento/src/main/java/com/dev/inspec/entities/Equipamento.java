package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caldera;
    private String vaso_de_pressao;
    private String tubulacao;
    private String tanque_metalico;
    
    @ManyToOne
    @JoinColumn(name = "inspecao_id")
    private Inspecao inspecao;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaldera() {
		return caldera;
	}

	public void setCaldera(String caldera) {
		this.caldera = caldera;
	}

	public String getVaso_de_pressao() {
		return vaso_de_pressao;
	}

	public void setVaso_de_pressao(String vaso_de_pressao) {
		this.vaso_de_pressao = vaso_de_pressao;
	}

	public String getTubulacao() {
		return tubulacao;
	}

	public void setTubulacao(String tubulacao) {
		this.tubulacao = tubulacao;
	}

	public String getTanque_metalico() {
		return tanque_metalico;
	}

	public void setTanque_metalico(String tanque_metalico) {
		this.tanque_metalico = tanque_metalico;
	}

	public Inspecao getInspecao() {
		return inspecao;
	}

	public void setInspecao(Inspecao inspecao) {
		this.inspecao = inspecao;
	}
}

