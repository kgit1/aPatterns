package j8.DateTime.OldExamples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateAndTime {
	public static void main(String[] args) {
		// current date and time in Java
		Date today = new Date();
		System.out.println("current date and time: " + today);

		// displaying only current date in Java
		Date currentDate = new java.sql.Date(today.getTime());
		System.out.println("current date: " + currentDate);

		// displaying only current time in Java
		Date currentTime = new java.sql.Time(today.getTime());
		System.out.println("current time: " + currentTime);

		// today's date in ddMMyyyy in Java
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String todayDate = df.format(today);
		System.out.println("Today's date in dd-MM-yyyy format: " + todayDate);

		// today's date in mm/dd/yyyy format
		df = new SimpleDateFormat("MM/dd/yyyy");
		todayDate = df.format(today);
		System.out.println("Today's date in MM/dd/yyyy format: " + todayDate);
	}
}
