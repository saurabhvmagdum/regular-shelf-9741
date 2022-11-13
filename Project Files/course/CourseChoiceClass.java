package com.masai.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.exceptions.InputException;

public class CourseChoiceClass {
	
	public static void courseOptFunction() {
		
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add Course Data");
				System.out.println("2. Update Course Data");
				System.out.println("3. Search Course Data");
				System.out.println("4. Delete Course Data");
				System.out.println("5. Back To Course");
				System.out.println("6. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						AddCourseClass.addCourceMethod();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						
					}
					
				}else if(ch == 2) {
					
					while(true) {
						System.out.println("Enter Course Name");
						String name = sc.next();
						
						boolean flag = searchCourseByName.searchByName(name);
						if(flag) {					
							updateCourseClass.updateCourse(name);
							break;
						}else {
							System.out.println();
							System.out.println("Course Name does not found..!!!");
							System.out.println();
						}
					}
					
				}else if(ch == 3) {
					courseSearchChoiceClass.courseSearchOptions();
					
				}else if(ch == 4) {
					try {
						deleteCourseClass.deleteCourse();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
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
			System.out.println();
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println("Wrong Input Try Again!");
			System.out.println();
			courseOptFunction();
			
		}
		
	}
	
}
