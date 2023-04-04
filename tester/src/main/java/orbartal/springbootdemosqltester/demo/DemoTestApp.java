package orbartal.springbootdemosqltester.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orbartal.springbootdemosqltester.demo.test.CrudMultiErrorTest;
import orbartal.springbootdemosqltester.demo.test.CrudMultiValidTest;
import orbartal.springbootdemosqltester.demo.test.CrudOneValidTest;
import orbartal.springbootdemosqltester.task.api.model.TaskCreateResponseDto;
import orbartal.springbootdemosqltester.task.app.TaskAppWriter;
import orbartal.springbootdemosqltester.task.model.RunnableTask;
import orbartal.springbootdemosqltester.testtask.runnable.TestRunnableTask;
import orbartal.springbootdemosqltester.testtask.worker.TestTaskWorker;
import orbartal.springbootdemosqltester.testtask.worker.TestTaskWorkerFactory;

@Component
public class DemoTestApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto testCrudOneValid() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(CrudOneValidTest.class);
		RunnableTask task = new TestRunnableTask("testCrudOneValid", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testCrudManyValid() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(CrudMultiValidTest.class);
		RunnableTask task = new TestRunnableTask("testCrudManyValid", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testCrudManyError() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(CrudMultiErrorTest.class);
		RunnableTask task = new TestRunnableTask("testCrudManyError", worker);
		return taskWriter.runTask(task);
	}

}
