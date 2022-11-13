package com.masai.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.exceptions.InputException;

public class SearchBatchChoiceClass {
	
	public static void batchSearchOptFunction() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("1. Search By Batch Id");
				System.out.println("2. Search By Course Name");
				System.out.println("3. View All Data");
				System.out.println("4. Back" );
				System.out.println("5. Close");
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						SearchBatchByIdClass.searchBatchByIdFunction();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 2) {				
					try {
						SearchBatchByNameClass.searchBatchByName();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 3) {
					ViewAllBatchClass.viewAllBatchFunction();
					
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
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println("Wrong Input Try Again!");
			System.out.println();
			batchSearchOptFunction();
			
		}
		
	}
	
}
