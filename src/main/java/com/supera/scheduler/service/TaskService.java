package com.supera.scheduler.service;

import com.supera.scheduler.model.Task;
import com.supera.scheduler.model.dto.TaskDTO;
import com.supera.scheduler.model.dto.TaskResponseDTO;
import com.supera.scheduler.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task changeTaskStatus(Long id, boolean completed) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(completed);
        return taskRepository.save(task);
    }

    public Task toggleFavorite(Long id, boolean favorite) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setFavorite(favorite);
        return taskRepository.save(task);
    }

    public void deleteCompletedTasks(Long listId) {
        List<Task> tasks = taskRepository.findByCompleted(true);
        taskRepository.deleteAll(tasks);
    }

    public List<Task> filterTasks(Boolean completed, Boolean favorite) {
        if (completed != null) {
            return taskRepository.findByCompleted(completed);
        } else if (favorite != null) {
            return taskRepository.findByFavorite(favorite);
        } else {
            return taskRepository.findAll();
        }
    }

    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAllOrderedByFavoriteAndCreationDate();
        return tasks.stream()
                .map(TaskResponseDTO::new)
                .collect(Collectors.toList());
    }
}
