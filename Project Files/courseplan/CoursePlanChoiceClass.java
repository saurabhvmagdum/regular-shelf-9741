package com.masai.courseplan;

import java.util.Scanner;


public class CoursePlanChoiceClass {
	

	public static void CourseOptFunction() {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add Course Plan");
				System.out.println("2. Update Course Plan");
				System.out.println("3. View Course Plan");
				System.out.println("4. Delete Course Plan");
				System.out.println("5. Back");
				System.out.println("6. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {					
						AddCoursePlanByFaculty.addCoursePlanMethod(facultyId);
						
					}else {
						System.out.println();
						System.out.println("No Faculty Present with this FacultyId ");
						System.out.println();
					}		
					
				}else if(ch == 2) {
					UpdateOptClass.CourseOptions();
					
				}else if(ch == 3) {
					ViewChoice.viewOptions();
					
				}else if(ch == 4) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					
					if(CheckFacultyId.checkFacultyId(facultyId)) {
						DeletePlanClass.deletePlanFunction(facultyId);
					}else {
						System.out.println();
						System.out.println("No Faculty Present with FacultyId ");
						System.out.println();
					}		
					
				}else if(ch == 5) {
					break;
					
				}else if(ch == 6) {
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
			System.out.println("Please Enter Right Input");
			System.out.println();
			CourseOptFunction();
			
		}
		
	}
	
}
