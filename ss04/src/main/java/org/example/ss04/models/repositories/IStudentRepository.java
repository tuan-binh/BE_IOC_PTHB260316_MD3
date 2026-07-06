package org.example.ss04.models.repositories;

import org.example.ss04.models.entities.Classes;
import org.example.ss04.models.entities.Role;
import org.example.ss04.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFullNameContains(String fullName);

    @Query("SELECT s FROM Student s WHERE s.classes.name LIKE concat('%',:search,'%') ")
    List<Student> findAllByClassesName(@Param("search") String className);
}
