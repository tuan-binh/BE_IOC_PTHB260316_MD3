package org.example.demo_ss10.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.demo_ss10.models.constants.CourseStatus;
import org.example.demo_ss10.models.dtos.req.CourseReq;
import org.example.demo_ss10.models.dtos.res.CourseRes;
import org.example.demo_ss10.models.entities.Course;
import org.example.demo_ss10.models.entities.Lesson;
import org.example.demo_ss10.models.repositories.ICourseRepository;
import org.example.demo_ss10.models.repositories.ILessonRepository;
import org.example.demo_ss10.models.services.ICourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    private final ILessonRepository lessonRepository;

    @Override
    public Page<Course> findAll(Pageable pageable, String status) {
        if(status.isEmpty()) {
            return courseRepository.findAll(pageable);
        }

        CourseStatus filterStatus = CourseStatus.valueOf(status);

        return courseRepository.findAllByStatus(filterStatus, pageable);
    }

    @Override
    public CourseRes findById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseRes.builder()
                .id(course.getId())
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .lessons(lessonRepository.findAllByCourseId(course.getId()))
                .build();
    }

    @Override
    public Course addNewCourse(CourseReq req) {
        return null;
    }

    @Override
    public Course updateCourse(CourseReq req, Long id) {
        return null;
    }

    @Override
    public void deleteCourse(Long id, CourseStatus status) {

    }

    @Override
    public List<Lesson> findAllLessonByCourseId(Long id) {
        return lessonRepository.findAllByCourseId(id);
    }
}
