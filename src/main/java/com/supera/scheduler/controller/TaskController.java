package com.supera.scheduler.controller;

import com.supera.scheduler.model.Task;
import com.supera.scheduler.model.dto.TaskDTO;
import com.supera.scheduler.model.dto.TaskResponseDTO;
import com.supera.scheduler.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.createTask(taskDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable Long id, @RequestParam boolean completed) {
        return ResponseEntity.ok(taskService.changeTaskStatus(id, completed));
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<Task> toggleFavorite(@PathVariable Long id, @RequestParam boolean favorite) {
        return ResponseEntity.ok(taskService.toggleFavorite(id, favorite));
    }

    @DeleteMapping("/completed/{listId}")
    public ResponseEntity<Void> deleteCompletedTasks(@PathVariable Long listId) {
        taskService.deleteCompletedTasks(listId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Task>> filterTasks(@RequestParam(required = false) Boolean completed, @RequestParam(required = false) Boolean favorite) {
        return ResponseEntity.ok(taskService.filterTasks(completed, favorite));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}
