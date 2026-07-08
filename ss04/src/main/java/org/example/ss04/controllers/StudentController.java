package org.example.ss04.controllers;

import lombok.RequiredArgsConstructor;
import org.example.ss04.models.dto.req.StudentReq;
import org.example.ss04.models.entities.Student;
import org.example.ss04.models.services.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        return ResponseEntity.ok(studentService.search(search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentReq req) {
        try {
            return ResponseEntity.ok(studentService.addNewStudent(req));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
