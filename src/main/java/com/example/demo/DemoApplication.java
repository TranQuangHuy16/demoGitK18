package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	//quanr lý sinh viên
	// sinh viên (name, studentCode, score)
	// lấy ra danh sách tất cả sinh viên
	// thêm một sinh viên mới vào danh sách
	// update điểm của sinh viên
	// delete 1 sinh viên nào đó

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	// Restfull API
	// cách đặt tên API

	// thêm 1 sv mới
	// /api/student     => POST: tạo 1 student mới
	// /api/student/studentId 		=> PUT: update thông tin student có studentId
	// vd: /api/student/1
	// /api/student/studentId		=> DELETE: delete student có studentId
	// /api/student 		=> GET: lấy tất cả các student
	// /api/student/studentId		=> GET: lấy tất cả các student có studentId



	// METHOD:
	/*
	* 	POST => create
	* 	PUT => update
	* 	DELETE => delete
	* 	GET => get
	* */
}
