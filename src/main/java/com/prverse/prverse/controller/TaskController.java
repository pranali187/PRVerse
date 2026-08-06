package com.prverse.prverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prverse.prverse.Service.TaskService;
import com.prverse.prverse.entity.Task;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully";
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id,
                             @RequestBody Task task) {
        taskService.updateTask(id, task);
        return "Task updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    @GetMapping("/Package/{PackageID}")
    public List<Task> getTasksByPackage(@PathVariable Long PackageID) {
        return taskService.getTasksByPackage(PackageID);
    }
}