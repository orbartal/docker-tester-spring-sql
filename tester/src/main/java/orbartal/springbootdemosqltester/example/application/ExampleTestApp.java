package orbartal.springbootdemosqltester.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orbartal.springbootdemosqltester.example.test.CallOrderTest;
import orbartal.springbootdemosqltester.example.test.Test4Results;
import orbartal.springbootdemosqltester.task.api.model.TaskCreateResponseDto;
import orbartal.springbootdemosqltester.task.app.TaskAppWriter;
import orbartal.springbootdemosqltester.task.model.RunnableTask;
import orbartal.springbootdemosqltester.testtask.runnable.TestRunnableTask;
import orbartal.springbootdemosqltester.testtask.worker.TestTaskWorker;
import orbartal.springbootdemosqltester.testtask.worker.TestTaskWorkerFactory;

@Component
public class ExampleTestApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto test4Results() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClass(Test4Results.class);
		RunnableTask task = new TestRunnableTask("test4Results", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testCallOrder() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClass(CallOrderTest.class);
		RunnableTask task = new TestRunnableTask("testCallOrder", worker);
		return taskWriter.runTask(task);
	}

}
