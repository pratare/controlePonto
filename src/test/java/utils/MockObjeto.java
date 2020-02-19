package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MockObjeto {
	
	public static LocalDate getLocalDateMock() {
		LocalDate date = LocalDate.parse("2017-02-05");
		return date;
	}
	
	public static LocalDateTime getLocalDateTimeSaidaMock() {
		String strSaida = "2016-03-04 11:30:40";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTimeSaida = LocalDateTime.parse(strSaida, formatter);
		return dateTimeSaida;
	}
	
	public static LocalDateTime getLocalDateTimeEntradaMock() {
		String strEntrada = "2016-03-04 11:30:40";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTimeEntrada = LocalDateTime.parse(strEntrada, formatter);
		return dateTimeEntrada;
	}
	
	
}
