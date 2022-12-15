package com.studentRegistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Admin;
import com.studentRegistration.models.Batch;
import com.studentRegistration.models.Course;
import com.studentRegistration.utility.DBUtil;

public  class AdminDaoImpl implements AdminDao{

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
	public String addCourse(Course course) {
      String message = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("insert into course values(?,?,?,?,?,?)");
			ps.setInt(1, course.getCid());
			ps.setString(2,course.getCname());
			ps.setDouble(3, course.getCfees());
			ps.setString(4,course.getDuration());
			ps.setInt(5, course.getTotalSeat());
			ps.setInt(6,course.getRemainingSeat());
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				message = "Course Added Successfully";
			}
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
		
		return message;
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

	@Override
	public Course courseInformation(String cname) {
      Course course = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from Course where cname = ?");
			
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next())
			{
				int cid = rs.getInt("cid");
				String coname = rs.getString("cname");
				double fe = rs.getDouble("cfees");
				String dur = rs.getString("duration");
				int tseat = rs.getInt("totalSeats");
				int rseat = rs.getInt("remainingSeats");
				
				 course = new Course(cid,coname,fe,dur,tseat,rseat);
			}
			else
			{
				System.out.println("Course Not Found");
			}
		
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return course;
	}

	@Override
	public String addBatchToCourse(Batch batch) throws AdminException {
      String message = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("INSERT INTO batch VALUES (?,?,?,?,?)");
			ps.setInt(1, batch.getBid() );
			ps.setString(2, batch.getBname());
			ps.setString(3, batch.getDuration());
			ps.setInt(4, batch.getCid());
			ps.setInt(5, batch.getSeats());
			
			int res = ps.executeUpdate();
			
			if(res > 0)
			{
				message="Batch Created Successfully..!";
			}
           else throw new AdminException("Batch Error ! Check Credentials Again.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AdminException(e.getMessage());
		}
		
		
		
		return message;
	}

	@Override
	public String allocateStudentInBatch(int bid, String bname) throws AdminException{
String msg = "Not Registered";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement("select * from student where roll=?");
			ps1.setInt(1, bid);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				
					PreparedStatement ps3 = conn.prepareStatement("insert into student_batch values(?,?)");
					ps3.setInt(1, bid);
					ps3.setString(2, bname);
					
					int x = ps3.executeUpdate();
					if(x>0)
					{
						msg = "Successfull! Student registered in Batch";
						PreparedStatement ps4 = conn.prepareStatement("update batch set seats=seats-1 where bname=?");
						ps4.setString(1, bname);
						int z = ps4.executeUpdate();
					}
					else
					{
						throw new AdminException("Student not allocated in Batch");
					}
				}

			else
			{
				throw new AdminException("Student not found");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return msg;
	}

	





}
