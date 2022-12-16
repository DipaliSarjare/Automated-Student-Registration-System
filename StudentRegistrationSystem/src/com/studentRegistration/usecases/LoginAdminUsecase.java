package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.models.Admin;

public class LoginAdminUsecase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		AdminDao adao = new AdminDaoImpl();
		
		try {
			Admin admin = adao.loginAdmin(username,password);
			System.out.println("==============================================");
			System.out.println("Admin Login Successfull!");
		
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}

}
