package com.divergentsl.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.security.entity.Student;

@Repository
public class StudentDAOImpl implements BaseDAO<Student> {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Student insert(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Override
	public Student find(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("Select e from Student e", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public void remove(int id) {
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityManager.remove(student);
		}
	}

	@Override
	public void update(Student student) {
		entityManager.merge(student);
		
	}	

}
