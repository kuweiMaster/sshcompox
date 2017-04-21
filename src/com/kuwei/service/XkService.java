package com.kuwei.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuwei.dao.XkDao;
import com.kuwei.dto.Classes;
import com.kuwei.dto.Course;
import com.kuwei.dto.Student;
import com.kuwei.utils.Page;
@Transactional
@Service("xkService")
public class XkService {

	@Resource(name="xkDao")
	private XkDao dao;

	/**
	 * 功能:getter and setter
	 * @kuwei 2017年4月20日下午2:42:18
	 */
	public XkDao getDao() {
		return dao;
	}

	public void setDao(XkDao dao) {
		this.dao = dao;
	}

	public List<Student> getList(String mohu, Page page) {
		return dao.getList(mohu,page);
	}

	public List getCourseList() {
		return dao.getCourseList();
	}

	public List getClassList() {
		return dao.getClassList();
	}

	public Classes getClassById(Integer bid) {
		return dao.getClassById(bid);
	}

	public Set<Course> getCourseSet(String cids) {
		return dao.getCourseSet(cids);
	}

	public void save(Student stu) {
		dao.save(stu);
	}

	public void deleteStu(Student stu) {
		//删除中间表信息
		dao.deleteMid(stu);
		//删除学生表
		dao.deleteStu(stu);
	}

	public Student getStuById(Student stu) {
		return dao.getStuById(stu);
	}

	public void update(Student stu) {
		dao.update(stu);
	}

	public Integer count(String mohu) {
		return dao.count(mohu);
	}
}
