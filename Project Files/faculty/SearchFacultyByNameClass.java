package com.masai.faculty;

import java.util.List;
import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.FacultyException;

public class SearchFacultyByNameClass {
	
	public static boolean searchByName() {
		
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter First Name of Faculty");
			String firstName = sc.next();
			
			FacultyDao dao = new FacultyDaoImpl();
	
			
			try {
				List<Faculty> facultys = dao.searchFacultyByName(firstName);
				
				facultys.forEach( f -> {
					System.out.println();
					System.out.println("Faculty ID : " + f.getFacultyId());
					System.out.println("Faculty Name : " + f.getFname()+ " " + f.getLname());
					System.out.println("Faculty Address : " + f.getAddress() + ", " + f.getState() + ", " + f.getPin());
					System.out.println("Faculty Mobile : " + f.getMobile());
					System.out.println("Faculty Email : " + f.getEmail());
					System.out.println("Faculty Username : " + f.getUsername());
					System.out.println("------------------------------");
					
				});
				System.out.println();
				
				
			} catch (FacultyException fe) {
				System.out.println();
				System.out.println(fe.getMessage());
				System.out.println();
				return false;
			}
		return true;
		
	}
	
}
