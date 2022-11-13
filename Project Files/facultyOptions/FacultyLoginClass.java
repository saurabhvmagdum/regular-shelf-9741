package com.masai.facultyOptions;

import java.util.Scanner;

import com.masai.build.Faculty;
import com.masai.dao.FacultyOptionsDao;
import com.masai.dao.FacultyOptionsDaoImpl;
import com.masai.exceptions.FacultyOptionsException;

public class FacultyLoginClass {
	
	public static void loginFaculty() {
		Faculty faculty = null;
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			System.out.println("Enter Username:");
			String uname = sc.next();
			
			System.out.println("Enter Password:");
			String pass = sc.next();
			
			FacultyOptionsDao dao = new FacultyOptionsDaoImpl();
			
			try {
				faculty = dao.loginFaculty(uname, pass);
//				System.out.println(faculty);
				if(faculty == null) {
					
				}else {				
					System.out.println();
					System.out.println(" Welcome "+faculty.getFname());
					System.out.println();
					FacultyLoginOption.facultyOption(faculty);
					return;
				}
		 	
			}catch (FacultyOptionsException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				System.out.println(i+" Attempts Left..");
				System.out.println();
				while(true) {
					System.out.println("1. Forget Password");
					System.out.println("2. Want to try again?");
					System.out.println("3. Exit");
					
					String ch = sc.next();
					if(ch.equals("1")) {	
						boolean check = ForgetPassword.forgetPass();
						if(check)
							return;
						else
							break;
					}else if(ch.equals("2")) {	
						break;
					}else if(ch.equals("3")) {	
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
		System.out.println("Try After 5 minutes..");
		System.out.println();
	}
		
}
