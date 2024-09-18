package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // customize
    // đặt tên function theo định dạng DataJPA cung cấp
    // tên định dạng của jpa + tên table ( + By...)(kieudulieu tenthuoctinh)
    // findStudentById(long id)
    Student findStudentById(long id);

    // lấy ra danh sách sinh viên chưa bị deleted
    // findStudentsByIsDeletedFalse
    List<Student> findStudentsByIsDeletedFalse();
}
