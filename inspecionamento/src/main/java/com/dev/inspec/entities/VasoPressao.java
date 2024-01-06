package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vaso_pressao")
public class VasoPressao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoria_id;
	private String codigo_projeto;
	private String codigo_vaso;
	private String comprimento_costado;
	private String diametro_interno;
	private String fabricante;
	private String pressao_interna_projeto;
	private String pressao_trabalho;
	private String pressao_teste_hidrostatico;
	private String proprietario_vaso;
	private String serie;
	private String temperatura_interna_projeto;
	private String tipo_vaso;
	private String vaso_id_tag;
	private String volume;

	@ManyToOne
	@JoinColumn(name = "equipamento_id")
	private Equipamento equipamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getCodigo_projeto() {
		return codigo_projeto;
	}

	public void setCodigo_projeto(String codigo_projeto) {
		this.codigo_projeto = codigo_projeto;
	}

	public String getCodigo_vaso() {
		return codigo_vaso;
	}

	public void setCodigo_vaso(String codigo_vaso) {
		this.codigo_vaso = codigo_vaso;
	}

	public String getComprimento_costado() {
		return comprimento_costado;
	}

	public void setComprimento_costado(String comprimento_costado) {
		this.comprimento_costado = comprimento_costado;
	}

	public String getDiametro_interno() {
		return diametro_interno;
	}

	public void setDiametro_interno(String diametro_interno) {
		this.diametro_interno = diametro_interno;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPressao_interna_projeto() {
		return pressao_interna_projeto;
	}

	public void setPressao_interna_projeto(String pressao_interna_projeto) {
		this.pressao_interna_projeto = pressao_interna_projeto;
	}

	public String getPressao_trabalho() {
		return pressao_trabalho;
	}

	public void setPressao_trabalho(String pressao_trabalho) {
		this.pressao_trabalho = pressao_trabalho;
	}

	public String getPressao_teste_hidrostatico() {
		return pressao_teste_hidrostatico;
	}

	public void setPressao_teste_hidrostatico(String pressao_teste_hidrostatico) {
		this.pressao_teste_hidrostatico = pressao_teste_hidrostatico;
	}

	public String getProprietario_vaso() {
		return proprietario_vaso;
	}

	public void setProprietario_vaso(String proprietario_vaso) {
		this.proprietario_vaso = proprietario_vaso;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTemperatura_interna_projeto() {
		return temperatura_interna_projeto;
	}

	public void setTemperatura_interna_projeto(String temperatura_interna_projeto) {
		this.temperatura_interna_projeto = temperatura_interna_projeto;
	}

	public String getTipo_vaso() {
		return tipo_vaso;
	}

	public void setTipo_vaso(String tipo_vaso) {
		this.tipo_vaso = tipo_vaso;
	}

	public String getVaso_id_tag() {
		return vaso_id_tag;
	}

	public void setVaso_id_tag(String vaso_id_tag) {
		this.vaso_id_tag = vaso_id_tag;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
}
