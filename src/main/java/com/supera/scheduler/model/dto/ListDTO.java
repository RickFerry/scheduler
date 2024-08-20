package com.supera.scheduler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO {
    private Long id;

    private String title;

    private java.util.List<TaskDTO> tasks;
}
