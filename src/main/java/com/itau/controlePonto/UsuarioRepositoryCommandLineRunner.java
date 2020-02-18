package com.itau.controlePonto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.UsuarioRepository;

@Component
public class UsuarioRepositoryCommandLineRunner implements CommandLineRunner{
	
private static final Logger log = LoggerFactory.getLogger(UsuarioRepositoryCommandLineRunner.class);
	
	@Autowired
	private UsuarioRepository usuarioRepositoy;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("Gracia","8764325671", "gracia.prata@hotmail.com", new Date(), 0);
		usuarioRepositoy.save(usuario);
		log.info("novo usuario criado "+ usuario);
		
		Optional<Usuario> user = usuarioRepositoy.findById(1);
		log.info("usuario selecionado é "+ user);
		
		List<Usuario> usuarios = usuarioRepositoy.findAll();
		log.info("a lista de usuarios "+ usuarios);
		
	}

}
