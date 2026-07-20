package org.example.demo_ss10.controllers;

import lombok.RequiredArgsConstructor;
import org.example.demo_ss10.models.constants.CourseStatus;
import org.example.demo_ss10.models.dtos.wrapper.ApiResponse;
import org.example.demo_ss10.models.entities.Lesson;
import org.example.demo_ss10.models.services.ICourseService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<?> findAll(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable,
            @RequestParam(name = "status", defaultValue = "") String status
    ) {


        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("get all courses successfully")
                        .code(200)
                        .data(courseService.findAll(pageable, status))
                        .build()
        );
    }
}
