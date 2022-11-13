package com.masai.course;


import com.masai.build.Course;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;

public class searchCourseByName {
	
	public static boolean searchByName(String name)  {
			
		boolean flag = false;

			CourseDao dao = new CourseDaoImpl();
			
			Course c;
			try {
				c = dao.searchCourse(name);
				if(c != null) {
					flag = true;
				}
				
			} catch (CourseException e) {
				return flag;
				
			}
				
				
		
		return flag;
		
	}
	
}
