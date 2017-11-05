package j8.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime + "  LocalDateTime.now()\n");

		System.out.println(ZoneId.getAvailableZoneIds());

		LocalDateTime localDateTimeWithTimeZone = LocalDateTime.now(ZoneId.of("America/Cuiaba"));
		System.out.println(localDateTimeWithTimeZone + "  LocalDateTime.now(ZoneId.of(\"America/Cuiaba\"))\n");

		LocalDateTime localDateTimeConstructed = LocalDateTime.of(2012, Month.JANUARY, 22, 16, 1, 20);
		System.out.println(localDateTimeConstructed + "  LocalDateTime.of(2012,  Month.JANUARY, 22, 16, 1,20)\n");

		LocalDate localDate = LocalDate.of(1920, Month.FEBRUARY, 12);
		LocalTime localTime = LocalTime.of(20, 15);
		LocalDateTime localDateTimeFromDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTimeFromDateTime + "  LocalDateTime.of(localDate, localTime)\n");

		String now = "2016-12-09 22:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTimeFromString = LocalDateTime.parse(now, formatter);
		System.out.println(localDateTimeFromString);

		String formatPattern1 = "yyyy-MM-dd HH:mm:ss";
		String formatPattern2 = "HH:mm:ss yyyy/MM/dd";
		String formatPattern3 = "yyyy-MMMM-dd-EEEE HH:mm:ss";// EEEE - day of week word
		String formatPattern4 = "yyyy-MMMM-dd-ee HH:mm:ss";// ee - day of week number
		formatter = DateTimeFormatter.ofPattern(formatPattern1);
		System.out.println(formatter.format(localDateTime));
		formatter = DateTimeFormatter.ofPattern(formatPattern2);
		System.out.println(formatter.format(localDateTime));
		formatter = DateTimeFormatter.ofPattern(formatPattern3);
		System.out.println(formatter.format(localDateTime));
		formatter = DateTimeFormatter.ofPattern(formatPattern4);
		System.out.println(formatter.format(localDateTime));

		// Symbol Meaning Presentation Examples
		// * ------ ------- ------------ -------
		// * G era text AD; Anno Domini; A
		// * u year year 2004; 04
		// * y year-of-era year 2004; 04
		// * D day-of-year number 189
		// * M/L month-of-year number/text 7; 07; Jul; July; J
		// * d day-of-month number 10
		// *
		// * Q/q quarter-of-year number/text 3; 03; Q3; 3rd quarter
		// * Y week-based-year year 1996; 96
		// * w week-of-week-based-year number 27
		// * W week-of-month number 4
		// * E day-of-week text Tue; Tuesday; T
		// * e/c localized day-of-week number/text 2; 02; Tue; Tuesday; T
		// * F week-of-month number 3
		// *
		// * a am-pm-of-day text PM
		// * h clock-hour-of-am-pm (1-12) number 12
		// * K hour-of-am-pm (0-11) number 0
		// * k clock-hour-of-am-pm (1-24) number 0
		// *
		// * H hour-of-day (0-23) number 0
		// * m minute-of-hour number 30
		// * s second-of-minute number 55
		// * S fraction-of-second fraction 978
		// * A milli-of-day number 1234
		// * n nano-of-second number 987654321
		// * N nano-of-day number 1234000000
		// *
		// * V time-zone ID zone-id America/Los_Angeles; Z; -08:30
		// * z time-zone name zone-name Pacific Standard Time; PST
		// * O localized zone-offset offset-O GMT+8; GMT+08:00; UTC-08:00;
		// * X zone-offset 'Z' for zero offset-X Z; -08; -0830; -08:30; -083015;
		// -08:30:15;
		// * x zone-offset offset-x +0000; -08; -0830; -08:30; -083015; -08:30:15;
		// * Z zone-offset offset-Z +0000; -0800; -08:00;
		// *
		// * p pad next pad modifier 1
		// *
		// * ' escape for text delimiter
		// * '' single quote literal '
		// * [ optional section start
		// * ] optional section end
		// * # reserved for future use
		// * { reserved for future use
		// * } reserved for future use
	}

}
