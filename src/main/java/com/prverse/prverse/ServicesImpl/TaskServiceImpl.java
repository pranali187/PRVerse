package com.prverse.prverse.ServicesImpl;

import java.util.List;

import com.prverse.prverse.Service.TaskService;
import com.prverse.prverse.entity.Task;
import com.prverse.prverse.enums.TaskStatus;

public class TaskServiceImpl implements TaskService{

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksByPackageId(Long packageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTask(Long id, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTaskStatus(Long id, TaskStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task assignTask(Long taskId, Long prTeamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	public List<Task> getTasksByStatus(TaskStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPackageProgress(Long packageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
