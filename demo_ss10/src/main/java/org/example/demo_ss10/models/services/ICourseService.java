package org.example.demo_ss10.models.services;

import org.example.demo_ss10.models.constants.CourseStatus;
import org.example.demo_ss10.models.dtos.req.CourseReq;
import org.example.demo_ss10.models.dtos.res.CourseRes;
import org.example.demo_ss10.models.entities.Course;
import org.example.demo_ss10.models.entities.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICourseService {

    Page<Course> findAll(Pageable pageable, String status);

    CourseRes findById(Long id);

    Course addNewCourse(CourseReq req);

    Course updateCourse(CourseReq req, Long id);

    void deleteCourse(Long id, CourseStatus status);

    List<Lesson> findAllLessonByCourseId(Long id);


}
