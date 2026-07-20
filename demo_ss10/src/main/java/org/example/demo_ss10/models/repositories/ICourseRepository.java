package org.example.demo_ss10.models.repositories;

import org.example.demo_ss10.models.constants.CourseStatus;
import org.example.demo_ss10.models.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllByStatus(CourseStatus status, Pageable pageable);

}
