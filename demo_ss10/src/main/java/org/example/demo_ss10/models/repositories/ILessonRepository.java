package org.example.demo_ss10.models.repositories;

import org.example.demo_ss10.models.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson,Long> {

    List<Lesson> findAllByCourseId(Long courseId);

}
