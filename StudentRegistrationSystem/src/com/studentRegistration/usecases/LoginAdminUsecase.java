package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.models.Admin;

public class LoginAdminUsecase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter Admin Username");
		String username = sc.next();
		
		System.out.println("Enter Admin Password");
		String password = sc.next();
		AdminDao adao = new AdminDaoImpl();
		
		try {
			Admin ad = adao.loginAdmin(username,password);
			System.out.println("==============================================");
			System.out.println("Admin Login Successfull!");
			System.out.println("Welcome "+ ad.getUsername());
			System.out.println("Select what you want to do");
			System.out.println("==============================================");
			System.out.println("1. Add new Course");
			System.out.println("2. Update Fees of Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Search information about Course");
			System.out.println("5. Create Batch under Course");
			System.out.println("6. Allocate Student in a Batch under a Course");
			System.out.println("7. Update total Seats of a Batch");
			System.out.println("8. View the Student of Every Batch");
			System.out.println("===============================================");
			
			int achoice = sc.nextInt();
			
			if(achoice==1)
			{
				AddCourseUsecase.main(null);
			}
			else if(achoice==2)
			{
				UpdateFeesUsecase.main(null);
			}
			else if(achoice==3)
			{
				DeleteCourseUsecase.main(null);
			}
			else if(achoice==4)
			{
				GetCourseInformation.main(null);
			}
			else if(achoice== 5)
			{
				AddBatchToCourseUsecase.main(null);
			}
			else if(achoice==6)
			{
				AllocateStudentInBatchUserCase.main(null);
			}
			else if(achoice==7)
			{
				UpdateSeatsToBatchUsecase.main(null);
			}
			else if(achoice==8)
			{
				GetStudentInAllBatchesUsecase.main(null);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}


