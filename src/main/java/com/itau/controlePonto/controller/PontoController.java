package com.itau.controlePonto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.service.PontoService;

@RestController
public class PontoController {
	
	@Autowired
	private PontoService pontoService;
	
	@GetMapping("/usuarios/{id}/ponto")
	public List<Ponto> listarPontosBatidosUsuario(@PathVariable int id){
		return pontoService.listarPontosBatidosUsuario(id);
	}
	
	@PostMapping("/usuario/{id}/ponto")
	public ResponseEntity<Object> baterPonto(@PathVariable int id, @Valid @RequestBody Ponto ponto) {
		return pontoService.baterPonto(id,ponto);
	}

}
