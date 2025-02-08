package com.studentMngmt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentMngmt.demo.entity.Student;
import com.studentMngmt.demo.repo.StudentRepository;


public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getAllStudent() {
		return repository.findAll();
	}
	
	public Student updateStudent(Long id, Student student) {
		student.setId(id);
		return repository.save(student);
	}
	
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
	
	public List<Student> searchByName(String name) {
		return repository.findByNameContaining(name);
	}

}

