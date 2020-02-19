package com.itau.controlePonto.service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import com.itau.controlePonto.helper.SomarHoras;
import com.itau.controlePonto.models.Ponto;
import com.itau.controlePonto.models.Usuario;
import com.itau.controlePonto.repository.PontoRepository;
import com.itau.controlePonto.repository.UsuarioRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import utils.MockObjeto;

@RunWith(JMockit.class)
public class PontoServiceTest {

	@Tested
	private PontoService pontoService;
	
	@Injectable
	private PontoRepository pontoRepository;
	
	@Injectable
	private UsuarioRepository usuarioRepository;
	
	@Injectable
	private SomarHoras somarHoras;
	
	@Injectable
	private Usuario usuario;
	
	
	
	@Before
	public void setUsuario(){
		this.usuario = new Usuario("prata", "123", "teste@teste.com.br", new Date(), 0L);
		
	}
	
	@Test
	public void listarPontosBatidosUsuarioTest() {
		new Expectations() {{
			usuarioRepository.findById(anyInt);
			result = Optional.of(usuario);
		}};
		
		List<Ponto> userOptiona = pontoService.listarPontosBatidosUsuario(1);
		Assertions.assertThat(userOptiona);
	}
	
	@Test
	public void baterPontoTest() {
		new Expectations() {{
			usuarioRepository.findById(anyInt);
			result = Optional.of(usuario);
			
			Duration duracao = somarHoras.horasTrabalhadas(MockObjeto.getLocalDateTimeEntradaMock(), MockObjeto.getLocalDateTimeSaidaMock());
			
			pontoRepository.findByUsuario(usuario);
			result = Lists.newArrayList(new Ponto(MockObjeto.getLocalDateMock(), duracao, MockObjeto.getLocalDateTimeSaidaMock(), MockObjeto.getLocalDateTimeEntradaMock(), "E"));
		}};
		
		Duration duracao = somarHoras.horasTrabalhadas(MockObjeto.getLocalDateTimeEntradaMock(), MockObjeto.getLocalDateTimeSaidaMock());
		ResponseEntity<Object> ponto = pontoService.baterPonto(1,new Ponto(MockObjeto.getLocalDateMock(), duracao, MockObjeto.getLocalDateTimeSaidaMock(), MockObjeto.getLocalDateTimeEntradaMock(), "E"));
	}
	
}