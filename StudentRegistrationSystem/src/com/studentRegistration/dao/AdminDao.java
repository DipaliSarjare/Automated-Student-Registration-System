package com.studentRegistration.dao;

import java.util.List;

import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.models.Admin;
import com.studentRegistration.models.Batch;
import com.studentRegistration.models.Course;

public interface AdminDao {
	public Admin loginAdmin(String name,String username, String password);
	public String addCourse(Course course);	
	public String updateFees(String cname,int cfees);
	
	public String deleteCourse(int cid) throws CourseException;
	
	public Course courseInformation(String cname);
	
	String addBatchToCourse(Batch batch) throws AdminException;
	
	public String allocateStudentInBatch(int bid, String bname) throws AdminException;
}
