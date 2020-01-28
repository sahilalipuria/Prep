package com.cisco.employeemamanagement.dao;

import com.cisco.employeemamanagement.dto.Login;

public interface LoginDAO {
	
	public boolean validate(Login login);
	public String addLogin(Login login);
	public String deleteLogin(String userName);
	public Login getLogin(String userName);


}
