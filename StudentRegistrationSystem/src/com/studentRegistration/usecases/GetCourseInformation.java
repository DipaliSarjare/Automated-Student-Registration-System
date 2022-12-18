package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.models.Course;

public class GetCourseInformation {
public static void main(String[] args) {
	

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name to get the Information about course");
		String cname = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		Course course = admin.courseInformation(cname);
		
		System.out.println("Course Id: "+course.getCid());
		System.out.println("Course Name: "+course.getCname());
		System.out.println("Course Fee: "+course.getCfees());
		System.out.println("Course Duration: "+course.getDuration());
		System.out.println("Course TotalSeats: "+course.getTotalSeat());
		System.out.println("Course RemainingSeats: "+course.getRemainingSeat());
	}

}

