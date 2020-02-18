package com.itau.controlePonto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> retornaTodosUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> buscarUsuario(@PathVariable int id) {
		return usuarioService.buscarUsuario(id);
	}

	@PostMapping("/usuario")
	public ResponseEntity<Object> criarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.criar(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Object> atualizarUsuario(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(id, usuario); 
	}

}
