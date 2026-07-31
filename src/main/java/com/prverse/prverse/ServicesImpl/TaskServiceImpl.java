package com.prverse.prverse.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.TaskService;
import com.prverse.prverse.entity.Task;
import com.prverse.prverse.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Override
    public void createTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public void updateTask(Long id, Task task) {

        Task existingTask = getTaskById(id);

        existingTask.setTaskName(task.getTaskName());
        existingTask.setDescription(task.getDescription());
        existingTask.setOrderNo(task.getOrderNo());
        existingTask.setTaskStatus(task.getTaskStatus());
        existingTask.setPrPackage(task.getPrPackage());

        taskRepo.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepo.delete(task);
    }

    @Override
    public List<Task> getTasksByPackage(Long packageId) {
        return taskRepo.findByPrPackagePackageId(packageId);
    }


}
