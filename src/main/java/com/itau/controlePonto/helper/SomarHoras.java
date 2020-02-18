package com.itau.controlePonto.helper;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class SomarHoras {
	
	public Duration horasTrabalhadas(LocalDateTime dataEnrada, LocalDateTime dataSaida) {
		Duration duracao = Duration.between(dataEnrada, dataSaida);
		return duracao;
		
	}
	
}
