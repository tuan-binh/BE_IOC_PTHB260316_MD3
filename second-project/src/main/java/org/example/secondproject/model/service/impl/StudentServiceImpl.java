package org.example.secondproject.model.service.impl;

import org.example.secondproject.model.entity.Student;
import org.example.secondproject.model.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1,"Vũ",18),
                    new Student(2,"Chương",19),
                    new Student(3,"Đại",20),
                    new Student(4,"Phong",21)
            )
    );

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(Integer id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Student> max = students.stream().max(Comparator.comparingInt(Student::getId));
        int newId = max.isPresent() ? max.get().getId() + 1 : 1;
        Student temp = new Student(newId,student.getName(),student.getAge());
        students.add(temp);
        return temp;
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student update = findById(id);
        if(update!=null){
            update.setName(student.getName());
            update.setAge(student.getAge());
        }

        return update;
    }
}
