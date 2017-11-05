package j8.DateTime;

import java.time.LocalTime;

public class LocalTimeExample {

	public static void main(String[] args) {

		LocalTime localTimeNow = LocalTime.now();
		System.out.println(localTimeNow + " LocalTime.now()");

		LocalTime localTimeConstructed = LocalTime.of(8, 45);
		System.out.println(localTimeConstructed + " LocalTime.of(8, 45");

		LocalTime localTimeConstructedWithSeconds = LocalTime.of(8, 45, 12);
		System.out.println(localTimeConstructedWithSeconds + " LocalTime.of(8, 45, 12)");

		LocalTime localTimeConstructedWithNanoseconds = LocalTime.of(8, 45, 12, 111234);
		System.out.println(localTimeConstructedWithNanoseconds + " LocalTime.of(8, 45, 12, 111234)");

	}

}
