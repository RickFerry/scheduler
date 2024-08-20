package com.supera.scheduler.repository;

import com.supera.scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t ORDER BY t.favorite DESC, t.createdAt ASC")
    List<Task> findAllOrderedByFavoriteAndCreationDate();

    List<Task> findByCompleted(boolean b);

    List<Task> findByFavorite(Boolean favorite);
}

