package org.example.chua_bai_ss01.controllers;

import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss01.models.dto.req.AssignmentReq;
import org.example.chua_bai_ss01.models.entities.Task;
import org.example.chua_bai_ss01.models.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task){
        try {
            Task newTask = taskService.addTask(task);
            return ResponseEntity.ok(newTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/assign")
    public ResponseEntity<?> assignTask(@RequestBody AssignmentReq req){

        try {
            Task updatedTask = taskService.assignTask(req);
            return ResponseEntity.ok(updatedTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
