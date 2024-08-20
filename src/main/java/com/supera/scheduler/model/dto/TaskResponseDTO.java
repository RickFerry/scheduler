package com.supera.scheduler.model.dto;

import com.supera.scheduler.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private String title;
    private String description;
    private boolean favorite;
    private boolean completed;
    private LocalDate dueDate;
    private LocalDate createdAt;

    private boolean overdue;
    private long daysOverdue;

    public TaskResponseDTO(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.favorite = task.isFavorite();
        this.completed = task.isCompleted();
        this.dueDate = task.getDueDate();
        this.createdAt = task.getCreatedAt();

        // Verificar se está atrasada
        if (dueDate != null && LocalDate.now().isAfter(dueDate)) {
            this.overdue = true;
            this.daysOverdue = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        } else {
            this.overdue = false;
            this.daysOverdue = 0;
        }
    }
}

