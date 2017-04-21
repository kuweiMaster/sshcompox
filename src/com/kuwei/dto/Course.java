package com.kuwei.dto;

import java.util.HashSet;
import java.util.Set;

public class Course {
	
	 private Integer cid;
	 private String cname;
	 private Integer ptime;
	 
	 private Set<Student> students = new HashSet<Student>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPtime() {
		return ptime;
	}

	public void setPtime(Integer ptime) {
		this.ptime = ptime;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(Integer cid, String cname, Integer ptime,
			Set<Student> students) {
		this.cid = cid;
		this.cname = cname;
		this.ptime = ptime;
		this.students = students;
	}

	public Course() {
	}

}
