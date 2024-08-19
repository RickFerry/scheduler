package com.supera.scheduler.repository;

import com.supera.scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
