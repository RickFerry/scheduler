package com.supera.scheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed;

    private boolean favorite;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private com.supera.scheduler.model.List list;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subtasks;

    // Getters and Setters
}

