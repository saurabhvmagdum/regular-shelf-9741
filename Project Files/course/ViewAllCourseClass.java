package com.masai.course;

import java.util.List;

import com.masai.build.Course;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;

public class ViewAllCourseClass {
	
	public static void viewAllCourse() {
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> courses = dao.getAllCourse();
			
			courses.forEach( c -> {
				
				System.out.println();
				System.out.println("Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------");
				
			});
			System.out.println();
			
		} catch (CourseException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}
	
}
