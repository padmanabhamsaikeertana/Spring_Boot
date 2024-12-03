package com.task.task_management.controller;

import com.task.task_management.entity.TaskStatus;
import com.task.task_management.repository.TaskRepository;
import com.task.task_management.entity.TaskEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskEntity> createTask(@Valid @RequestBody TaskEntity taskEntity) {
        if (taskEntity.getStatus() == null) {
            taskEntity.setStatus(TaskStatus.PENDING); // Default to PENDING
        }
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/tasks/search")
    public ResponseEntity<Page<TaskEntity>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size); // Page = 0, Size = 10
        Page<TaskEntity> tasks = taskRepository.findAll(pageable);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).
                map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build()
        );
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @Valid @RequestBody TaskEntity taskEntity) {
        boolean isExists = taskRepository.existsById(id);
        if (!isExists) {
            return ResponseEntity.notFound().build();
        }
        TaskEntity existingTask = taskRepository.findById(id).get();
        if(taskEntity.getTitle()!= null) existingTask.setTitle(taskEntity.getTitle());
        if(taskEntity.getDescription()!= null) existingTask.setDescription(taskEntity.getDescription());
        if (taskEntity.getStatus() != null) existingTask.setStatus(taskEntity.getStatus());
        TaskEntity updatedTask = taskRepository.save(existingTask);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        boolean isExists = taskRepository.existsById(id);
        if (!isExists) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
