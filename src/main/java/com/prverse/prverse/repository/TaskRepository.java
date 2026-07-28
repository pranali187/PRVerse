package com.prverse.prverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prverse.prverse.entity.Task;
import com.prverse.prverse.enums.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long>{
	

}
