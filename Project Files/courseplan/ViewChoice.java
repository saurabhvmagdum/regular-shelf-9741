package com.masai.courseplan;

import java.util.Scanner;

public class ViewChoice {
	
public static void viewOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. View All Plan Day Wise");
				System.out.println("2. Search By Faculty");
				System.out.println("3. Search By Date");
				System.out.println("4. Back");
				System.out.println("5. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					ViewAllPlanDayWise.viewAllPlanFunction();
					
				}else if(ch == 2) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {	
						ViewFacultyCoursePlan.viewByFacultyFunction(facultyId);
						
					}else {
						System.out.println();
						System.out.println("No Faculty Present with this FacultyId ");
						System.out.println();
					}
					
				}else if(ch == 3) {
					System.out.println("Enter Date(YYYY-MM-DD): ");
					String date = sc.next();
					ViewPlanByDate.viewAllPlan(date);
					
				}else if(ch == 4) {
					break;
					
				}else if(ch == 5) {
					System.out.println();
					System.out.println("See You Soon...");
					System.exit(0);
					
				}else {
					System.out.println();
					System.out.println("Wrong Input Try Again!");
					System.out.println();
					
				}
				
			}
		}catch (Exception e) {
			System.out.println();
			System.out.println("Please Enter Right Input in CONSOLE");
			System.out.println();
			viewOptions();
		}
		
	}
	
}
