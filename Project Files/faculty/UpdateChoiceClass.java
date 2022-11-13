package com.masai.faculty;


import java.util.Scanner;


public class UpdateChoiceClass {
	
	public static void updateOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {	

			System.out.println("1. Update By Faculty Id");
			System.out.println("2. Update By Faculty Name");
			System.out.println("3. Back");
			System.out.println("4. Close");
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					System.out.println("Enter id of Faculty");
					int id = sc.nextInt();
					
					UpdateFacultyDetails.UpdateById(id);
				}catch(Exception e) {
					System.out.println();	
					System.out.println("Wrong Input Try Again");
					System.out.println();
					updateOptions();
				}
				
			}else if(ch == 2) {
				if(SearchFacultyByNameClass.searchByName()) {
					
					try {
						System.out.println("Enter id of Faculty");
						int id = sc.nextInt();
						UpdateFacultyDetails.UpdateById(id);
					}catch(Exception e) {
						System.out.println();	
						System.out.println("Wrong Input Try Again");
						System.out.println();
						updateOptions();
					}
				}else {
					updateOptions();
				}
				
			}else if(ch== 4) {
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}else {
				
				System.out.println("Wrong Input Try Again");
			}
			
		}
		
		
	}
	
}
