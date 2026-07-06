package org.example.ss04.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.ss04.models.dto.req.StudentReq;
import org.example.ss04.models.entities.Student;
import org.example.ss04.models.repositories.IClassesRepository;
import org.example.ss04.models.repositories.IStudentRepository;
import org.example.ss04.models.services.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;
    private final IClassesRepository classesRepository;

    @Override
    public List<Student> findAll(String search) {
        if (search == null || search.isEmpty()) {
            return studentRepository.findAll();
        }
        return studentRepository.findAllByFullNameContains(search);
    }

    @Override
    public Student addNewStudent(StudentReq req) {

        Student student = new Student();
        student.setFullName(req.getFullName());
        student.setAge(req.getAge());
        student.setClasses(
                classesRepository.findById(req.getClassId()).orElseThrow(() -> new IllegalArgumentException("Class not found"))
        );
        return studentRepository.save(student);

    }
}
