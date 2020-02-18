package com.itau.controlePonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}