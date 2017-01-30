package x1.Java8DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

//Java Program to demonstrate how to convert Date to LocalDateTime class in 
//Java 8. Just remember that, the equivalent class of Date in new Date and Time 
//API is not LocalDateTime but the Instant.
public class ConvertDateToLocalDate {

	public static void main(String args[]) {
		// converting java.util.Date to java.time.LocalDateTime
		Date now = new Date();
		Instant current = now.toInstant();
		LocalDateTime ldt = LocalDateTime.ofInstant(current,
				ZoneId.systemDefault());
		System.out.println("value of Date: " + now);
		System.out.println("value of LocalDateTime: " + ldt);

		// converting java 8 LocalDateTime to java.util.Date
		ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
		Date output = Date.from(zdt.toInstant());
		System.out.println("value of LocalDateTime: " + ldt);
		System.out.println("value of Date: " + output);
	}
}


