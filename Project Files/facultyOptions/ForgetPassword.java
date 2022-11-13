package com.masai.facultyOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.FacultyOptionsDao;
import com.masai.dao.FacultyOptionsDaoImpl;
import com.masai.exceptions.FacultyOptionsException;
import com.masai.utility.DBUtil;

public class ForgetPassword {
	
	public static boolean forgetPass() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.println("Enter Mobile No. : ");
			String mobile = sc.next();
			
			System.out.println("Enter Email No. : ");
			String email = sc.next();
			
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where mobile = ? and email = ?");
			ps.setString(1, mobile);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				FacultyOptionsDao dao = new FacultyOptionsDaoImpl();
					
				System.out.println("Enter New Password: ");
				String newPass = sc.next();
				
				
				System.out.println("Enter New Password Again : ");
				String newPass2 = sc.next();
				

				if(newPass.equals(newPass2)) {
					
					
					try {
						String res = dao.forgetPassword(mobile, email, newPass2);
						System.out.println();
						System.out.println(res);
						System.out.println();
						
					} catch (FacultyOptionsException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						return false;
					}
					
				}else {
					System.out.println();
					System.out.println("New Password Mismatch..");
					System.out.println();
					return false;
				}
				
				
			}else {
				System.out.println();
				System.out.println("Mobile Number or Email Not Found..");
				System.out.println();
				return false;
				
			}
			
		} catch (SQLException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			return false;
			
		}
		return true;
		
	}
	
}
