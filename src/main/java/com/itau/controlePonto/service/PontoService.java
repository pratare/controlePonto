package com.itau.controlePonto.service;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itau.controlePonto.exception.UserNotFoundException;
import com.itau.controlePonto.helper.SomarHoras;
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
	
	@Autowired
	private SomarHoras somarHoras;
	
	public List<Ponto> listarPontosBatidosUsuario(int id) {
		
		Optional<Usuario> userOptional = usuarioRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return userOptional.get().getPontos();
	}
	
	public ResponseEntity<Object> baterPonto(int id, Ponto tipoPonto) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
				
		Usuario usuario = user.get();
		Ponto apontamento = null;
		
		if("E".equals(tipoPonto.getTipoPonto())) {
			apontamento = new Ponto();
			apontamento.setUsuario(usuario);
			apontamento.setData(LocalDate.now());
			apontamento.setEntrada(LocalDateTime.now());
		}
		else {
			List<Ponto> pontos = pontoRepository.findByUsuario(usuario);
			apontamento = pontos.get(pontos.size()-1);
			apontamento.setSaida(LocalDateTime.now());
			apontamento.setDuracao(somarHoras.horasTrabalhadas(apontamento.getEntrada(), apontamento.getSaida()));
			usuario.setTotalHorasTrabalhadas(usuario.getTotalHorasTrabalhadas()+apontamento.getDuracao().toNanos());
			usuarioRepository.save(usuario);
		}
		
		pontoRepository.save(apontamento);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(apontamento.getId()).toUri();
			
		return ResponseEntity.created(location).build();
		
	}

}
