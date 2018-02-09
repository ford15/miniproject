package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.fms.exception.FeedbackException;
import com.cg.fms.util.DBConnection;

public class UserDao implements IUserDao
{
	@Override
	public String UserVerification(int id,String pass) throws FeedbackException
	{
		String role=null;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(QuerryMapper.User);

			ps.setInt(1, id);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				role=rs.getString("Role");
			}
			
			con.close();
		} catch (FeedbackException e) {
				throw new FeedbackException("login failed sql"+e.getMessage());
				
		} catch (SQLException e) {
				throw new FeedbackException(e.getMessage());
		}
	return role;
	}
	
}
