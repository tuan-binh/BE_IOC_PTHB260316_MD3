package org.example.ss08.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.ss08.exceptions.NotFoundException;
import org.example.ss08.models.dtos.req.StudentReq;
import org.example.ss08.models.entities.Student;
import org.example.ss08.models.repositories.IStudentRepository;
import org.example.ss08.models.services.IStudentService;
import org.example.ss08.models.services.uploads.UploadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;
    private final UploadService uploadService;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }

    @Override
    public Student save(StudentReq req) {
        Student student = Student.builder()
                .fullName(req.getFullName())
                .email(req.getEmail())
                .address(req.getAddress())
                .phone(req.getPhone())
                .avatarUrl(uploadService.upload(req.getAvatarFile()))
                .build();

        return studentRepository.save(student);
    }
}
