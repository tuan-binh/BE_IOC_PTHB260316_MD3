package org.example.ss08.models.services;

import org.example.ss08.models.dtos.req.StudentReq;
import org.example.ss08.models.entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(StudentReq req);

}
