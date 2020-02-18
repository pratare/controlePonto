package com.itau.controlePonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.controlePonto.models.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Integer>{

}
