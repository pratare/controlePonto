package com.itau.controlePonto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itau.controlePonto.exception.UserNotFoundException;
import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.UsuarioRepository;
import com.itau.controlePonto.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> retornaTodosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> buscarUsuario(@PathVariable int id) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return usuarioRepository.findById(id);
	}

	@PostMapping("/usuario")
	public ResponseEntity<Object> criarUsuario(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(usuarioCriado.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Object> atualizarUsuario(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioRepository.save(usuario);
		
		ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuarioAtualizado.getId()).toUri();
		
		return ResponseEntity.ok().build(); 
	}

}
