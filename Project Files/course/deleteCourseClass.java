package com.masai.course;

import java.util.Scanner;

import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class deleteCourseClass {
	
	public static void deleteCourse() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Name of Course");
			String cName = sc.next();
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				String res = dao.deleteBatch(cName);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CourseException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input");
			
		}
	}
	
}
