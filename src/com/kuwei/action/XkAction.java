package com.kuwei.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.kuwei.dto.Classes;
import com.kuwei.dto.Course;
import com.kuwei.dto.Student;
import com.kuwei.service.XkService;
import com.kuwei.utils.Page;

public class XkAction {

	@Resource(name="xkService")
	private XkService service;

	private List list;
	
	private List classList;
	
	private List courseList = new ArrayList();
	
	private String cids;
	
	private Integer bid;
	
	private Student stu;
	
	private Page page;
	private String currentPage;
	private String mohu;
	
	/**
	 * 功能:列表
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String list(){
		
		Integer count = service.count(mohu);
		page = new Page(currentPage,count,"3");
		list = service.getList(mohu,page);
		return "list";
	}
	/**
	 * 功能:跳转添加页面
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String toAdd(){
		list = service.getCourseList();
		classList = service.getClassList();
		return "add";
	}
	/**
	 * 功能:添加
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String add(){
		Classes clazz = service.getClassById(bid);
		Set<Course> courses = service.getCourseSet(cids);
		stu.setClasses(clazz);
		stu.setCourses(courses);
		service.save(stu);
		return "refresh";
	}
	/**
	 * 功能:删除学生
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String deleteStu(){
		service.deleteStu(stu);
		return "refresh";
	}
	/**
	 * 功能:跳转到修改页面
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String toUpdate(){
		classList = service.getClassList();
		list = service.getCourseList();
		stu = service.getStuById(stu);
		for ( Course s: stu.getCourses()) {
			courseList.add(s.getCid());
		}
		return "update";
	}
	/**
	 * 功能:修改
	 * @kuwei 2017年4月20日下午4:48:10
	 */
	public String update(){
		Classes clazz = service.getClassById(bid);
		Set<Course> courses = service.getCourseSet(cids);
		stu.setClasses(clazz);
		stu.setCourses(courses);;
		service.update(stu);
		return "refresh";
	}
	
	
	
	/**
	 * 功能:getter  and setter
	 * @kuwei 2017年4月20日下午2:42:30
	 */
	public XkService getService() {
		return service;
	}

	public void setService(XkService service) {
		this.service = service;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	public List getClassList() {
		return classList;
	}
	public void setClassList(List classList) {
		this.classList = classList;
	}
	public String getCids() {
		return cids;
	}
	public void setCids(String cids) {
		this.cids = cids;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public List getCourseList() {
		return courseList;
	}
	public void setCourseList(List courseList) {
		this.courseList = courseList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getMohu() {
		return mohu;
	}
	public void setMohu(String mohu) {
		this.mohu = mohu;
	}
}
