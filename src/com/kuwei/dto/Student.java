package com.kuwei.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	 private Integer id;
	 private String name;
	 private String password;
	 private Date birthday;
	 private String hobbystr;
	 
	 private Classes classes = new Classes();
	 
	 private Set<Course> courses = new HashSet<Course>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobbystr() {
		return hobbystr;
	}

	public void setHobbystr(String hobbystr) {
		this.hobbystr = hobbystr;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student(Integer id, String name, String password, Date birthday,
			String hobbystr, Classes classes, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.hobbystr = hobbystr;
		this.classes = classes;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
