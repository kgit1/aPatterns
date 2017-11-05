package j8.DateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateExample {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		System.out.println(localDate + "  LocalDate.now");

		LocalDate localDateConstructed = LocalDate.of(2012, Month.MAY, 20);
		System.out.println(localDateConstructed + "  LocalDate.of");

		LocalDate localDateDayOfEpoch = LocalDate.ofEpochDay(99999);
		System.out.println(localDateDayOfEpoch + "  LocalDate.ofEpochDay");

		MonthDay monthDayApril16 = MonthDay.of(Month.APRIL, 16);
		Year yearNow = Year.now();

		LocalDate localDateApril16 = Year.of(Integer.parseInt(yearNow.toString())).atMonthDay(monthDayApril16);
		System.out.println(localDateApril16);

		for (int i = 1; i <= 5; i++) {

			localDateApril16 = yearNow.plusYears(i).atMonthDay(monthDayApril16);

			String year = String.valueOf(localDateApril16.getYear());
			String month = localDateApril16.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
			String dayOfMonth = String.valueOf(localDateApril16.getDayOfMonth());
			String dayOfWeek = localDateApril16.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

			System.out.format("%s of %s in %s on %s.%n", dayOfMonth, month, year, dayOfWeek);

		}

	}

}
