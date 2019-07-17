package com.datedemo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Thomas Antony
 *
 */
@Component
public class DateUtil {

	/**
	 * Method to compute date difference between start and end date
	 * 
	 * @param fromDateStr
	 * @param toDateStr
	 * @return
	 */
	public long computeDateDiff(final String fromDateStr, final String toDateStr) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		final LocalDate firstDate = LocalDate.parse(fromDateStr, formatter);
		final LocalDate secondDate = LocalDate.parse(toDateStr, formatter);
		final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
		return days;
	}
}
