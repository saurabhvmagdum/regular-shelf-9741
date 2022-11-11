package com.masai.admin;

import java.util.Scanner;


import com.masai.dao.AdminDao;
import com.masai.dao.adminDaoImple;
import com.masai.exceptions.adminException;

public class adminLoginClass {
	
	public static void LoginAdmin(){
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			
			System.out.println("Enter Username:");
			String uname = sc.next();
			
			System.out.println("Enter Password:");
			String password = sc.next();
			
			AdminDao dao = new adminDaoImple();
			
			try {
				boolean flag = dao.LoginAdmin(uname, password);
				if(flag) {
					adminChioceClass.adminOptFunction();
					return;
				}
		 	
			}catch (adminException e) {
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
		System.out.println("Try After some minutes..");
		System.out.println();
	}
}

