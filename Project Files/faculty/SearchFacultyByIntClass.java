package com.masai.faculty;

import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class SearchFacultyByIntClass {

	public static void searchByIdFunction() throws InputException{
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Faculty Id");
			int id = sc.nextInt();
			
			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				Faculty f = dao.searchFacultyById(id);
				System.out.println();
				System.out.println("Faculty ID : " + f.getFacultyId());
				System.out.println("Faculty Name : " + f.getFname()+ " " + f.getLname());
				System.out.println("Faculty Address : " + f.getAddress() + ", " + f.getState() + ", " + f.getPin());
				System.out.println("Faculty Mobile : " + f.getMobile());
				System.out.println("Faculty Email : " + f.getEmail());
				System.out.println("Faculty Username : " + f.getUsername());
				System.out.println("------------------------------");
				System.out.println();
				
			} catch (FacultyException fe) {
				System.out.println();
				System.out.println(fe.getMessage());
				System.out.println();
			}
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input in CONSOLE");
			
		}
		

	}

}
