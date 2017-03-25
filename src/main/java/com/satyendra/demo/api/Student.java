package com.satyendra.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	private int rollno;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollno,String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@JsonProperty
	public int getRollno() {
		return rollno;
	}

	@JsonProperty
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	
}
