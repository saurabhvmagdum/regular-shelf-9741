package com.masai.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class BatchChoiceClass {
	
	public static void facultyOptFunction() {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Add in Batch Section");
				System.out.println("2. Update Batch Section ");
				System.out.println("3. Search Batch Section");
				System.out.println("4. Delete Batch Section");
				System.out.println("5. Allocate Faculty");
				System.out.println("6. Back");
				System.out.println("7. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						addingBatchClass.addBatchMethod();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
				}else if(ch == 2) {
					
					System.out.println("Enter Course Name");
					String batchId = sc.next();
					
					UpdateBatchClass.updateCourseFunction(batchId);
					
				}else if(ch == 3) {
					SearchBatchChoiceClass.batchSearchOptFunction();
					
				}else if(ch == 4) {
					try {
						DeleteBatchClass.deleteBatch();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 5) {
					try {
						AllocateFacultyClass.allocateFacultyFunction();
					} catch (FacultyException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 6) {
					break;
					
				}else if(ch == 7) {
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
			facultyOptFunction();
			
		}
		
	}
	
}
