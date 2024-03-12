package com.anytimedeveloper.service;

import java.util.List;
import java.util.Optional;

import com.anytimedeveloper.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Optional<Student> getStudentById(Long id);
	
	public Student saveStudent(Student student);
	
	public void deleteStudent(Long id);
	
	public Student updateStudent(Long id, Student updatedStudent);

	
	
}
