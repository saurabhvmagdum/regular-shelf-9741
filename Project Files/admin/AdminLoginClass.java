package com.masai.admin;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;

public class AdminLoginClass {
	
	public static void LoginAdminFunction(){
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		for(int i=4; i>=0; i--) {
			
			System.out.println("Enter Admin Username:");
			String username = sc.next();
			
			System.out.println("Enter Admin Password:");
			String password = sc.next();
			
			AdminDao dao = new AdminDaoImpl();
			
			try {
				boolean flag = dao.LoginAdmin(username, password);
				if(flag) {
					AdminChoiceClass.adminOptFunction();
					return;
				}
		 	
			}catch (AdminException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				System.out.println(i+" Attempts Left..");
				System.out.println();
				while(true) {
					System.out.println("You want to try again?(y/n)");
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						return;
					}else {
						System.out.println();
						System.out.println("Wrong Input...!");
						System.out.println();
					}
				}
			}
		}
		System.out.println();
		System.out.println("Try After some time...");
		System.out.println();
	}
	
}
