package com.studentRegistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Course;
import com.studentRegistration.models.CoursesDTO;
import com.studentRegistration.models.Student;
import com.studentRegistration.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String studentRegistration(Student student)throws StudentException {
		String message = "Not Registered";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into student(roll,sname,gender,email,password,address) values(?,?,?,?,?,?)");
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());
			ps.setString(6, student.getAddress());

			int x = ps.executeUpdate();
			if (x > 0) {
			message= "Student Registered Successfully";
			}

		}
		catch(SQLException e) {
			message = e.getMessage();
			throw new StudentException(message);
		}

		return message;
	}
	
	

	@Override
	public String loginStudent(String username, String password) throws StudentException {
		String msg = "Not Login";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int r = rs.getInt("roll");
				String n = rs.getString("sname");
				String g=rs.getString("gender");
				String user = rs.getString("email");
				String pass = rs.getString("password");
				String addrs=rs.getString("address");
				Student student = new Student(r, n,g, user, pass, addrs);
				msg = "Student Login Successfull!";
			} else {

				throw new StudentException("Invalid Username or Password");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return msg;

	}
	@Override
	public String registerInCourse(int roll, int cid) throws StudentException {
		String msg = "Not Registered";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into student_course values(?,?)");
			ps.setInt(1, roll);
			ps.setInt(2, cid);
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Successfully! Student Registered in Course";

				PreparedStatement ps1 = conn
						.prepareStatement("update course set remainingSeats=remainingSeats-1 where cid = ?");
				ps1.setInt(1, cid);

				int y = ps1.executeUpdate();
			} else {
				throw new StudentException("Student Not Present");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}
	
	@Override
	public String updateDetails(int roll, String field, String nData) throws StudentException {
       String message = null;
		
		try(Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE student set "+field+"=? WHERE roll = ?");
			ps.setString(1, nData); 
			ps.setInt(2, roll);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				message = field+" changed to "+nData + " successfully";
			}else {
				throw new StudentException("Error Updating ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			throw new StudentException(message);
		}
		
		return message;
	}



	@Override
	public List<CoursesDTO> availableCourse() throws StudentException {
List<CoursesDTO> courses = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("SELECT c.cid,c.cname,sum(b.seats) FROM batch b "
					+ "INNER JOIN course c ON c.cid = b.cid GROUP BY c.cid");
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				
				int cid = rs.getInt(1);
				String name = rs.getString(2);
				int totalFees = rs.getInt(3);
				
				flag = false;
				
				CoursesDTO course = new CoursesDTO(cid, name, totalFees);
				
				courses.add(course);
			}
			
			if(flag) throw new StudentException("No course Found");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;
	}



	
	}

	




