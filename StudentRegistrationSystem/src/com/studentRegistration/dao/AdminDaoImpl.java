package com.studentRegistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.studentRegistration.exceptions.AdminException;
import com.studentRegistration.exceptions.CourseException;
import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Admin;
import com.studentRegistration.models.Batch;
import com.studentRegistration.models.Course;
import com.studentRegistration.models.StudentDTO;
import com.studentRegistration.utility.DBUtil;

public  class AdminDaoImpl implements AdminDao{

	@Override
	public Admin loginAdmin(String username, String password) {
		
		Admin admin = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from administrator where username=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String user = rs.getString("username");
				String pass = rs.getString("password");
				admin = new Admin();
				admin.setUsername(user);
				admin.setPassword(pass);
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
	public String allocateStudentInBatch(int roll, int bid, int cid) throws AdminException {
String message = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE roll = ?");
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String studentName = rs.getString("sname");
				PreparedStatement ps2 =  conn.prepareStatement("SELECT * FROM course WHERE cid = ?");
				ps2.setInt(1, cid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					String courseName = rs2.getString("cname");
					PreparedStatement ps3 = conn.prepareStatement("SELECT bname,seats FROM batch WHERE bid = ? AND cid = ?");
					ps3.setInt(1, bid);
					ps3.setInt(2, cid);
					
					ResultSet rs3 = ps3.executeQuery();
					
					if(rs3.next()) {
						
						String batchName = rs3.getString("bname");
						int batchSeats = rs3.getInt("seats");
						
						if(batchSeats > 0) {
							
							batchSeats--;
							PreparedStatement up = conn.prepareStatement("update batch set seats = ? where bid = ?");
							up.setInt(1, batchSeats);
							up.setInt(2, bid);
							
							int r = up.executeUpdate();
							
							PreparedStatement p = conn.prepareStatement("insert into student_batch values (?,?,?)");
							p.setInt(1, roll);
							p.setInt(2, cid);
							p.setInt(3, bid);
							
							int res = p.executeUpdate();
							
							if(res > 0) {
								
								message = "Student "+studentName+" Added to Batch "+ batchName+" of Course "+courseName+" Successfully.";
							
							}
							else {
								throw new AdminException("Batch and Course Not Matching.");
							}
							
							
						}
						else {
							throw new AdminException("No Seats Available ! Add More Seats to Add more Student.");
						}
					}else {
						throw new AdminException("Batch with Batch ID "+bid+" not Found !");
					}

				}else {
					throw new AdminException("Course with course ID "+ cid + " not Found !");
				}
				
			}else {
				throw new AdminException("Student with Roll number "+ roll+ " not Found !");
			}
			
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		return message;
	}

	
	@Override
	public String updateSeatsOfBatch(int bid, int newSeats) throws AdminException {
         String message = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("update batch SET seats = ? where bid = ?");
			ps.setInt(1, newSeats);
			ps.setInt(2, bid);
			
			int res = ps.executeUpdate();
			
			if(res>0) message = "Batch ID : "+bid+" is Updated with Seats : "+ newSeats+" Successfully.";
			else throw new AdminException("Batch ID Error.");
			
			
		} catch (SQLException e) {
			
			throw new AdminException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<StudentDTO> viewStudentInAllBatches() throws AdminException {
		List <StudentDTO> students= new ArrayList<>();
try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select s.roll,s.sname,c.cid,c.cname,b.bid,b.bname "
					+ "from student s INNER JOIN batch b INNER JOIN course c INNER JOIN "
					+ "student_batch sb ON c.cid = sb.cid AND b.bid = sb.bid");
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				
				int roll = rs.getInt("roll");
				String sName = rs.getString("sname");
				int cid = rs.getInt("cid");
				String cName = rs.getString("cname");
				int bid = rs.getInt("bid");
				String bName = rs.getString("bname");
				flag = false;
				
				
				StudentDTO student = new StudentDTO(roll, sName, cid, cName, bid, bName);
				students.add(student);
				
			}
			
			if(flag) throw new AdminException("No student added to Batch");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AdminException(e.getMessage());
			
		}
		return students;
	}

	
	





}
