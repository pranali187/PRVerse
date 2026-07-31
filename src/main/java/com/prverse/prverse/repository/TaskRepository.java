package com.prverse.prverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.Task;
import com.prverse.prverse.enums.TaskStatus;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long>{


	List<Task> findByPrPackagePackageId(Long packageId);

}
