package com.prverse.prverse.Service;

import java.util.List;

import com.prverse.prverse.entity.Task;
import com.prverse.prverse.enums.TaskStatus;

public interface TaskService {
	Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    List<Task> getTasksByPackageId(Long packageId);

    Task updateTask(Long id, Task task);

    Task updateTaskStatus(
        Long id,
        TaskStatus status
    );

    Task assignTask(
        Long taskId,
        Long prTeamId
    );

    void deleteTask(Long id);

    List<Task> getTasksByStatus(
        TaskStatus status
    );

    Double getPackageProgress(
        Long packageId
    );
}
