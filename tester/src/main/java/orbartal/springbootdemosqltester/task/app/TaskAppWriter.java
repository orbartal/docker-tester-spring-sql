package orbartal.springbootdemosqltester.task.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orbartal.springbootdemosqltester.task.api.model.TaskCreateResponseDto;
import orbartal.springbootdemosqltester.task.app.mapper.TaskResponseFactory;
import orbartal.springbootdemosqltester.task.data.TaskDataWriter;
import orbartal.springbootdemosqltester.task.model.RunnableTask;


@Component
public class TaskAppWriter {

	@Autowired
	private TaskResponseFactory responseFactory;

	@Autowired
	private TaskDataWriter taskExecuter;

	public TaskCreateResponseDto runTask(RunnableTask task) {
		UUID uuid = taskExecuter.addNewTask(task);
		return responseFactory.create(uuid, task);
	}

}
