package org.example.demo_ss07.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.demo_ss07.models.dtos.req.CourseRequestDTO;
import org.example.demo_ss07.models.dtos.req.SearchCourseDTO;
import org.example.demo_ss07.models.entities.Course;
import org.example.demo_ss07.models.repositories.ICourseRepository;
import org.example.demo_ss07.models.services.ICourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course addNewCourse(CourseRequestDTO req) {
        Course course = Course.builder()

                .courseCode(req.getCourseCode())
                .title(req.getTitle())
                .description(req.getDescription())
                .price(req.getPrice())
                .durationHours(req.getDurationHours())
                .instructorEmail(req.getInstructorEmail())

                .build();
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(CourseRequestDTO req, Long id) {
        Course updateCourse = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("course not found"));
        updateCourse.setCourseCode(req.getCourseCode());
        updateCourse.setTitle(req.getTitle());
        updateCourse.setDescription(req.getDescription());
        updateCourse.setPrice(req.getPrice());
        updateCourse.setDurationHours(req.getDurationHours());
        updateCourse.setInstructorEmail(req.getInstructorEmail());

        return courseRepository.save(updateCourse);
    }

    @Override
    public List<Course> searchAdvanced(SearchCourseDTO req) {
        return courseRepository.searchAdvanced(
                req.getTitle(),
                req.getMinPrice(),
                req.getMaxPrice()
        );
    }
}
