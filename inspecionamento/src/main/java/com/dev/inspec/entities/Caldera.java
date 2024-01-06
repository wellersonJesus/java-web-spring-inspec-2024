package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caldera")
public class Caldera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ano_fabricao;
    private String capacidade_producao_vapor_saturado;
    private String categoria;
    private String codigo_projeto_ano_edicao;
    private String combustivel;
    private String marca;
    private String modelo;
    private String numero_ordem;
    private String pressao_teste_hidrostatico_fabricante;
    private String pressao_efetiva_operacao;
    private String sup_aquecimento;
    
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno_fabricao() {
		return ano_fabricao;
	}

	public void setAno_fabricao(String ano_fabricao) {
		this.ano_fabricao = ano_fabricao;
	}

	public String getCapacidade_producao_vapor_saturado() {
		return capacidade_producao_vapor_saturado;
	}

	public void setCapacidade_producao_vapor_saturado(String capacidade_producao_vapor_saturado) {
		this.capacidade_producao_vapor_saturado = capacidade_producao_vapor_saturado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo_projeto_ano_edicao() {
		return codigo_projeto_ano_edicao;
	}

	public void setCodigo_projeto_ano_edicao(String codigo_projeto_ano_edicao) {
		this.codigo_projeto_ano_edicao = codigo_projeto_ano_edicao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumero_ordem() {
		return numero_ordem;
	}

	public void setNumero_ordem(String numero_ordem) {
		this.numero_ordem = numero_ordem;
	}

	public String getPressao_teste_hidrostatico_fabricante() {
		return pressao_teste_hidrostatico_fabricante;
	}

	public void setPressao_teste_hidrostatico_fabricante(String pressao_teste_hidrostatico_fabricante) {
		this.pressao_teste_hidrostatico_fabricante = pressao_teste_hidrostatico_fabricante;
	}

	public String getPressao_efetiva_operacao() {
		return pressao_efetiva_operacao;
	}

	public void setPressao_efetiva_operacao(String pressao_efetiva_operacao) {
		this.pressao_efetiva_operacao = pressao_efetiva_operacao;
	}

	public String getSup_aquecimento() {
		return sup_aquecimento;
	}

	public void setSup_aquecimento(String sup_aquecimento) {
		this.sup_aquecimento = sup_aquecimento;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
}

