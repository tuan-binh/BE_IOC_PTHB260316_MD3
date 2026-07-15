package org.example.ss08.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ss08.models.dtos.req.StudentReq;
import org.example.ss08.models.dtos.wrapper.ApiResponse;
import org.example.ss08.models.services.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    /**
     * @apiNote handle get all students
     *
     */
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Get Students Successfully")
                        .data(studentService.findAll())
                        .build()
        );
    }

    @PostMapping
//    public ResponseEntity<?> addNewStudent(@Valid @RequestBody StudentReq req) {
    public ResponseEntity<?> addNewStudent(@Valid @ModelAttribute StudentReq req) {
        return ResponseEntity.status(201).body(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Add New Student Successfully")
                        .data(studentService.save(req))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Get Student Successfully")
                        .data(studentService.findById(id))
                        .build()
        );
    }

}
