package com.supera.scheduler.service;

import com.supera.scheduler.model.List;
import com.supera.scheduler.model.Task;
import com.supera.scheduler.model.dto.ListDTO;
import com.supera.scheduler.model.dto.TaskDTO;
import com.supera.scheduler.repository.ListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListService {
    private final ListRepository listRepository;

    public List createList(ListDTO listDTO) {
        List list = new List();
        list.setTitle(listDTO.getTitle());

        if (listDTO.getTasks() != null) {
            for (TaskDTO taskDTO : listDTO.getTasks()) {
                Task task = new Task();
                task.setTitle(taskDTO.getTitle());
                task.setDescription(taskDTO.getDescription());
                task.setDueDate(taskDTO.getDueDate());
                task.setList(list);
                list.getTasks().add(task);
            }
        }

        return listRepository.save(list);
    }

    public java.util.List<List> getAllLists() {
        return listRepository.findAll();
    }
}
