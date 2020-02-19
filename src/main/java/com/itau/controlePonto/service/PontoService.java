package com.itau.controlePonto.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itau.controlePonto.exception.UserNotFoundException;
import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.PontoRepository;
import com.itau.controlePonto.repository.UsuarioRepository;

@Component
public class PontoService {
	
	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Ponto> listarPontosBatidosUsuario(int id) {
		
		Optional<Usuario> userOptional = usuarioRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return userOptional.get().getPontos();
	}
	
	public ResponseEntity<Object> baterPonto(int id, Ponto ponto) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		
		Usuario usuario = user.get();
		ponto.setUsuario(usuario);
		pontoRepository.save(ponto);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(ponto.getId()).toUri();
			
		return ResponseEntity.created(location).build();
		
	}

}
