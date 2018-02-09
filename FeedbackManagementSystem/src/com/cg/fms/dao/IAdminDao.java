package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.bean.CourseBean;
import com.cg.fms.bean.FacultySkillBean;
import com.cg.fms.exception.FeedbackException;

public interface IAdminDao {


	public int addCourse(CourseBean bean) throws FeedbackException;

	public CourseBean deleteCourse(int courseId) throws FeedbackException;

	public boolean addFaculty(int facultyId, String facultySkill);
	
	public List<CourseBean> viewAllCourses() throws FeedbackException;
	
	public boolean updateCourse(CourseBean bean) throws FeedbackException;
}
