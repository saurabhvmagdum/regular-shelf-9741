package com.masai.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.FacultyException;
import com.masai.utility.DBUtil;

public class AllocateFacultyClass {

	public static void allocateFacultyFunction() throws FacultyException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		

		try(Connection conn = DBUtil.provideConnection()){
			System.out.println("Enter the Faculty Id :");
			int set = sc.nextInt();
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyId = ?");
			
			ps.setInt(1, set);
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = rs.next();
			if(flag) {
				while(flag) {
					System.out.println("Enter the Batch Id :");
					String batchId = sc.next();
					
					BatchDao dao = new BatchDaoImpl();
					
					try {
						String res = dao.allocateFaculty(set, batchId);
						System.out.println();
						System.out.println(res);
						System.out.println();
						flag = false;
						
					} catch (BatchException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						
					}
		
				}
				
			}else {
				System.out.println();
				System.out.println("Faculty is Not Present..");
				System.out.println();
				allocateFacultyFunction();
			}
			
		}catch(Exception ie) {
			System.out.println();
			System.out.println("Wrong Input Try Again!");
			System.out.println();
			allocateFacultyFunction();
		}
		
	}

}
