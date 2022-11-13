package com.masai.faculty;

import java.util.Scanner;

import com.masai.exceptions.InputException;

public class FacultyChoice {
	
	public static void facultyOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1. Add Faculty Data");
			System.out.println("2. Update Faculty Data");
			System.out.println("3. Search Faculty Data");
			System.out.println("4. Delete Faculty Data");
			System.out.println("5. Back To Faculty");
			System.out.println("6. Close");
			
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					AddFacultyClass.addFacultyMethod();
					
				} catch (InputException e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					
				}
				
			}else if(ch == 2) {
				UpdateChoiceClass.updateOptions();
				
			}else if(ch == 3) {
				SearchChoiceClass.searchOptFunction();
				
			}else if(ch == 4) {
				try {
					DeleteFacultyClass.deleteFacultyFunction();
				} catch (InputException e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
				}
				
			}else if(ch== 6) {
				System.out.println();
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}else {
				System.out.println();
				System.out.println("Wrong Input Try Again");
				System.out.println();
				
			}
		}
		
	}
	
}
