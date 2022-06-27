package com.octaviorobleto.utilidades.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @author <a href="https://octaviorobleto.com" target="_blank">Octavio Robleto</a>
 * @version 1.0
 * @date 2022-06-27
 * @class Fecha
 *
 */
public final class Fecha {

	/**
	 * No permitir crear una instancia de esta clase
	 */
	private Fecha() {
	}

	/**
	 * Retorna una instancia LocalDate a partir de una cadena de texto con el
	 * formato indicado
	 * 
	 * @param fecha   con el formato indicado en el argumento
	 * @param formato formato a validar en la cadena fecha
	 * @return LocalDate
	 */
	public static LocalDate getLocalDateFromString(String fecha, String formato) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato));
	}

	/**
	 * Retorna una instancia LocalDateTime a partir de una cadena de texto con el
	 * formato indicado
	 * 
	 * @param fecha   con el formato indicado en el argumento
	 * @param formato formato a validar en la cadena fecha
	 * @return LocalDateTime
	 */
	public static LocalDateTime getLocalDateTimeFromString(String fecha, String formato) {
		return LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern(formato));
	}

	/**
	 * Retorna una cadena de texto a partir de un LocalDate con el formato indicado
	 * 
	 * @param fecha   LocalDate
	 * @param formato formato a validar en la cadena fecha
	 * @return String
	 */

	public static String getStringFromLocalDate(LocalDate fecha, String formato) {
		return fecha.format(DateTimeFormatter.ofPattern(formato));
	}

	/**
	 * Retorna una cadena de texto a partir de un LocalDateTime con el formato
	 * indicado
	 * 
	 * @param fecha   LocalDateTime
	 * @param formato formato a validar en la cadena fecha
	 * @return String
	 */
	public static String getStringFromLocalDateTime(LocalDateTime fecha, String formato) {
		return fecha.format(DateTimeFormatter.ofPattern(formato));
	}

	/**
	 * Retorna una cadena de texto a partir de un Date con el formato indicado
	 * 
	 * @param fecha   Date
	 * @param formato formato a validar en la cadena fecha
	 * @return String
	 */
	public static String getStringFromDate(Date fecha, String formato) {
		return new SimpleDateFormat(formato).format(fecha);
	}

	/**
	 * Retorna una instancia Date a partir de un de una cadena con el formato
	 * indicado
	 * 
	 * @param fecha   con el formato indicado en el argumento
	 * @param formato formato a validar en la cadena fecha
	 * @return Date
	 */
	public static Date getDateFromString(String fecha, String formato) {
		try {
			return new SimpleDateFormat(formato).parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna una instancia Date a partir de un LocalDate
	 * 
	 * @param localDate
	 * @return Date
	 */

	public static Date getDateFromLocalDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Retorna una instancia Date a partir de un LocalDateTime
	 * 
	 * @param localDateTime
	 * @return Date
	 */
	public static Date getDateFromLocalDateTime(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Retorna una instancia LocalDate a partir de un Date
	 * 
	 * @param localDate
	 * @return Date
	 */
	public static LocalDate getLocalDateFromDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * Retorna una instancia LocalDateTime a partir de un Date
	 * 
	 * @param localDate
	 * @return Date
	 */
	public static LocalDateTime getLocalDateTimeFromDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
