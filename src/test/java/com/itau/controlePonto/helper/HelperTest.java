package com.itau.controlePonto.helper;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import utils.MockObjeto;

@RunWith(JMockit.class)
public class HelperTest {
	
	@Tested
	private SomarHoras somarHoras;
	
	@Test
	public void horasTrabalhadasTest() {
		Duration duracao = somarHoras.horasTrabalhadas(MockObjeto.getLocalDateTimeEntradaMock(), MockObjeto.getLocalDateTimeSaidaMock());
		Assertions.assertThat(duracao.equals("PT-7H"));
	}
}