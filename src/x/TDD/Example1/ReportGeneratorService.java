package x.TDD.Example1;

import java.time.LocalDate;

public class ReportGeneratorService {

	private ReportGenerator reportGenerator;

	public void generateReport(LocalDate startDate, LocalDate endDate, byte[] content) {

		ReportEntity report = new ReportEntity();
		report.setContent(content);
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		reportGenerator.generateReport(report);
	}

}
