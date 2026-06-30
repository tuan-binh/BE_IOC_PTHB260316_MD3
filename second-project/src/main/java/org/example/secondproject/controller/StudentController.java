package org.example.secondproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.secondproject.model.entity.Student;
import org.example.secondproject.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // ResponseBody + Controller
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor // đây là tiêm thông qua constructor bằng annotation
public class StudentController {
    // để tiêm thông qua constructor phải có final (bắt buộc)
    private final IStudentService studentService;

//    @Autowired
//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }
// DI - Dependencies Injection
    // Constructor
    // Setter
    // Field

    @GetMapping // ghép giữa hiện tại với cái trên class api/v1/students
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    // giá trị trên đường dẫn và tham số trên đường dẫn
    // giới thiệu trước về giá trị trên đường dẫn
    // sử dụng pathvariable

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable(name = "id") Integer studentId) {
        Student student = studentService.findById(studentId);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // làm sao để gửi dữ liệu lên server (POST)
    @PostMapping // Method POST -> gửi ở body (JSON)
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED);


    }

    // sửa PUT - kèm theo id và body (nội dung mới)
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable(name = "id") Integer studentId,
            @RequestBody Student student
    ){
        Student updatedStudent = studentService.updateStudent(studentId, student);
        if(updatedStudent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }


    // Tạo dự án:
    // Xây dựng về quản lý nhà hàng:
    // nhà hàng có thông tin như sau:
    /*
        - id
        - name
        - address
        - contact
        - status : enum( 'OPEN', 'CLOSED' )
    */
    // Viết API: lấy về danh sách
    // tuân thủ kiến trúc MVC
    // viết thêm chức năng thêm mới nhà hàng



}
