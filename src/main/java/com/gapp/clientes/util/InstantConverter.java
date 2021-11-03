package com.gapp.clientes.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class InstantConverter {

	public Instant converter(String value) {
		if(value == null) {
			return null;
		}
			
		return LocalDate
			.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US))
			.atStartOfDay()
			.atZone(ZoneId.of("America/Sao_Paulo"))
			.toInstant();
	}
}