package com.itau.controlePonto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.models.Usuario;

public interface PontoRepository extends JpaRepository<Ponto, Integer>{
	
//	public Optional<Ponto> findByUsuario(Usuario usuario);
	
	public List<Ponto> findByUsuario(Usuario usuario);

}
