package com.itau.controlePonto.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itau.controlePonto.exception.UserNotFoundException;
import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.UsuarioRepository;

@Component
public class UsuarioService {
	
@Autowired
private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> buscarUsuario(int id) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return usuarioRepository.findById(id);
	}
	
	public ResponseEntity<Object> criar(Usuario usuario) {
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(usuarioCriado.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	public ResponseEntity<Object> atualizarUsuario(int id, Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		usuario.setId(id);
		usuario.setCadastro(user.get().getCadastro());
		usuarioRepository.save(usuario);
				
		return ResponseEntity.ok().build();

	}
		 

}
		

	
