package com.itau.controlePonto.controller;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import com.itau.controlePonto.helper.SomarHoras;
import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.PontoRepository;
import com.itau.controlePonto.repository.UsuarioRepository;
import com.itau.controlePonto.service.PontoService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import utils.MockObjeto;

@RunWith(JMockit.class)
public class PontoControllerTest {
	
	@Tested
	private PontoController pontoController;
	
	@Injectable
	private Usuario usuario;
	
	@Injectable
	private Ponto ponto;
	
	@Injectable
	private PontoService pontoService;
	
	@Injectable
	private PontoRepository pontoRepository;
	
	@Injectable
	private UsuarioRepository usuarioRepository;
	
	@Injectable
	private SomarHoras somarHoras;
	
	@Test
	public void listarPontosBatidosUsuarioTest() {
		new Expectations() {{
			Duration duracao = null;
			
			pontoService.listarPontosBatidosUsuario(anyInt);
			result = Lists.newArrayList(new Ponto(MockObjeto.getLocalDateMock(), duracao, MockObjeto.getLocalDateTimeSaidaMock(), MockObjeto.getLocalDateTimeEntradaMock(), "S"));
		}};
		
		List<Ponto> ponto = pontoController.listarPontosBatidosUsuario(1);
		Assertions.assertThat(ponto.size()).isEqualTo(1);
	}
	
	@Test
	public void baterPontoTest() {
		Duration duracao = null;
		
		ResponseEntity<Object> ponto = pontoService.baterPonto(1,new Ponto(MockObjeto.getLocalDateMock(), duracao, MockObjeto.getLocalDateTimeSaidaMock(), MockObjeto.getLocalDateTimeEntradaMock(), "S"));
		Assertions.assertThat(ponto);
	}
}
