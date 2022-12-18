package com.studentRegistration.usecases;

import java.util.ArrayList;
import java.util.List;

import com.studentRegistration.dao.StudentDao;
import com.studentRegistration.dao.StudentDaoImpl;
import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.CoursesDTO;

public class AvailableCoursesUsecase {
	public static void main(String[] args) {
		StudentDao sd = new StudentDaoImpl();
		
		List<CoursesDTO> courses = new ArrayList<>();
		
		try {
			courses = sd.availableCourse();
			
			if(courses.size() == 0) {
				System.out.println("No course to Show.");
			}else {
				for(CoursesDTO c: courses) {
					System.out.println(c);
					System.out.println("-----------------------------");
				}
			}
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
