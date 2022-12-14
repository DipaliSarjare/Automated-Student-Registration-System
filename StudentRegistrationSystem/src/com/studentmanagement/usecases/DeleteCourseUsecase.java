package com.studentmanagement.usecases;

import java.util.Scanner;

import com.studentmanagement.dao.AdminDao;
import com.studentmanagement.dao.AdminDaoImpl;
import com.studentmanagment.exceptions.CourseException;

public class DeleteCourseUsecase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Delete Course by its Id");
		System.out.println("=================================");
		
		System.out.println("Enter Course Id to Delete Course");
		int cid = sc.nextInt();
		
		AdminDao admin = new AdminDaoImpl();
		
	
		try {
			String msg = admin.deleteCourse(cid);
			System.out.println(msg);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
