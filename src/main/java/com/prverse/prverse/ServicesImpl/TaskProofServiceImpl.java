package com.prverse.prverse.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.TaskProofService;
import com.prverse.prverse.entity.TaskProof;
import com.prverse.prverse.repository.TaskProofRepository;

@Service
public class TaskProofServiceImpl implements TaskProofService {

    @Autowired
    private TaskProofRepository taskProofRepo;

    @Override
    public void createTaskProof(TaskProof taskProof) {
        taskProofRepo.save(taskProof);
    }

    @Override
    public List<TaskProof> getAllTaskProofs() {
        return taskProofRepo.findAll();
    }

    @Override
    public TaskProof getTaskProofById(Long id) {
        return taskProofRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task Proof not found"));
    }

    @Override
    public void updateTaskProof(Long id, TaskProof taskProof) {

        TaskProof existingProof = getTaskProofById(id);

        existingProof.setStatus(taskProof.getStatus());
        existingProof.setRemarks(taskProof.getRemarks());
        existingProof.setCompletedDate(taskProof.getCompletedDate());
        existingProof.setUpdatedBy(taskProof.getUpdatedBy());
        existingProof.setUpdatedAt(taskProof.getUpdatedAt());

        existingProof.setTask(taskProof.getTask());
        existingProof.setSubscription(taskProof.getSubscription());

        taskProofRepo.save(existingProof);
    }

    @Override
    public void deleteTaskProof(Long id) {

        TaskProof proof = getTaskProofById(id);

        taskProofRepo.delete(proof);
    }

    @Override
    public List<TaskProof> getProofsByTask(Long taskId) {
        return taskProofRepo.findByTaskTaskId(taskId);
    }

    @Override
    public List<TaskProof> getProofsBySubscription(Long subscriptionId) {
        return taskProofRepo.findBySubscriptionSubscriptionId(subscriptionId);
    }
}