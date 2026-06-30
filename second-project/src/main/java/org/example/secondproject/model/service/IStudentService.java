package org.example.secondproject.model.service;

import org.example.secondproject.model.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Integer id);

    // cần trả về đối tượng vừa được thêm
    Student addStudent(Student student);

    Student updateStudent(Integer id, Student student);

}
