package com.masai.Main;

import java.util.Scanner;

import com.masai.admin.AdminLogin;
import com.masai.admin.adminLoginClass;
import com.masai.custom.ConsoleColors;
import com.masai.facultyOptions.FacultyLogin;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Course Monitoring System ");
		System.out.println();

		Scanner sc = new Scanner(System.in);
			
		while(true) {
				
			System.out.println("1. Admin Login");
			System.out.println("2. Faculty Login");
			System.out.println("3. Close");
				
			String ch = sc.next();
				
			if(ch.equals("1")) {			
				adminLoginClass.LoginAdmin();
					
			}else if(ch.equals("2")) {		
				FacultyLogin.login();
				
			}else if(ch.equals("3")) {
				System.out.println();
				System.out.println("See You Soon...");
				break;
					
			}else {
				System.out.println();
				System.out.println("Wrong Input Try Again In Sometime!");
				System.out.println();
				
			}
			
		}
		sc.close();
		
	}
	
}
