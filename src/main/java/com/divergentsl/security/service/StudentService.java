package com.divergentsl.security.service;

import java.util.List;

import com.divergentsl.security.entity.Student;

public interface StudentService {
	
	public Student insertStudent(Student student);

	public Student findStudent(int id);

	public List<Student> findAllStudent();

	public void removeStudent(int id);
	
	public void updateStudent(Student student);
}
