package com.studentRegistration.dao;

import java.util.List;

import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Course;
import com.studentRegistration.models.CoursesDTO;
import com.studentRegistration.models.Student;

public interface StudentDao {
	public String studentRegistration(Student student)throws StudentException;
	public String loginStudent(String username, String password) throws StudentException;
	public String registerInCourse( int roll,int cid) throws StudentException;
	public String updateDetails(int roll, String field, String nData) throws StudentException;
	public List<CoursesDTO> availableCourse()throws StudentException;
	

}
