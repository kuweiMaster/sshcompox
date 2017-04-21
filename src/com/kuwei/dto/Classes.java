package com.kuwei.dto;

import java.util.HashSet;
import java.util.Set;

public class Classes {
	 private Integer bid;
	 private String bname;
	 
	 private Set<Student> students = new HashSet<Student>();

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Classes(Integer bid, String bname, Set<Student> students) {
		this.bid = bid;
		this.bname = bname;
		this.students = students;
	}

	public Classes() {
	}

}
