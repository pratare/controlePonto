package com.itau.controlePonto.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ponto {

	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalDate data;
	
	private Duration duracao;
	
	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private String tipoPonto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Usuario usuario;
	
	public Ponto() {
		
	}

	public Ponto(LocalDate data, Duration duracao, LocalDateTime entrada, LocalDateTime saida, String tipoPonto) {
		super();
		this.data = data;
		this.duracao = duracao;
		this.entrada = entrada;
		this.saida = saida;
		this.tipoPonto = tipoPonto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}
		
}
