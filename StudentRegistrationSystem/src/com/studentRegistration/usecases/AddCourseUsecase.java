package com.studentRegistration.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.models.Course;

public class AddCourseUsecase {
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Add New Course:");
		System.out.println("=============================");
	System.out.println("Enter Course Id");
	int cid = sc.nextInt();
	
	System.out.println("Enter Course Name");
	String cname = sc.next();
	
	System.out.println("Enter Course Fees");
	double cfees = sc.nextDouble();
	
	System.out.println("Enter duration of Course");
	String duration = sc.next();
	
	System.out.println("Enter Total Number of Seat in "+ cname +" Course");
	int totalSeat = sc.nextInt();
	int remainingSeat = totalSeat;
	Course course = new Course();
	course.setCid(cid);
	course.setCname(cname);
	course.setCfees(cfees);
	course.setDuration(duration);
	course.setTotalSeat(remainingSeat);
	course.setRemainingSeat(remainingSeat);
	AdminDao admin = new AdminDaoImpl();
	
	try {
		String msg = admin.addCourse(course);
		System.out.println(msg);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
	}
}
