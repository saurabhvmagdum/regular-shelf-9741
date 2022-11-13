package com.masai.admin;

import java.util.Scanner;

import com.masai.batch.BatchChoiceClass;
import com.masai.batch.GenerateReportClass;
import com.masai.course.CourseChoiceClass;
import com.masai.courseplan.CoursePlanChoiceClass;
import com.masai.courseplan.ViewAllPlanDayWise;
import com.masai.faculty.FacultyChoice;

public class AdminChoiceClass {
	
	public static void adminOptFunction() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("1. Courses part");
			System.out.println("2. Faculty Part");
			System.out.println("3. Batch Section");
			System.out.println("4. Course Plan");
			System.out.println("5. View Day wise Planner");
			System.out.println("6. Generate Report");
			System.out.println("7. Log Out");
			System.out.println("8. Close the App");
			
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				CourseChoiceClass.courseOptFunction();

			}else if(ch == 2) {
				FacultyChoice.facultyOptions();

			}else if(ch == 3) {
				BatchChoiceClass.facultyOptFunction();
	
			}else if(ch == 4) {
				CoursePlanChoiceClass.CourseOptFunction();

			}else if(ch == 5) {
				ViewAllPlanDayWise.viewAllPlanFunction();

			}else if(ch == 6) {
				GenerateReportClass.viewAllBatch();

			}else if(ch== 8) {
				System.out.println();
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 7) {
				break;
				
			}
			else {
				System.out.println();
				System.out.println("Wrong Input Try Again!");
				System.out.println();
				adminOptFunction();
			}
			
		}
		
		
	}
	
}
