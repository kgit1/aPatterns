package j8.DateTime.OldExamples;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseConvertStringToDateJava7 {

	public static void main(String[] args) throws ParseException {
		DateFormat formatter = null;
		Date convertedDate = null;

		// Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
		String yyyyMMdd = "20110914";
		formatter = new SimpleDateFormat("yyyyMMdd");
		convertedDate = (Date) formatter.parse(yyyyMMdd);
		System.out.println(
				"Date from yyyyMMdd String in Java : " + convertedDate);

		// convert string to date with ddMMyyyy format example "14092011"
		String ddMMyyyy = "14092011";
		formatter = new SimpleDateFormat("ddMMyyyy");
		convertedDate = (Date) formatter.parse(ddMMyyyy);
		System.out.println(
				"Date from ddMMyyyy String in Java : " + convertedDate);

		// String to Date conversion in Java with dd-MM-yyyy format e.g.
		// "14-09-2011"
		String dd_MM_YY = "14-09-2011";
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		convertedDate = (Date) formatter.parse(dd_MM_YY);
		System.out.println(
				"Date from dd-MM-yyyy String in Java : " + convertedDate);

		// dd/MM/yyyy date format for example "14/09/2011"
		String stringDateFormat = "14/09/2011";
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		convertedDate = (Date) formatter.parse(stringDateFormat);
		System.out.println(
				"Date from dd/MM/yyyy String in Java : " + convertedDate);

		// //parsing string into date with dd-MMM-yy format e.g. "14-Sep-11"
		// //MMMM denotes three letter month String e.g. Sep
		// String ddMMMyy = "14-Sep-11";
		// formatter =new SimpleDateFormat("dd-MMM-yy");
		// convertedDate =(Date) formatter.parse(ddMMMyy);
		// System.out.println("Date from dd-MMM-yy String in Java : " +
		// convertedDate);

		// //convert string to Date of dd-MMMM-yy format e.g. "14-September-11"
		// //MMMM denotes full month String e.g. September
		// String dMMMMyy = "14-September-11";
		// formatter =new SimpleDateFormat("dd-MMMM-yy");
		// convertedDate =(Date) formatter.parse(dMMMMyy);
		// System.out.println("Date from dd-MMMM-yy String in Java : " +
		// convertedDate);

		// SimpleDateFormat also allows to include time information e.g.
		// dd-MM-yyyy:HH:mm:SS
		String date = "15-09-2011:23:30:45";
		formatter = new SimpleDateFormat("dd-MM-yyyy:HH:mm:SS");
		convertedDate = (Date) formatter.parse(date);
		System.out.println("Date from dd-MM-yyyy:HH:mm:SS String in Java : "
				+ convertedDate);

	}

}
