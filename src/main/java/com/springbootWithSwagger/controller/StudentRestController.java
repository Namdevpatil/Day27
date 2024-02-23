package com.springbootWithSwagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootWithSwagger.model.Student;
import com.springbootWithSwagger.repository.StudentRepository;
import com.springbootWithSwagger.service.StudentService;


@RestController
@RequestMapping("/sms")
public class StudentRestController
{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void removeStudent(@PathVariable("id") int id)
	{
		studentRepository.deleteById(id);
	}
	
	@PutMapping("students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student)
	{
		student.setId(id);
		
		Student student2 = studentService.updateStudent(student);
		
		return new ResponseEntity<>(student2, HttpStatus.OK);
	}
	
}
