package com.itau.controlePonto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itau.controlePonto.models.Usuario;

@Component
public class UsuarioService {
	
private static List<Usuario> usuarios = new ArrayList<>();
	
	private static int contadorUsuario = 0;
	
	public List<Usuario> findAll() {
		return usuarios;
	}
	
	public Usuario criar(Usuario usuario) {
		if(usuario.getId() == null) {
			usuario.setId(++contadorUsuario);
		}
		usuarios.add(usuario);
		
		return usuario;
	}
	
	public Usuario findOne(int id) {
		for(Usuario usuario:usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

}
