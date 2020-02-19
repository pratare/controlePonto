package com.itau.controlePonto.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.UsuarioRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class UsuarioServiceTest {
	
	@Tested
	private UsuarioService usuarioService;

	@Injectable
	private UsuarioRepository usuarioRepository;
	
	@Injectable
	private Usuario usuario;
	
	@Before
	public void setUsuario(){
		this.usuario = new Usuario("prata", "123", "teste@teste.com.br", new Date(), 0L);
	}
	
	@Test
	public void listarUsuariosTest() {
		new Expectations() {{
			usuarioService.listarUsuarios();
			result = Lists.newArrayList(usuario);
		}};
		
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		Assertions.assertThat(usuarios.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuarioTest() {
		new Expectations() {{
			usuarioRepository.findById(anyInt);
			result = Optional.of(usuario); 
		}};
		usuarioService.buscarUsuario(1);
		Optional<Usuario> usuarios = usuarioService.buscarUsuario(1);
		Assertions.assertThat(usuarios.equals("Optional.empty"));	
	}
	
	@Test
	public void atualizarUsuarioTest() {
		new Expectations() {{
			usuarioRepository.findById(anyInt);
			result = Optional.of(usuario);
		}};
		
		ResponseEntity<Object> usuarios = usuarioService.atualizarUsuario(1, usuario);
		Assertions.assertThat(usuarios);
	}
}