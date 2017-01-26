package x1Java8DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseConvertStringToDateJava8 {
	// Java Program to demonstrate how to use DateTimeFormatter class
	// to parse String to date in Java 8 and format date to String in
	// various formats e.g. dd-MM-yyyy * * @author WINDOWS 8
	public static void main(String args[]) {
		// BASIC_ISO_DATE formatter can parse date in yyyyMMdd format
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		LocalDate date = LocalDate.parse("20150927", formatter);
		System.out.println("date string : 20150927, " + "localdate : " + date);
		System.out.println();

		// The ISO date formatter format or parse date in yyyy-MM-dd format
		// such as '2015-09-27' or '2015-09-27+01:00'
		// This is also the default format of LocalDate, if you print LocalDate
		// it prints date in this format only.
		formatter = DateTimeFormatter.ISO_DATE;
		date = LocalDate.parse("2015-09-27", formatter);
		System.out
				.println("date string : 2015-09-27, " + "localdate : " + date);
		System.out.println();

		// dd/MM/yyyy is also known as British or French date format, popular
		// in England, India and France.
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse("27/09/2015", formatter);
		System.out
				.println("date string : 27/09/2015, " + "localdate : " + date);
		System.out.println();

		// MM/dd/yyyy is also known USA standard date format
		formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		date = LocalDate.parse("09/27/2015", formatter);
		System.out
				.println("date string : 09/27/2015, " + "localdate : " + date);
		System.out.println();

		// parsing date in dd-MMM-yy format e.g. 27-SEP-2015
		// Make sure you set the default Local to Locale.US otherwise parsing
		// will fail because default local may not understand what 'SEP' means
		// formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		// date = LocalDate.parse("27-Sep-2015", formatter);
		// System.out
		// .println("date string : 27-Sep-2015, " + "localdate : " + date);
	}
}
