package com.masai.dao;

import com.masai.expections.adminException;
import com.masai.build.*;

public interface AdminDao {
	public String registerAdmin(Admin admin)throws adminException;
	
	public Admin signInAdmin(String username, String password)throws adminException;


}
