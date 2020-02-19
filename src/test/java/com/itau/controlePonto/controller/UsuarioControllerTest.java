package com.itau.controlePonto.controller;

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
import com.itau.controlePonto.service.UsuarioService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class UsuarioControllerTest {
	
	@Tested
	private UsuarioController usuarioController;
	
	@Injectable
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
	public void retornaTodosUsuariosTest() {
		new Expectations() {{
			usuarioService.listarUsuarios();
			result = Lists.newArrayList(usuario);
		}};
		
		List<Usuario> usuarios = usuarioController.retornaTodosUsuarios();
		Assertions.assertThat(usuarios.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuarioTest() {
		new Expectations() {{
			usuarioService.buscarUsuario(anyInt);
			result = Optional.of(usuario);
		}};
		
		Optional<Usuario> usuarios = usuarioController.buscarUsuario(1);
		Assertions.assertThat(usuarios.equals("Optional.empty"));
	}
	
	@Test
	public void criarUsuarioTest() {
		ResponseEntity<Object> usuarios = usuarioController.criarUsuario(usuario);
		Assertions.assertThat(usuarios);
	}
	
	@Test
	public void atualizarUsuarioTest() {
		ResponseEntity<Object> usuarios = usuarioService.atualizarUsuario(1, usuario);
		Assertions.assertThat(usuarios);
	}
}