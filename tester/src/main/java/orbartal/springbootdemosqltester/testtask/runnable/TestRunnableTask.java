package orbartal.springbootdemosqltester.testtask.runnable;

import java.util.Optional;

import orbartal.springbootdemosqltester.task.model.RunnableTask;
import orbartal.springbootdemosqltester.task.model.TaskReport;
import orbartal.springbootdemosqltester.task.model.TaskStatusEnum;
import orbartal.springbootdemosqltester.testtask.model.TestTaskReport;
import orbartal.springbootdemosqltester.testtask.worker.TaskWorker;

public class TestRunnableTask implements RunnableTask {

	private final String name;
	private final TaskWorker<TestTaskReport> worker;

	private TaskStatusEnum status;
	private Optional<TaskReport> report; //TODO: the optional should be in the worker

	public TestRunnableTask(String name, TaskWorker<TestTaskReport> worker) {
		this.report = Optional.empty();
		this.status = TaskStatusEnum.BEFORE;
		this.name = name;
		this.worker = worker;
	}

	@Override
	public void run() {
		status = TaskStatusEnum.START;
		report = Optional.ofNullable(worker.work());
		status = TaskStatusEnum.END;
	}

	@Override
	public TaskStatusEnum getStatus() {
		return status;
	}

	@Override
	public Optional<TaskReport> getReport() {
		return report;
	}

	@Override
	public String getName() {
		return name;
	}

}
