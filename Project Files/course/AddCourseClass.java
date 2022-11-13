package com.masai.course;

import java.util.Scanner;

import com.masai.build.Course;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class AddCourseClass {

	public static void addCourceMethod() throws InputException{

		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Course Name");
			String courseName = sc.next();
			
			System.out.println("Enter Course Fee");
			int coursefee = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter Couse Description");
			String coursedesc = sc.nextLine();
			
			Course course = new Course(courseName, coursefee, coursedesc);
			
			CourseDao dao = new CourseDaoImpl();
			
			String res;
			try {
				res = dao.addCourse(course);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CourseException ce) {
				System.out.println();
				System.out.println(ce.getMessage());
				System.out.println();
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input in Console");	
		}
	}

}
