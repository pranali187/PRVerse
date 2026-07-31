package com.prverse.prverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prverse.prverse.Service.TaskProofService;
import com.prverse.prverse.entity.TaskProof;

@RestController
@RequestMapping("/taskproofs")
public class TaskProofController {

    @Autowired
    private TaskProofService taskProofService;

    @PostMapping
    public String createTaskProof(@RequestBody TaskProof taskProof) {
        taskProofService.createTaskProof(taskProof);
        return "Task proof created successfully";
    }

    @GetMapping
    public List<TaskProof> getAllTaskProofs() {
        return taskProofService.getAllTaskProofs();
    }

    @GetMapping("/{id}")
    public TaskProof getTaskProofById(@PathVariable Long id) {
        return taskProofService.getTaskProofById(id);
    }

    @PutMapping("/{id}")
    public String updateTaskProof(@PathVariable Long id,
                                  @RequestBody TaskProof taskProof) {
        taskProofService.updateTaskProof(id, taskProof);
        return "Task proof updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteTaskProof(@PathVariable Long id) {
        taskProofService.deleteTaskProof(id);
        return "Task proof deleted successfully";
    }

    @GetMapping("/task/{taskId}")
    public List<TaskProof> getProofsByTask(@PathVariable Long taskId) {
        return taskProofService.getProofsByTask(taskId);
    }

    @GetMapping("/subscription/{subscriptionId}")
    public List<TaskProof> getProofsBySubscription(@PathVariable Long subscriptionId) {
        return taskProofService.getProofsBySubscription(subscriptionId);
    }
}