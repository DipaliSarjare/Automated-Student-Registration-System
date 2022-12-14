package com.studentmanagement.usecases;

import java.util.Scanner;

import com.studentmanagement.dao.AdminDao;
import com.studentmanagement.dao.AdminDaoImpl;

public class UpdateFeesUsecase {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course name to Update Fees");
		String cname = sc.next();
		System.out.println("Enter new Fees to Update");
		int cfees = sc.nextInt();
		
		AdminDao admin = new AdminDaoImpl();
		String msg = admin.updateFees(cname,cfees);
		System.out.println(msg);
		
	}

}
