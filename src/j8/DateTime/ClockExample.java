package j8.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;

public class ClockExample {

	public static void main(String[] args) {

		// old
		long systemCurrentTime = System.currentTimeMillis();
		System.out.println(systemCurrentTime + "  currentTimeMillis");

		Date currentDate = new Date(systemCurrentTime);
		System.out.println(currentDate + "  old date from currentTimeMillis");

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(systemCurrentTime);
		System.out.println(calendar.getTime() + "  calendar.getTime");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		System.out.println(simpleDateFormat.format(calendar.getTime()) + "  formated calendar.getTime");

		// new
		Clock clock = Clock.systemDefaultZone();//or Clock clock = Clock.systemUTC();
		long milliseconds = clock.millis();
		System.out.println(milliseconds + "  clock.millis");

		Instant instant = clock.instant();
		System.out.println(instant + "  instant class time-point");

		Date legacyDate1 = new Date(milliseconds);
		System.out.println(legacyDate1 + "  old date from clock.millis");

		Date legacyDate2 = Date.from(instant);
		System.out.println(legacyDate2 + "  old date from instant");

	}

}
