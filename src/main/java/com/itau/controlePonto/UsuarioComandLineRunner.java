package com.itau.controlePonto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.service.UsuarioService;

@Component
public class UsuarioComandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioComandLineRunner.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("Prata","32682714803", new Date());
		Usuario insert = usuarioService.criar(usuario);
		log.info("novo usuario criado "+ usuario);
	}

}
