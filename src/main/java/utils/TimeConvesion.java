package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeConvesion {
	public static LocalDate fromDateToLocalDate(Date date) {
		return date.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
	}
	
	public static Long diasEntre(LocalDate inicio, LocalDate fin) {
		return ChronoUnit.DAYS.between(inicio, fin);
	}
}
