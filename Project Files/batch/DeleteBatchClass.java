package com.masai.batch;

import java.util.Scanner;

import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.InputException;

public class DeleteBatchClass {

	public static void deleteBatch() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Batch Id");
			String id = sc.next();
			
			BatchDao dao = new BatchDaoImpl();
			
			try {
				String res = dao.deleteBatch(id);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (BatchException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				
			}
			
		}catch(Exception e) {
			throw new InputException("Please Enter Right Input IN CONSOLE");
			
		}
	}

}
