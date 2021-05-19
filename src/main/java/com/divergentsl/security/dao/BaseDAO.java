package com.divergentsl.security.dao;

import java.util.List;

import com.divergentsl.security.entity.Student;
public interface BaseDAO<T> {

	public T insert(T student);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);

	public void update(Student student);

}
