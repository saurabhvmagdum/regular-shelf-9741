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

public class ChangePasswordClass {
	
	public static void changePassword(int facultyId) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.println("Enter Old Password : ");
			String oldPass = sc.next();
			
			System.out.println("Enter New Password: ");
			String newPass = sc.next();
			
			System.out.println("Enter New Password : ");
			String newPass2 = sc.next();
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where facultyId = ? And password = ?");
			ps.setInt(1, facultyId);
			ps.setString(2, oldPass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(newPass.equals(newPass2)) {
					
					FacultyOptionsDao dao = new FacultyOptionsDaoImpl();
					
					try {
						String res = dao.changePassword(facultyId, newPass2);
						System.out.println();
						System.out.println(res);
						System.out.println();
					} catch (FacultyOptionsException e) {
						
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else {
					System.out.println();
					System.out.println("New Password Mismatch..");
					System.out.println();
				}
				
			}else {
				System.out.println();
				System.out.println("Wrong Old Password..");
				System.out.println();
				
			}
			
		} catch (SQLException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}
	
}
