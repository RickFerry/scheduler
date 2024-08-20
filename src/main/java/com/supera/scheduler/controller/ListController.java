package com.supera.scheduler.controller;

import com.supera.scheduler.model.dto.ListDTO;
import com.supera.scheduler.service.ListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/lists")
public class ListController {

    private final ListService listService;

    @PostMapping
    public ResponseEntity<com.supera.scheduler.model.List> createList(@RequestBody ListDTO listDTO) {
        return ResponseEntity.ok(listService.createList(listDTO));
    }

    @GetMapping
    public ResponseEntity<List<com.supera.scheduler.model.List>> getAllLists() {
        return ResponseEntity.ok(listService.getAllLists());
    }
}
