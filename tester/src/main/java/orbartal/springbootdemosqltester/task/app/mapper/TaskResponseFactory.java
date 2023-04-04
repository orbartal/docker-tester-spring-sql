package orbartal.springbootdemosqltester.task.app.mapper;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import orbartal.springbootdemosqltester.task.api.model.TaskCreateResponseDto;
import orbartal.springbootdemosqltester.task.api.model.TaskStatusResponseDto;
import orbartal.springbootdemosqltester.task.model.RunnableTask;
import orbartal.springbootdemosqltester.task.model.TaskStatusEnum;

@Component
public class TaskResponseFactory {

	public TaskCreateResponseDto create(UUID uuid, RunnableTask task) {
		TaskCreateResponseDto dto = new TaskCreateResponseDto();
		dto.setName(task.getName());
		dto.setUid(uuid.toString());
		return dto;
	}

	public TaskStatusResponseDto status(String id, Optional<TaskStatusEnum> status) {
		TaskStatusResponseDto dto = new TaskStatusResponseDto();
		dto.setUid(id);
		dto.setStatus(status.get().name());
		return dto;
	}

}
