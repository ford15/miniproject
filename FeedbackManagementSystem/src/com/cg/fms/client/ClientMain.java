package com.cg.fms.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.fms.exception.FeedbackException;
import com.cg.fms.service.IUserService;
import com.cg.fms.service.UserService;

public class ClientMain 
{
	
	public static void main(String[] args) 
	{
		try {
		IUserService service=new UserService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your UserId");
		int userId=sc.nextInt();
		System.out.println("Enter your password");
		String password=sc.next();
		
	
		
			String role = service.UserVerification(userId, password);
			if(role==null)
			{
				System.out.println("Invalid ID Password");
			}
			else
			{
			switch(role)
			{
			case "admin":
				AdminConsole admin=new AdminConsole();
				System.out.println("Your logged in as Admin");
				admin.display();
				break;
			case "participant":
				ParticipantConsole par=new ParticipantConsole();
				
				break;
			case "coordinator":
				CoordinatorConsole cord=new CoordinatorConsole();
				break;
			}
		} 
			
		}	
		catch (InputMismatchException e) {
			System.out.println("Entered ID is not valid.");
		}
		catch (FeedbackException e) {
		
			System.out.println(e.getMessage());
		}
		
			
		
	}

}
