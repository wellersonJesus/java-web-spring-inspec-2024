package com.dev.inspec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tubulacao")
public class Tubulacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@SuppressWarnings("unused")
	private String dados_localizacao_identificacao;
	private String dados_soldagem;
	private String documentacao_projeto;
	private String documentacao_regulatoria;
	private String historico_manutencao;
	private String informacoes_operacao;
	private String inspecao_visual;
	private String monitoramento_corrosao;
	private String registros_juntas;
	private String registros_teste_pressao;
	private String registros_certificacao_pessoal;
	private String testes_nao_destrutivos;
	private String testes_hidrostaticos;

	@ManyToOne
	@JoinColumn(name = "equipamento_id")
	private Equipamento equipamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static String getDados_localizacao_identificacao() {
		return null;
	}

	public void setDados_localizacao_identificacao(String dados_localizacao_identificacao) {
		this.dados_localizacao_identificacao = dados_localizacao_identificacao;
	}

	public String getDados_soldagem() {
		return dados_soldagem;
	}

	public void setDados_soldagem(String dados_soldagem) {
		this.dados_soldagem = dados_soldagem;
	}

	public String getDocumentacao_projeto() {
		return documentacao_projeto;
	}

	public void setDocumentacao_projeto(String documentacao_projeto) {
		this.documentacao_projeto = documentacao_projeto;
	}

	public String getDocumentacao_regulatoria() {
		return documentacao_regulatoria;
	}

	public void setDocumentacao_regulatoria(String documentacao_regulatoria) {
		this.documentacao_regulatoria = documentacao_regulatoria;
	}

	public String getHistorico_manutencao() {
		return historico_manutencao;
	}

	public void setHistorico_manutencao(String historico_manutencao) {
		this.historico_manutencao = historico_manutencao;
	}

	public String getInformacoes_operacao() {
		return informacoes_operacao;
	}

	public void setInformacoes_operacao(String informacoes_operacao) {
		this.informacoes_operacao = informacoes_operacao;
	}

	public String getInspecao_visual() {
		return inspecao_visual;
	}

	public void setInspecao_visual(String inspecao_visual) {
		this.inspecao_visual = inspecao_visual;
	}

	public String getMonitoramento_corrosao() {
		return monitoramento_corrosao;
	}

	public void setMonitoramento_corrosao(String monitoramento_corrosao) {
		this.monitoramento_corrosao = monitoramento_corrosao;
	}

	public String getRegistros_juntas() {
		return registros_juntas;
	}

	public void setRegistros_juntas(String registros_juntas) {
		this.registros_juntas = registros_juntas;
	}

	public String getRegistros_teste_pressao() {
		return registros_teste_pressao;
	}

	public void setRegistros_teste_pressao(String registros_teste_pressao) {
		this.registros_teste_pressao = registros_teste_pressao;
	}

	public String getRegistros_certificacao_pessoal() {
		return registros_certificacao_pessoal;
	}

	public void setRegistros_certificacao_pessoal(String registros_certificacao_pessoal) {
		this.registros_certificacao_pessoal = registros_certificacao_pessoal;
	}

	public String getTestes_nao_destrutivos() {
		return testes_nao_destrutivos;
	}

	public void setTestes_nao_destrutivos(String testes_nao_destrutivos) {
		this.testes_nao_destrutivos = testes_nao_destrutivos;
	}

	public String getTestes_hidrostaticos() {
		return testes_hidrostaticos;
	}

	public void setTestes_hidrostaticos(String testes_hidrostaticos) {
		this.testes_hidrostaticos = testes_hidrostaticos;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
}
