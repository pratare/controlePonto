package com.itau.controlePonto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.models.Usuario;

public interface PontoRepository extends JpaRepository<Ponto, Integer>{
	
	public List<Ponto> findByUsuario(Usuario usuario);

}
