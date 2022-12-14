package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.models.Admin;
import com.studentmanagement.models.Course;
import com.studentmanagement.utility.DBUtil;
import com.studentmanagment.exceptions.CourseException;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin loginAdmin(String name,String username, String password) {
		
		Admin admin = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from admin where name=?, username=? , password=?");
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String nam = rs.getString("name");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				admin = new Admin(nam,user,pass);
			}
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		
		
		
		return admin;
	}

	@Override
	public String addCourse(int cid, String cname, double cfees, String duration, int totalSeat, int remainingSeat) {
		// TODO Auto-generated method stub
		
		String msg = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?,?,?)");
			
			ps.setInt(1, cid);
			ps.setString(2, cname);
			ps.setDouble(3, cfees);
			ps.setString(4, duration);
			ps.setInt(5, totalSeat);
			ps.setInt(6, remainingSeat);
			
			int x = ps.executeUpdate();
		
			if(x>0)
			{
				msg = "Course Added Successfully";
				
			}
			else
			{
				msg = "Course Not Added";
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateFees( String cname,int cfees) {
String msg = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("update course set cfees = ? where cname = ?");
			
			ps.setInt(1, cfees);
			ps.setString(2, cname);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Fees Updated Successfully";
			}
			else
			{
				msg = "Fees Not Updated";
			}
		}
		catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		
		return msg;
	}
	

	@Override
	public String deleteCourse(int cid) throws CourseException {
		
String msg = "Course Not Deleted";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("delete from course where cid = ?");
			ps.setInt(1, cid);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Course Deleted Successfully";
			}
			else
			{
				throw new CourseException("Course Not Found");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}





}
