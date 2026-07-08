package org.example.ss04.models.services;

import org.example.ss04.models.dto.req.StudentReq;
import org.example.ss04.models.dto.res.StudentRes;
import org.example.ss04.models.entities.Course;
import org.example.ss04.models.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(String search);

    Student addNewStudent(StudentReq req);

    List<StudentRes> search(String search);

    StudentRes findById(Long id);
}
