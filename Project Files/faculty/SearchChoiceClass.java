package com.masai.faculty;

import java.util.Scanner;

import com.masai.exceptions.InputException;

public class SearchChoiceClass {
	
	public static void searchOptFunction() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1. Search By Faculty Id");
			System.out.println("2. Search By Name");
			System.out.println("3. View All Faculty");
			System.out.println("4. Back" );
			System.out.println("5. Close");
			
			int ch = sc.nextInt();
				
			if(ch == 1) {
					
				try {
					SearchFacultyByIntClass.searchByIdFunction();
				} catch (InputException e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
				}
					
			}else if(ch == 2) {
					
				SearchFacultyByNameClass.searchByName();
					
			}else if(ch == 3) {
					
				GetAllFacultiesClass.viewAllFunction();
					
			}else if(ch == 4) {
				
				break;
				
			}else if(ch == 5) {
				System.out.println();	
				System.out.println("See You Soon...");
				System.exit(0);
				
			}
			else {
				System.out.println();	
				System.out.println("Wrong Input Try Again");
				System.out.println();	
			}
			System.out.println();	
		}
		
		
	}
	
}
