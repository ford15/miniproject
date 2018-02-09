package com.cg.fms.service;

import com.cg.fms.exception.FeedbackException;

public interface IUserService 
{
	
	public String UserVerification(int id,String pass) throws FeedbackException;

}
