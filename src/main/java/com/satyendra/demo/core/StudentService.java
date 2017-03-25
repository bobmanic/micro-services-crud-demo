package com.satyendra.demo.core;

import java.util.List;

import com.satyendra.demo.api.Student;

public interface StudentService {

	public List<Student> getAll();

	public Student getOne(int rollno);

	public Boolean create(Student student);

	public Boolean update(Student student);

	public Boolean delete(int rollno);
}
