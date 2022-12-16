package com.studentRegistration.usecases;

import java.util.List;

import com.studentRegistration.dao.AdminDao;
import com.studentRegistration.dao.AdminDaoImpl;
import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.models.StudentDTO;

public class GetStudentInAllBatchesUsecase {
	public static void main(String[] args) {
		AdminDao ado=new AdminDaoImpl();
		try {
			
			List<StudentDTO> students = ado.viewStudentInAllBatches();
			
			if(students.size() == 0) System.out.println("No Data Found");
			else {
				for(StudentDTO sd : students) {
					System.out.println(sd);
					System.out.println("----------------------------");
				}
			}
			
		}catch(AdminException ae) {
			System.out.println(ae.getMessage());
		}
	}
	
}
