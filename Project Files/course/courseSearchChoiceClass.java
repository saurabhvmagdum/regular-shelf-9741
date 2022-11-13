package com.masai.course;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.masai.exceptions.InputException;

public class courseSearchChoiceClass {
	
	public static void courseSearchOptions() {
		
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
				
			while(true) {
				
				System.out.println("1. Search By Course");
				System.out.println("2. View All Course");
				System.out.println("3. Back" );
				System.out.println("4. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						searchCourseClass.searchByCourse();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 2) {
					ViewAllCourseClass.viewAllCourse();
					
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
			
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println("Wrong Input Try Again!");
			System.out.println();
			courseSearchOptions();
			
		}
		
	}
}
