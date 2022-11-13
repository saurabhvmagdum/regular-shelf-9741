package com.masai.Main;

import java.util.Scanner;

import com.masai.admin.AdminLoginClass;
import com.masai.facultyOptions.FacultyLoginClass;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Course Monitoring System");
		System.out.println();

		Scanner sc = new Scanner(System.in);
			
		while(true) {
				
			System.out.println("1. Admin Login User");
			System.out.println("2. Faculty Login User");
			System.out.println("3. Close ");
				
			String ch = sc.next();
				
			if(ch.equals("1")) {			
				AdminLoginClass.LoginAdminFunction();
					
			}else if(ch.equals("2")) {		
				FacultyLoginClass.loginFaculty();
				
			}else if(ch.equals("3")) {
				System.out.println();
				System.out.println("See You Soon...!!!");
				break;
					
			}else {
				System.out.println();
				System.out.println("You have typed wrong Input Try again!");
				System.out.println();
			}
			
		}
		sc.close();
		
	}
	
}
