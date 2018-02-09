package com.cg.fms.service;

import java.util.List;

import com.cg.fms.bean.CourseBean;
import com.cg.fms.dao.AdminDaoImpl;
import com.cg.fms.dao.IAdminDao;
import com.cg.fms.exception.FeedbackException;

public class AdminService implements IAdminService
{
	IAdminDao dao=new AdminDaoImpl();
	@Override
	public int addCourse(CourseBean bean) throws FeedbackException {
		// TODO Auto-generated method stub
		int course=dao.addCourse(bean);
		
		return course;
	}
	@Override
	public CourseBean deleteCourse(int courseId) throws FeedbackException {
		// TODO Auto-generated method stub
		return dao.deleteCourse(courseId);
	}
	@Override
	public boolean addFaculty(int facultyId, String facultySkill) {
		// TODO Auto-generated method stub
		return dao.addFaculty(facultyId, facultySkill);
	}
	
	@Override
	public List<CourseBean> viewAllCourses() throws FeedbackException {
		return dao.viewAllCourses();
	}

	@Override
	public boolean updateCourse(CourseBean bean) throws FeedbackException {
		return dao.updateCourse(bean);
	}
	

}
