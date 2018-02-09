package com.cg.fms.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.fms.bean.CourseBean;
import com.cg.fms.exception.FeedbackException;
import com.cg.fms.service.AdminService;
import com.cg.fms.service.IAdminService;

public class AdminConsole {
	public void display() throws FeedbackException {
		IAdminService service = new AdminService();
		CourseBean bean = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Add Course Details");
			System.out.println("2.Delete Course");
			System.out.println("3. update course");
			System.out.println("4. view All courses");
			System.out.println("5.Faculty Maintenance");
			
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter your CourseID");
					int courseId = sc.nextInt();
					System.out.println("Enter your CourseName");
					String courseName = sc.next();sc.nextLine();
					System.out.println("Enter no of days");
					int noOfDays = sc.nextInt();
					bean = new CourseBean(courseId, courseName, noOfDays);
					int id = service.addCourse(bean);
					if (id > 0)
						System.out.println("Added Successfully");
				} catch (FeedbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Enter your CourseID");
					int courseId = sc.nextInt();

					bean = service.deleteCourse(courseId);
					if (bean != null) {
						System.out.println(bean.toString());
						System.out.println("Deleted Successfully");
					} else
						System.out.println("CourseID not found.");

				}catch (InputMismatchException e) {
					System.out.println(" CourseID is NOT valid.");
				}
				catch (FeedbackException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
			
			case 4:

			case 5: 
				try {
					System.out.println("Enter faculty ID");
					int facultyId = sc.nextInt();
					System.out.println("Enter the skill");
					String facultySkill = sc.next();

					if (service.addFaculty(facultyId, facultySkill)) {
						System.out
								.println("Faculty details added successfully.");
					} else {
						System.out
								.println("Faculty details couldn't be added.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Faculty Id is NOT valid.");
				}
				break;

			
				
			case 6:
				System.exit(0);
				
				default:System.out.println("Invalid Choice"); 
						break;
			}

		}

	}

}
