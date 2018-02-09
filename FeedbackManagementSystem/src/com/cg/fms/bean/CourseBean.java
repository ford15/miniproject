package com.cg.fms.bean;

public class CourseBean 
{
	
	
	private int courseID;
	
	private String courseName;
	
	private int noOfDays;
	
	
	
	
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public CourseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseBean(int courseID, String courseName, int noOfDays) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.noOfDays = noOfDays;
		
		
	}
	
	
	@Override
	public String toString() {
		return "CourseBean [courseID=" + courseID + ", courseName="
				+ courseName + ", noOfDays=" + noOfDays + "]";
	}

}
