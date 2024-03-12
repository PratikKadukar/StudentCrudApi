package com.anytimedeveloper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anytimedeveloper.entity.Student;
import com.anytimedeveloper.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	
	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Long id, Student updatedStudent) {
		
		if (studentRepository.existsById(id)) {
			updatedStudent.setId(id);
			return studentRepository.save(updatedStudent);
		}
		else return null;
	}

}
