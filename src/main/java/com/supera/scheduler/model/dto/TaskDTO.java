package com.supera.scheduler.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    @NotBlank(message = "O título é obrigatório.")
    @Size(min = 5, message = "O título deve ter pelo menos 5 caracteres.")
    private String title;

    @NotBlank(message = "A descrição não pode estar vazia.")
    private String description;

    @NotNull(message = "A data prevista é obrigatória.")
    @Future(message = "A data prevista deve ser no futuro.")
    private LocalDate dueDate;
}

