package com.masai.courseplan;

import java.util.Scanner;


public class UpdateOptClass {
	
	public static void CourseOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Update Status");
				System.out.println("2. Update Day");
				System.out.println("3. Back");
				System.out.println("4. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {
						ChangeStatusAdmin.changeStatusAdminFunction(facultyId);
					}else {
						System.out.println();
						System.out.println("No Faculty Present with FacultyId ");
						System.out.println();
					}
					
				}else if(ch == 2) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {
						UpdateDateClass.updateDateFunction(facultyId);
					}else {
						System.out.println();
						System.out.println("No Faculty Present with this FacultyId.");
						System.out.println();
					}
					
				}else if(ch == 3) {
					break;
					
				}else if(ch == 4) {
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
			CourseOptions();
		}
		
	}
	
}
