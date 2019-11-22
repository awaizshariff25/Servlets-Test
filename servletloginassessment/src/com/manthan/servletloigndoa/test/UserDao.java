package com.manthan.servletloigndoa.test;

import com.manthan.servletbean.test.UserBean;

public interface UserDao {

	public UserDao login(int Id, String password);
	public boolean forgot(String name);
	public UserBean home( String name);
	public boolean register();
	
	
	
}
