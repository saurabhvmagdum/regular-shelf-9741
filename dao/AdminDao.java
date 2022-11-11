package com.masai.dao;

import com.masai.exceptions.adminException;

public interface AdminDao {
	public boolean LoginAdmin(String username , String password) throws adminException;
	
}
