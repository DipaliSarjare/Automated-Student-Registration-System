package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.models.Admin;

public class LoginAdminUsecase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		AdminDao adao = new AdminDaoImpl();
		
		try {
			Admin ad = adao.loginAdmin(name,username,password);
			System.out.println("==============================================");
			System.out.println("Admin Login Successfull!");
			System.out.println("Welcome "+ ad.getUsername());
			System.out.println("Select what you want to do");
			System.out.println("==============================================");
			System.out.println("1. Add new Course");
			System.out.println("2. Update Fees of Course");
			System.out.println("3. Delete Course");
			
		
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}

}
