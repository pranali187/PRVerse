package com.prverse.prverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.Task;
import com.prverse.prverse.entity.TaskProof;
import com.prverse.prverse.enums.TaskStatus;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface TaskProofRepository extends JpaRepository<TaskProof, Long>{

	List<TaskProof> findByTaskTaskId(Long taskId);

	List<TaskProof> findBySubscriptionSubscriptionId(Long subscriptionId);
	
}
