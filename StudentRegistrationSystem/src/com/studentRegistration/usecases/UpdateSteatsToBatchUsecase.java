package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.exceptions.AdminException;

public class UpdateSteatsToBatchUsecase {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Batch ID : ");

	int bid = 0;
	
	try {
		bid = sc.nextInt();
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
		
	}
	
	System.out.println("Enter Updated Seats : ");
	
	int newSeat = 0;
	
	try {

 
		newSeat = sc.nextInt();;
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Try Again !");
		
		
	};
	
	AdminDao ado = new AdminDaoImpl();
	
	try {
		
		System.out.println(ado.updateSeatsOfBatch(bid, newSeat));
		
	}catch(AdminException ae) {
		
		System.out.println(ae.getMessage());
		
	}
}
	
}
