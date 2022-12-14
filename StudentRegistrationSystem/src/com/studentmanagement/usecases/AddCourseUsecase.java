package com.studentmanagement.usecases;

import java.util.Scanner;

import com.studentmanagement.dao.AdminDao;
import com.studentmanagement.dao.AdminDaoImpl;

public class AddCourseUsecase {
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
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
	
	AdminDao admin = new AdminDaoImpl();
	String msg = admin.addCourse(cid, cname, cfees, duration, totalSeat, remainingSeat);
	System.out.println("===============================");
	System.out.println(msg);
	System.out.println("===============================");
	
		
	}
}
