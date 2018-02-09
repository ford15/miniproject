package com.cg.fms.dao;

import com.cg.fms.exception.FeedbackException;

public interface IUserDao 
{
	
	public String UserVerification(int id,String pass) throws FeedbackException;

}
