package com.itau.controlePonto.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.itau.controlePonto.models.Usuario;

@Component
public class UsuarioComandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioComandLineRunner.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario(1,"Prata","32682714803", new Date());
		long insert = usuarioService.insert(usuario);
		log.info("novo usuario criado "+ usuario);
	}

}
