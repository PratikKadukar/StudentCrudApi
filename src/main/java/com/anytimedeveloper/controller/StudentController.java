package com.anytimedeveloper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anytimedeveloper.entity.Student;
import com.anytimedeveloper.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/all")
	public List<Student> getAllStudents() {

		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

		Optional<Student> studentById = studentService.getStudentById(id);

		return studentById.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
	 Student createdStudent = studentService.saveStudent(student);
	 return new ResponseEntity<> (createdStudent, HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent (@PathVariable Long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent (@PathVariable Long id,@RequestBody Student student){
		Student result = studentService.updateStudent(id, student);
		
		 return result != null ?
		            new ResponseEntity<>(result, HttpStatus.OK) :
		            new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
