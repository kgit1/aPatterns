package x;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

// Java Program to demonstrate How to use LocalDateTime class in Java 8.
// LocalDateTime is LocalDate + LocalTime, i.e. date with time
public class LocalDateTimeJava8 {

	public static void main(String args[]) {
		// LocalDate is date without time in Java 8
		// LocalTime is time without date in Java 8
		// LocalDateTime is both date and time e.g. LocalDate + LocalTime
		// but without Timezone information
		// LocalDateTime.now() creates a LocalDateTieme object with current
		// date and time
		LocalDateTime rightNow = LocalDateTime.now();
		System.out.println("current datetime : " + rightNow);
		System.out.println();

		// LocalDateTime.of() method is a factory method to careate
		// LocalDateTiem with specific date and time
		LocalDateTime aDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30,
				40);
		System.out.println("some datetime : " + aDateTime);
		System.out.println();

		// You can also create LocalDateTime object by combining LocalDate
		// and LocalTime
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime fromDateAndTime = LocalDateTime.of(currentDate,
				currentTime);
		System.out.println("LocalDateTime created by combining LocalDate"
				+ " and LocalTime \n" + fromDateAndTime);
		System.out.println();

		// You can also retrieve LocalDate and LocalTime from LocalDateTime
		LocalDate retrievedDate = fromDateAndTime.toLocalDate();
		LocalTime retrievedTime = fromDateAndTime.toLocalTime();
		System.out.println("retreived LocalDate : " + retrievedDate);
		System.out.println("retreived LocalTime : " + retrievedTime);
	}

}
