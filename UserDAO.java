package com.voidmain.dao;

import com.voidmain.pojo.User;

public class UserDAO 
{
	public static String isValidUser(String username,String password)
	{
		String role="";

		User user=getUserById(username);

		if(user!=null && user.getPassword().equals(password) && user.getStatus().equals("yes"))
		{
			role=user.getUserType();
		}

		return role;
	}
}
