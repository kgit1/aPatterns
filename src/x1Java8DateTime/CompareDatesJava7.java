package x1Java8DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//	 2 ways to compare given dates in Java without using * any third party
//	 library e.g. joda time
public class CompareDatesJava7 {

	public static void main(String args[]) {
		Calendar todayCalendar = new GregorianCalendar(2015, Calendar.AUGUST,
				24);
		Calendar yesterdayCalendar = new GregorianCalendar(2015,
				Calendar.AUGUST, 23);
		Date today = todayCalendar.getTime();
		Date yesterday = yesterdayCalendar.getTime();

		// comparing dates using equals() method in Java
		// today and yesterday is not equal
		if (today.equals(yesterday)) {
			System.out.println("two given dates are equal to each other");
		} else {
			System.out.println("two dates are not equal to each other ");
		}

		// you can also check if two dates are equal or not using
		// compareTo() method, java.util.Date implements
		// Comparable and its compareTo() is consistent with equals()
		if (yesterday.compareTo(today) == 0) {
			System.out.println("Given dates are same");
		} else {
			System.out.println("Given dates are different ");
		}

		// checking which dates comes first
		// you can use before() and after() method of Calendar class
		if (todayCalendar.after(yesterdayCalendar)) {
			System.out.println("first date comes after second date");
		}

		// Date class also has their own before() and after() method
		if (yesterday.before(today)) {
			System.out.println("yesterday comes before today");
		}
	}
}
