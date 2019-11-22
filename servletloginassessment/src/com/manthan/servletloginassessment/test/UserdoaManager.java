package com.manthan.servletloginassessment.test;

import com.manthan.servletloigndoa.test.UserDao;
import com.manthan.servletloigndoa.test.UserDaoImpl;

public class UserdoaManager {

	public static UserDao getDaoInstance()
	{
		return new UserDaoImpl();
	}
}
