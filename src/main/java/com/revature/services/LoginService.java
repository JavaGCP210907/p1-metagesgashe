package com.revature.services;

public class LoginService {


	
	public boolean eLogin(String username, String password) {
		
	
		
		   if (username.equals("john") && password.equals("123")){
			    return true;
			    
			    } else {
			        return false;
			    }  
		
	}
	
public boolean mLogin(String username, String password) {
	
		
		   if (username.equals("manager") && password.equals("456")){
			    return true;
			    
			    } else {
			        return false;
			    }  
		
	}
	
}