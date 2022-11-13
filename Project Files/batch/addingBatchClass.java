package com.masai.batch;


import java.util.Scanner;

import com.masai.build.Batch;
import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.InputException;

public class addingBatchClass {
	

	public static void addBatchMethod() throws InputException{
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter CourseId of the Batch");
			int courseId = sc.nextInt();
		
			System.out.println("Enter Students no. of the Batch");
			int noStudent = sc.nextInt();
			
			System.out.println("Enter Start date of the Batch(YYYY-MM-DD).");
			String batchdate = sc.next();
			
			sc.nextLine();
			System.out.println("Enter Batch Duration");
			String batchDuration = sc.nextLine();
			
			
			Batch batch = new Batch(courseId, noStudent, batchdate, batchDuration);
			
			BatchDao dao1 = new BatchDaoImpl();
			
			try {
				String str = dao1.addBatch(batch);
				System.out.println();
				System.out.println(str);
				System.out.println();
				
			} catch (BatchException e) {

				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input in CONSOLE");
		}
		
	}
}
