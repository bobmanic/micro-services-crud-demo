package com.satyendra.demo.core;

import java.util.List;

import com.satyendra.demo.api.Student;
import com.satyendra.demo.config.StudentManagementConfiguration;
import com.satyendra.demo.db.DatabaseUtil;
import com.satyendra.demo.db.DatabaseUtilImpl;

public class StudentServiceImpl implements StudentService {

	private DatabaseUtil db;

	public StudentServiceImpl(StudentManagementConfiguration configuration) {
		this.db = new DatabaseUtilImpl(configuration.getMySQLConfiguration());
	}
	
	public void setDb(DatabaseUtil db) {
		this.db = db;
	}

	@Override
	public List<Student> getAll() {
		return db.getAll();
	}

	@Override
	public Student getOne(int rollno) {
		return db.getOne(rollno);
	}

	@Override
	public Boolean create(Student student) {
		return db.create(student);
	}

	@Override
	public Boolean update(Student student) {
		return db.update(student);
	}

	@Override
	public Boolean delete(int rollno) {
		return db.delete(rollno);
	}

}
