package com.masai.faculty;

import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class AddFacultyClass {
	
	public static void addFacultyMethod() throws InputException{
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter First Name of Faculty");
			String firstname = sc.next();
			
			System.out.println("Enter Last Name of Faculty");
			String lastname = sc.next();
			
			sc.nextLine();
			System.out.println("Enter Faculty Address");
			String address = sc.nextLine();
			
			System.out.println("Enter Faculty State(Short Form)");
			String state = sc.next();
			
			System.out.println("Enter Faculty Pincode");
			String pin = sc.next();
			
			System.out.println("Enter Faculty Mobile No.");
			String mobileNumber = sc.next();
			
			System.out.println("Enter Faculty Email");
			String email = sc.next();
			
			
			Faculty faculty = new Faculty(firstname, lastname, address, state, pin, mobileNumber, email);
			
			FacultyDao dao = new FacultyDaoImpl();
			
			String result;
			try {
				result = dao.addFaculty(faculty);
				System.out.println();
				System.out.println(result);
				System.out.println();
				
			} catch (FacultyException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
			}
		
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input");
			
		}
		
	}
	
}
