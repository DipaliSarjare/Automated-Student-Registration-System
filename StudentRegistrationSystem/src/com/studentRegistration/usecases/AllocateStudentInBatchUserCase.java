package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.exceptions.AdminException;

public class AllocateStudentInBatchUserCase {

	
public static void main(String[] args) {
		

	Scanner sc = new Scanner(System.in);
	
	System.out.println("Add Student To Batch ");
	System.out.println("----------------------");
	
	System.out.println("Enter the Student Roll Number : ");
	
	int roll = 0;
	
	try {
		
		roll = sc.nextInt();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
	}
	
	System.out.println("Enter Course ID : ");

	int cid = 0;
	
	try {
		
		cid =  sc.nextInt();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
	}
	
	System.out.println("Enter Batch ID : ");

	int bid = 0;
	
	try {
		
		bid = sc.nextInt();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
	}
	
	AdminDao ad = new AdminDaoImpl();
	
	try {
		
		System.out.println(ad.allocateStudentInBatch(roll, bid, cid));
		
	} catch (AdminException e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	} 
		
	}

}
