package com.kuwei.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kuwei.dto.Classes;
import com.kuwei.dto.Course;
import com.kuwei.dto.Student;
import com.kuwei.utils.Page;

@Repository("xkDao")
public class XkDao {

	@Autowired
	private SessionFactory factory;
	
	public Session getCurrentSession(){
		return factory.getCurrentSession();
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<Student> getList(String mohu, Page page) {
		if(mohu==null){
			mohu="";
		}
		Criteria criteria = getCurrentSession().createCriteria(Student.class);
		criteria.add(Restrictions.like("name", "%"+mohu+"%"));
		criteria.setFirstResult(page.getStartRecord());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
	}

	public List<Course> getCourseList() {
		return getCurrentSession().createCriteria(Course.class).list();
	}

	public List<Classes> getClassList() {
		return getCurrentSession().createCriteria(Classes.class).list();
	}

	public Classes getClassById(Integer bid) {
		return (Classes) getCurrentSession().get(Classes.class, bid);
		
	}

	public Set<Course> getCourseSet(String cids) {
		List<Course> list = getCurrentSession().createSQLQuery("select * from course where cid in("+cids+")").addEntity(Course.class).list();
		Set<Course> courses = new HashSet<Course>();
		courses.addAll(list);
		return courses;
	}

	public void save(Student stu) {
		getCurrentSession().save(stu);
	}

	public void deleteMid(Student stu) {
		getCurrentSession().createSQLQuery("delete from stu_course where sid="+stu.getId()).executeUpdate();
	}

	public void deleteStu(Student stu) {
		getCurrentSession().createSQLQuery("delete from student where id="+stu.getId()).executeUpdate();
	}

	public Student getStuById(Student stu) {
		return (Student) getCurrentSession().get(Student.class, stu.getId());
	}

	public void update(Student stu) {
		getCurrentSession().merge(stu);
	}

	public Integer count(String mohu) {
		if(mohu==null){
			mohu="";
		}
		return Integer.parseInt(getCurrentSession().createQuery("select count(*) from Student where name like'%"+mohu+"%'").uniqueResult()+"");
	}
}
