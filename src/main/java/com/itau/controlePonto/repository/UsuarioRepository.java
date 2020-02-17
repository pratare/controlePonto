package com.itau.controlePonto.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.controlePonto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
