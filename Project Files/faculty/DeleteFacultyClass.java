package com.masai.faculty;

import java.util.Scanner;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class DeleteFacultyClass {
	
public static void deleteFacultyFunction() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Faculty ID");
			int id = sc.nextInt();
			
			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				String res = dao.deleteFaculty(id);
				System.out.println();
				System.out.println(res);
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
