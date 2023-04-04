package orbartal.springbootdemosqltester.testtask.worker;

import orbartal.springbootdemosqltester.task.model.TaskReport;

public interface TaskWorker <R extends TaskReport> {

	public R work();

}
