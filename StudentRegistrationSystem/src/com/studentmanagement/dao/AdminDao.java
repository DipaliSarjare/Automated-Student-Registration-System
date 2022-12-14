package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.models.Admin;
import com.studentmanagement.models.Course;
import com.studentmanagment.exceptions.CourseException;

public interface AdminDao {
	public Admin loginAdmin(String name,String username, String password);
	public String addCourse(int cid, String cname, double fees, String duration, int totalSeat, int remainingSeat);
	
	public String updateFees(String cname,int cfees);
	
	public String deleteCourse(int cid) throws CourseException;
}
