package com.studentMngmt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentMngmt.demo.entity.Student;
import com.studentMngmt.demo.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add-student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(service.saveStudent(student));
	}
	
	@GetMapping("/get-students")
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(service.getAllStudent());
	}
	
	@PutMapping("/update-student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(service.updateStudent(id, student));
	}
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return ResponseEntity.ok("DELETED SUCCESSFULLY");
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudent(@RequestParam String name) {
		return ResponseEntity.ok(service.searchByName(name));
	}

}

