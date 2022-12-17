package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.StudentDao;
import com.studentRegistration.dao.StudentDaoImpl;
import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Student;

public class RegisterInCourseUsecase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Register Student in Course");
		System.out.println("=============================");
		
		System.out.println("Enter Student Roll (References student(roll))");
		int  roll =sc.nextInt();
		System.out.println("Enter Course ID (references course(cid))");
		int cid = sc.nextInt();
		
		StudentDao stu = new StudentDaoImpl();

		try {
			String msg = stu.registerInCourse(roll, cid);
			System.out.println(msg);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
