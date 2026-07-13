package org.example.demo_ss07.models.services;

import org.example.demo_ss07.models.dtos.req.CourseRequestDTO;
import org.example.demo_ss07.models.dtos.req.SearchCourseDTO;
import org.example.demo_ss07.models.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICourseService {

    Page<Course> findAll(Pageable pageable);

    Course addNewCourse(CourseRequestDTO req);

    Course updateCourse(CourseRequestDTO req, Long id);

    List<Course> searchAdvanced(SearchCourseDTO req);

}
