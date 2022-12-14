package com.masai.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;



public class UpdateBatchClass {

	public static void updateCourseFunction(String batchId) {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			boolean flag2 = true;
			
			while(flag) {
				
				String str = "";
				
				while(true) {
					flag2 = true;
					System.out.println("What do you want to update?");
					System.out.println("1. No OF Students");
					System.out.println("2. Start Date");
					System.out.println("3. Batch Duration");
					System.out.println("4. Back");
					System.out.println("5. Close");
					
					int ch = sc.nextInt();
					
					if(ch == 4) {
						flag = false;
						flag2 = false;
						break;
						
					}else if(ch== 5) {
						System.out.println();
						System.out.println("See You Soon...");
						System.exit(0);	
					}
					
				
					if(ch == 1) {
						str = "noOfStudents";
						break;
					}else if(ch == 2) {
						str = "batchstartDate";
						break;
					}else if(ch == 3) {
						str = "duration";
						break;
					}else {
						System.out.println();
						System.out.println("Wrong Input Try Again");
						System.out.println();
						flag2 = false;
						break;
					}
				}
				
				if(flag2) {
					sc.nextLine();
					System.out.println("Enter New Entry :");
					String set = sc.nextLine();
					
					BatchDao dao = new BatchDaoImpl();
					
					String result;
					try {
						result = dao.updateBatch(str, set, batchId);
						System.out.println();
						System.out.println(result);
						System.out.println();
						
					} catch (Exception e) {
						
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
				}
				
				while(flag2) {
					System.out.println("Want to update anything else?(y/n)");
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						flag2 = true;
						break;
					}else if(choice.equalsIgnoreCase("n")){
						flag = false;
						break;
					}else {
						System.out.println();
						System.out.println("Wrong Input...!");
						System.out.println();
					}
				}
				
			}
			
		}catch(InputMismatchException e){
			System.out.println();
			System.out.println("Wrong Input Try Again!");
			System.out.println();
			updateCourseFunction(batchId);
		}

	}

}
