package com.studentMngmt.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentMngmt.demo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByNameContaining(String name);

}
