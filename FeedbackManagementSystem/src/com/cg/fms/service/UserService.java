package com.cg.fms.service;

import com.cg.fms.dao.IUserDao;
import com.cg.fms.dao.UserDao;
import com.cg.fms.exception.FeedbackException;

public class UserService implements IUserService
{
	
	IUserDao dao=new UserDao();

	@Override
	public String UserVerification(int id, String pass)
			throws FeedbackException {
		// TODO Auto-generated method stub
		String role=dao.UserVerification(id, pass);
		
		return role;
	}

}
