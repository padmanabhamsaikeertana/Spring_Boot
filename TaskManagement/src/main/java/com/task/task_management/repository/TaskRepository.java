package com.task.task_management.repository;

import com.task.task_management.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Page<TaskEntity> findAll(Pageable pageable);
}
