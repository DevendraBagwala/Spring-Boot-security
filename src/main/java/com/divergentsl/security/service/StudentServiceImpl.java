package com.divergentsl.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.security.dao.BaseDAO;
import com.divergentsl.security.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private BaseDAO studentDAO;
	
	@Override
	@Transactional
	public Student insertStudent(Student student) {
		return (Student)studentDAO.insert(student);
	}

	@Override
	@Transactional
	public Student findStudent(int id) {
		return (Student)studentDAO.find(id);
	}

	@Override
	@Transactional
	public List<Student> findAllStudent() {
		return studentDAO.findAll();

	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		studentDAO.remove(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		studentDAO.update(student);
		
	}

	

}
