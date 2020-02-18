package com.itau.controlePonto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
