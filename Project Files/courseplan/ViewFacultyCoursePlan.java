package com.masai.courseplan;

import java.util.List;

import com.masai.build.CoursePlan;
import com.masai.dao.CourseplanDao;
import com.masai.dao.CourseplanDaoImpl;
import com.masai.exceptions.CoursePlanException;

public class ViewFacultyCoursePlan {

	public static void viewByFacultyFunction(int FacultyId) {
		
		CourseplanDao dao = new CourseplanDaoImpl();
		
		try {
			List<CoursePlan> plans = dao.viewFacultyCoursePlan(FacultyId);

			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("%8s %10s %6s %20s %10s %10s", " PLAN ID |", "BATCH ID |", "DAY NO |", "TOPIC |", "PLAN DATE |", "STATUS |");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			
			plans.forEach(e -> {
				System.out.printf("%5s %13s %6s %20s %14s %8s", e.getPlanId(), e.getBatchId(), e.getDaynumber(), e.getTopic(), e.getDate(), e.isStatus());
				System.out.println();
				
			});
			System.out.println();
			
		} catch (CoursePlanException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			
		}

	}

}
