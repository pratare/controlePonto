package com.itau.controlePonto.models;

import java.util.Date;

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
	
	private Date horario;
	
	private String tipoBatida;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Usuario usuario;
	
	public Ponto() {
		
	}

	public Ponto(Date horario, String tipoBatida) {
		super();
		
		this.horario = horario;
		this.tipoBatida = tipoBatida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getTipoBatida() {
		return tipoBatida;
	}

	public void setTipoBatida(String tipoBatida) {
		this.tipoBatida = tipoBatida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
