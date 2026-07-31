package com.prverse.prverse.Service;

import java.util.List;

import com.prverse.prverse.entity.Task;

public interface TaskService {

    void createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> getTasksByPackage(Long packageId);

}