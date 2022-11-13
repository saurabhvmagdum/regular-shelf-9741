package com.masai.course;

import java.util.Scanner;

import com.masai.build.Course;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class searchCourseClass {

	public static void searchByCourse() throws InputException{
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Name of Course");
			String cname = sc.next();
			
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				Course c = dao.searchCourse(cname);
				System.out.println();
				System.out.println("Course Details ");
				System.out.println("Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------");
				System.out.println();
				
			} catch (CourseException e) {
				System.out.println();
				System.out.println( e.getMessage());
				System.out.println();
			}
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input in CONSOLE");
			
		}
		
	}

}
