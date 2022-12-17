package com.studentRegistration.usecases;

import java.util.Scanner;

import com.studentRegistration.dao.StudentDao;
import com.studentRegistration.dao.StudentDaoImpl;
import com.studentRegistration.exceptions.StudentException;
import com.studentRegistration.models.Student;

import MainExecution.Main;

public class StudentRegisterUsecase {
	public static void main(String[] args) throws StudentException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Student Register here:");
		System.out.println("==================================================");
		System.out.println("Enter Student Roll No.");
		int roll=sc.nextInt();
		System.out.println("Enter Student Name:");
		String name = sc.next();
		
		System.out.println("Enter Student Gender:");
		String gender = sc.next();
		System.out.println("Enter Student Email:");
		String email = sc.next();
		System.out.println("Enter Student password");
		String password = sc.next();
		System.out.println("Enter Student Address");
		String address=sc.next();
		
		StudentDao sdao = new StudentDaoImpl();
		
		Student student = new Student();
		student.setRoll(roll);
		student.setName(name);
		student.setGender(gender);
		student.setEmail(email);
		student.setPassword(password);
		student.setAddress(address);
		
		String msg = sdao.studentRegistration(student);
		System.out.println(msg);
		
		
		
	}
		
	}
	


