package com.supera.scheduler.unit.service;

import com.supera.scheduler.model.Task;
import com.supera.scheduler.model.dto.TaskDTO;
import com.supera.scheduler.model.dto.TaskResponseDTO;
import com.supera.scheduler.repository.TaskRepository;
import com.supera.scheduler.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask_Success() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Task Title");
        taskDTO.setDescription("Task Description");
        taskDTO.setDueDate(LocalDate.now().plusDays(1));

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Task Title");
        task.setDescription("Task Description");
        task.setDueDate(LocalDate.now().plusDays(1));

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.createTask(taskDTO);

        assertNotNull(result);
        assertEquals("Task Title", result.getTitle());
        assertEquals("Task Description", result.getDescription());
        assertFalse(result.isCompleted());
    }

    @Test
    void testChangeTaskStatus() {
        Task task = new Task();
        task.setId(1L);
        task.setCompleted(false);

        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.changeTaskStatus(1L, true);

        assertTrue(result.isCompleted());
    }

    @Test
    void testFindAllOrderedByFavoriteAndCreationDate() {
        Task task1 = new Task();
        task1.setFavorite(true);
        task1.setCreatedAt(LocalDate.now().minusDays(2));

        Task task2 = new Task();
        task2.setFavorite(false);
        task2.setCreatedAt(LocalDate.now().minusDays(1));

        when(taskRepository.findAllOrderedByFavoriteAndCreationDate()).thenReturn(Arrays.asList(task1, task2));

        List<TaskResponseDTO> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        assertTrue(tasks.get(0).isFavorite());
        assertFalse(tasks.get(1).isFavorite());
    }
}

