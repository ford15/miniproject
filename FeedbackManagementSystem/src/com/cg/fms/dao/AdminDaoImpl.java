package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.fms.bean.CourseBean;
import com.cg.fms.exception.FeedbackException;
import com.cg.fms.util.DBConnection;

public class AdminDaoImpl implements IAdminDao
{
	Connection con;
	CourseBean bean=null;

	@Override
	public int addCourse(CourseBean bean) 
	{
		
		int course = 0;
		try {
			con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(QuerryMapper.AddCourse);
			
			ps.setInt(1, bean.getCourseID());
			ps.setString(2, bean.getCourseName());
			ps.setInt(3, bean.getNoOfDays());
			
			int count=ps.executeUpdate();
			
			if(count>0)
				course=bean.getCourseID();
			else
				throw new FeedbackException("Course Information could not be added");
		} catch (FeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		
		return course;
	}

	@Override
	public CourseBean deleteCourse(int courseId) throws FeedbackException 
	{
		
		try {
			con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(QuerryMapper.SelectCourse);			
			ps.setInt(1, courseId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				bean=new CourseBean();
				bean.setCourseID(rs.getInt("course_ID"));
				bean.setCourseName(rs.getString("course_Name"));
				bean.setNoOfDays(rs.getInt("no_Of_Days"));
				PreparedStatement ps1=con.prepareStatement(QuerryMapper.DeleteCourse);
				ps1.setInt(1, courseId);
				int count=ps1.executeUpdate();
				if(count<0)
					throw new FeedbackException("Course Id not found");
			
			}			
						
		}  catch (SQLException e) {
			throw new FeedbackException(e.getMessage());
		}
		return bean;
	}

	@Override
	public boolean addFaculty(int facultyId, String facultySkill) {
		boolean flag = false;
		try {
			con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(QuerryMapper.AddFaculty);
			ps.setInt(1,facultyId);
			ps.setString(2,facultySkill);
			int count=ps.executeUpdate();
			
			if(count>0)
				 flag = true;
			else
				throw new FeedbackException("Faculty details could not be added");
			   
		} catch (FeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("The entered Faculty ID can't be added to the database.");
		}
		
		
		return flag;
	
	}

	@Override
	public List<CourseBean> viewAllCourses() throws FeedbackException {

		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(QuerryMapper.SELECT_COURSES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseBean bean = new CourseBean();
				bean.setCourseID(rs.getInt("course_id"));
				bean.setCourseName(rs.getString("course_name"));
				bean.setNoOfDays(rs.getInt("no_Of_Days"));
				list.add(bean);
			}
			con.close();
		} catch (SQLException e) {

			throw new FeedbackException("Unable to fetch records");
		}
		return list;
	}

	@Override
	public boolean updateCourse(CourseBean bean) throws FeedbackException {

		boolean flag = false;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(QuerryMapper.UPDATE_COURSE);
			pstmt.setString(1, bean.getCourseName());
			pstmt.setInt(2, bean.getNoOfDays());
			pstmt.setInt(3, bean.getCourseID());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}
			con.close();
		} catch (SQLException e) {

			throw new FeedbackException("Unable to Update");
		}

		return flag;
	}

}
