package com.masai.facultyOptions;

import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.faculty.UpdateFacultyDetails;

public class FacultySettings {
	
public static void facultySettings(Faculty faculty) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("1. Update profile");
			System.out.println("2. Update Password");
			System.out.println("3. Back");
			System.out.println("4. Close the App");
			
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateFacultyDetails.UpdateById(faculty.getFacultyId());
					
			}else if(ch == 2) {
				ChangePasswordClass.changePassword(faculty.getFacultyId());

			}else if(ch== 4) {
				System.out.println();
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}
			else {
				System.out.println();
				System.out.println("Wrong Input Try Again!");
				System.out.println();
				facultySettings(faculty);
			}
			
		}
		
	}
	
}
