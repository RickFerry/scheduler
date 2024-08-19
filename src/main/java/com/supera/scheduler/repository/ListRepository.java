package com.supera.scheduler.repository;

import com.supera.scheduler.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Long> {
}
