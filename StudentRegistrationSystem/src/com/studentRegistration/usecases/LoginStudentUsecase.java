package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.StudentDao;
import com.studentRegistration.dao.StudentDaoImpl;
import com.studentRegistration.exceptions.StudentException;

public class LoginStudentUsecase {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("STUDENT LOGIN");
		System.out.println("==============================");
		
		System.out.println("Enter email for login");
		String email = sc.next();
		System.out.println("Enter password for login");
		String password = sc.next();
		
		StudentDao stu = new StudentDaoImpl();
		
		try {
		String msg = stu.loginStudent(email, password);
		
		System.out.println(msg);
		System.out.println("Select what you want to do");
		System.out.println("1. Register in Course");
		System.out.println("2. Can update this details.");
		System.out.println("3. See Available Course");
		
		int stchoice = sc.nextInt();
		
		if(stchoice==1)
		{
			RegisterInCourseUsecase.main(null);
		}
		else if(stchoice==2)
		{
			UpdateDetailsUsecase.main(null);
		}
		else if(stchoice==3)
		{
			AvailableCoursesUsecase.main(null);
		}
		else
		{
			System.out.println("Please Select Correct Option");
		}
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
