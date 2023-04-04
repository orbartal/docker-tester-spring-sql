package orbartal.springbootdemosqltester.testtask.worker;

import orbartal.springbootdemosqltester.test.runner.TestListener;
import orbartal.springbootdemosqltester.testtask.model.TestTaskReport;

public class TestTaskWorker implements TaskWorker<TestTaskReport> {

	private final JunitRunner runner;

	public TestTaskWorker(JunitRunner runner) {
		this.runner = runner;
	}

	@Override
	public TestTaskReport work() {
		TestListener listener = new TestListener();
		runner.run(listener);
		return new TestTaskReport(listener.getReport());
	}

}
