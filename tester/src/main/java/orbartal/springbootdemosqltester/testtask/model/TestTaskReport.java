package orbartal.springbootdemosqltester.testtask.model;

import orbartal.springbootdemosqltester.task.model.TaskReport;
import orbartal.springbootdemosqltester.test.report.MultiTestsReport;

public class TestTaskReport implements TaskReport {

	private final MultiTestsReport report;

	public TestTaskReport(MultiTestsReport report) {
		this.report = report;
	}

	public MultiTestsReport getReport() {
		return report;
	}

}
