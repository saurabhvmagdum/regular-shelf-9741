package com.masai.usecases;

import java.util.Scanner;

import com.masai.build.*;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.expections.adminException;

public class registerAdministratorUseCase {

	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username :");
		String username= sc.next();

		System.out.println("Enter Password :");
		String password= sc.next();
		
		Admin a = new Admin(username, password);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {

            String admin= dao.registerAdmin(a);
            
            System.out.println("Welcome "+admin);
        
		}catch (adminException e) {
			System.out.println(e.getMessage());
		}
	}

}
