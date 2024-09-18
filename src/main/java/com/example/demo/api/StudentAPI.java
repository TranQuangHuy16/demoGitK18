package com.example.demo.api;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// lớp chứa @RestController là đánh dấu class này là nơi chứa API
@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentAPI {

    //CORS


    // thêm 1 thằng sinh viên mới
    // api/student      => POST

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity createStudent(@Valid @RequestBody Student student){
        Student newStudent = studentService.createStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    //lấy danh sách hiện tại
    @GetMapping
    public ResponseEntity getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    //api/student/{id}
    @PutMapping("{studentId}")
    public ResponseEntity updateStudent(@PathVariable long studentId, @Valid @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity deleteStudent(@PathVariable long studentId) {
        Student updatedStudent = studentService.deleteStudent(studentId);
        return ResponseEntity.ok(updatedStudent);
    }
}
