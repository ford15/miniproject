package com.cg.fms.service;

import java.util.List;

import com.cg.fms.bean.CourseBean;
import com.cg.fms.exception.FeedbackException;

public interface IAdminService {

	public int addCourse(CourseBean bean) throws FeedbackException;

	public CourseBean deleteCourse(int courseId) throws FeedbackException;

	public boolean addFaculty(int facultyId, String facultySkill);

	public List<CourseBean> viewAllCourses() throws FeedbackException;

	public boolean updateCourse(CourseBean bean) throws FeedbackException;

}
