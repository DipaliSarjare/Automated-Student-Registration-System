package com.studentRegistration.dao;

import java.util.List;

import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.models.Admin;
import com.studentRegistration.models.Batch;
import com.studentRegistration.models.Course;
import com.studentRegistration.models.StudentDTO;

public interface AdminDao {
	public Admin loginAdmin(String username, String password);
	public String addCourse(Course course);	
	public String updateFees(String cname,int cfees);
	
	public String deleteCourse(int cid) throws CourseException;
	
	public Course courseInformation(String cname);
	
	public String addBatchToCourse(Batch batch) throws AdminException;
	
	public String allocateStudentInBatch(int roll, int cid, int bid) throws AdminException;
	
	
	public String updateSeatsOfBatch(int bid, int newSeats) throws AdminException;
	
	public List<StudentDTO> viewStudentInAllBatches() throws AdminException;
}
