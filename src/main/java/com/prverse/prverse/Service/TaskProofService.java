package com.prverse.prverse.Service;

import java.util.List;

import com.prverse.prverse.entity.TaskProof;

public interface TaskProofService {

    void createTaskProof(TaskProof taskProof);

    List<TaskProof> getAllTaskProofs();

    TaskProof getTaskProofById(Long id);

    void updateTaskProof(Long id, TaskProof taskProof);

    void deleteTaskProof(Long id);

    List<TaskProof> getProofsByTask(Long taskId);

    List<TaskProof> getProofsBySubscription(Long subscriptionId);

}