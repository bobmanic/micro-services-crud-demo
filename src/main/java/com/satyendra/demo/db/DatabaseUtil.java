package com.satyendra.demo.db;

import java.util.List;

import com.satyendra.demo.api.Student;

public interface DatabaseUtil {

	public List<Student> getAll();

	public Student getOne(int rollno);

	public Boolean create(Student student);

	public Boolean update(Student student);

	public Boolean delete(int rollno);

}
