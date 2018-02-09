package com.cg.fms.dao;

public interface QuerryMapper 
{
	public final String User="select Role from EMPLOYEE_MASTER WHERE Employee_ID=? AND Password=?";
	
	public final String AddCourse="insert into COURSE_MASTER values(?,?,?)";
	
	public final String DeleteCourse="delete from COURSE_MASTER where course_Id=?";
	
	public final String SelectCourse="select course_ID,course_Name,no_Of_Days from COURSE_MASTER where course_Id=?";

	public final String AddFaculty="insert into FACULTY_SKILL values(?,?)";
	
	public static final String UPDATE_COURSE="update course_master set course_name=?,days=? where course_id=?";
	
	public static final String SELECT_COURSES="select course_id,course_name,days from course_master";
	
	
}
