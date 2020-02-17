package com.itau.controlePonto.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String codigo;
	private String mensagem;
	
	public ExceptionResponse(Date timestamp, String codigo, String mensagem) {
		super();
		this.timestamp = timestamp;
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
