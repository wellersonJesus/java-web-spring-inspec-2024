package com.dev.inspec.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inspecao")
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String extraordinaria;

    @Column(columnDefinition = "DATE") 
    private LocalDate inicial;
    private String periodica_interna_externa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExtraordinaria() {
		return extraordinaria;
	}

	public void setExtraordinaria(String extraordinaria) {
		this.extraordinaria = extraordinaria;
	}

	public LocalDate getInicial() {
		return inicial;
	}

	public void setInicial(LocalDate inicial) {
		this.inicial = inicial;
	}

	public String getPeriodica_interna_externa() {
		return periodica_interna_externa;
	}

	public void setPeriodica_interna_externa(String periodica_interna_externa) {
		this.periodica_interna_externa = periodica_interna_externa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

