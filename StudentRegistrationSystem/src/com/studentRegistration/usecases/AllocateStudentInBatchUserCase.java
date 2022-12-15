package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;

public class AllocateStudentInBatchUserCase {

	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Allocate Student in Batch");
		System.out.println("Enter batch_id (references to Student(roll))");
		int batchid = sc.nextInt();
		System.out.println("Enter Batch name (references to Batch(batch_name))");
		String batch_name = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		try {
			String msg = admin.allocateStudentInBatch(batchid, batch_name);
			System.out.println(msg);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
