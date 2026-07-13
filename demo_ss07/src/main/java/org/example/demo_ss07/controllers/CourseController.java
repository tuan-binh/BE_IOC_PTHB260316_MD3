package org.example.demo_ss07.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo_ss07.models.dtos.req.CourseRequestDTO;
import org.example.demo_ss07.models.dtos.req.SearchCourseDTO;
import org.example.demo_ss07.models.dtos.wrapper.ApiResponse;
import org.example.demo_ss07.models.entities.Course;
import org.example.demo_ss07.models.services.ICourseService;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Retrieved Course Successfully")
                        .data(courseService.findAll(pageable))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@Valid @RequestBody CourseRequestDTO req, BindingResult result) {
        ResponseEntity<?> errors = handleValidation(result);
        if (errors != null) return errors;
        return ResponseEntity.status(201).body(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Added Course Successfully")
                        .data(courseService.addNewCourse(req))
                        .build()
        );
    }

    @Nullable
    private ResponseEntity<?> handleValidation(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status("ERROR")
                            .message("FAILED")
                            .data(errors)
                            .build()
            );
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO req,
            BindingResult result) {
        ResponseEntity<?> errors = handleValidation(result);
        if (errors != null) return errors;

        return ResponseEntity.status(200).body(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Updated Course Successfully")
                        .data(courseService.updateCourse(req, id))
                        .build()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCourse(@RequestBody SearchCourseDTO req) {
        return ResponseEntity.status(200).body(
                ApiResponse.builder()
                        .status("SUCCESS")
                        .message("Retrieved Course Successfully")
                        .data(courseService.searchAdvanced(req))
                        .build()
        );
    }

}
