package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.models.Batch;

public class AddBatchToCourseUsecase {
	
public static void main(String[] args) {

	
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter New Batch Details ");
	System.out.println("--------------------------");
	
	System.out.println("Enter the Course ID of the batch : ");
	
	int cid = 0;
	
	try {
		cid = sc.nextInt();
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
	}
	
	System.out.println("Enter the Batch ID (Must be Unique) : ");
	
	int bid = 0;
	
	try {
		bid = sc.nextInt();
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
	}
	System.out.println("Enter the batch name : ");
	String bname = sc.next();
	
	System.out.println("Enter the batch duration ( in months ) : ");
	
	String duration = null;
	
	try {
		duration = sc.next();
		
		
	}catch(Exception e1) {
		System.out.println(e1.getMessage());
		System.out.println("Try Again !");
		
	}
	
	System.out.println("Enter the number of seats in this batch : ");
	int seats = sc.nextInt();
	
	Batch batch = new Batch(bid, bname, duration,cid,seats);
	
	AdminDao ad = new AdminDaoImpl();
	
	try {
		
		System.out.println(ad.addBatchToCourse(batch));
	}catch(AdminException ae) {
		System.out.println(ae.getMessage());
	}
}



}


