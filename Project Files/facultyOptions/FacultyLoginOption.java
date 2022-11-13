package com.masai.facultyOptions;

import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.courseplan.UpdateStatus;
import com.masai.courseplan.UpdateTopicClass;
import com.masai.courseplan.ViewFacultyCoursePlan;


public class FacultyLoginOption {
	
	public static void facultyOption(Faculty faculty) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("1. Fill Day Planner");
			System.out.println("2. Update Status Day Planner");
			System.out.println("3. View Course Plan");
			System.out.println("4. Settings");
			System.out.println("5. Log Out");
			System.out.println("6. Close the App");
			
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateTopicClass.updateTopicFunction(faculty.getFacultyId());
					
			}else if(ch == 2) {
				UpdateStatus.updateStatusClass(faculty.getFacultyId());

			}else if(ch == 3) {
				ViewFacultyCoursePlan.viewByFacultyFunction(faculty.getFacultyId());
	
			}else if(ch == 4) {
				FacultySettings.facultySettings(faculty);

			}else if(ch== 6) {
				System.out.println();
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}
			else {
				System.out.println();
				System.out.println("Wrong Input Try Again!");
				System.out.println();
				facultyOption(faculty);
			}
			
		}
		
	}
	
}
