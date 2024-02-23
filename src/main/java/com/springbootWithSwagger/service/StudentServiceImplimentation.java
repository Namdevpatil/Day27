package com.springbootWithSwagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootWithSwagger.model.Student;
import com.springbootWithSwagger.repository.StudentRepository;



@Service
public class StudentServiceImplimentation implements StudentService
{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student updateStudent(Student student) 
	{
		Student getStudent = repository.findById(student.getId()).get();
		
		getStudent.setName(student.getName());
		getStudent.setStaudentClass(student.getStaudentClass());
		
		Student updateStudent = repository.save(getStudent);
		
		return updateStudent;
	}


}
