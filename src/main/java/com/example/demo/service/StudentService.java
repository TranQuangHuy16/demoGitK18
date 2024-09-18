package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // Create
    public Student createStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    // Read
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findStudentsByIsDeletedFalse();
        return students;
    }

    // Update
    public Student updateStudent(long id,  Student student) {
        // bước 1: tìm ra thằng student cần được update thông qua id
        Student oldStudent = getStudentById(id);
        // => có tồn tại
        // bước 2: cập nhật thông tin của nó
        oldStudent.setStudentCode(student.getStudentCode());
        oldStudent.setName(student.getName());
        oldStudent.setScore(student.getScore());
        // bước 3: lưu xuống database
        return studentRepository.save(oldStudent);
    }

    // Delete
    public Student deleteStudent(long id) {
        Student oldStudent = getStudentById(id);

        oldStudent.setDeleted(true);
        return studentRepository.save(oldStudent);
    }

    public Student getStudentById(long id) {
        Student oldStudent = studentRepository.findStudentById(id);
        if (oldStudent == null) {
            throw new EntityNotFoundException("Student not found");
        }
        // if user.status == "BLOCK" throw new EntityNotFoundException("Student is blocked");
        return oldStudent;
    }
}
