package MainExecution;

import java.sql.Connection;
import java.util.Scanner;

import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.usecases.LoginAdminUsecase;
import com.studentRegistration.usecases.LoginStudentUsecase;

import com.studentRegistration.usecases.StudentRegisterUsecase;
import com.studentRegistration.utility.DBUtil;

public class Main {
	public static void main(String[] args) throws StudentException {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DBUtil.provideConnection();

		System.out.println("===============================");
		System.out.println("Select Admin / Student");
		System.out.println("-------------------------------");
		System.out.println("1. Admin");
		System.out.println("2. Student");
		System.out.println("===============================");
		
		int choice = sc.nextInt();
		if(choice==1)
		{
			
			LoginAdminUsecase.main(null);
			
			
		}
		else if(choice == 2)
		{
			System.out.println("===============================");
			System.out.println("1. New Student Registration");
			System.out.println("2. Student login");
			System.out.println("===============================");
			int schoice = sc.nextInt();
			if(schoice == 1)
			{
				StudentRegisterUsecase.main(null);
			}
			else if(schoice == 2)
			{
				LoginStudentUsecase.main(null);
			}
			else
			{
				System.out.println("Please enter correct Student choice");
			}

		}
		else
		{
			System.out.println("Please enter correct choice");
		}
		
	}
}
