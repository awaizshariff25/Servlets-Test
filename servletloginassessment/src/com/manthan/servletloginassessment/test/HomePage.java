package com.manthan.servletloginassessment.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.manthan.servletbean.test.UserBean;
import com.manthan.servletloigndoa.test.UserDao;
import com.manthan.servletloigndoa.test.UserDaoImpl;

@WebServlet("/home")
public class HomePage extends HttpServlet {

	UserDao userbean= new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null) {
			String name= req.getParameter("username");
			UserDao dao=new UserDaoImpl();
			UserBean bean=dao.home(name);
			
			if(bean != null) {
				req.setAttribute("home", bean);
				
			}else {
				req.setAttribute("msg", "User Found");
			}
			
			req.getRequestDispatcher("./home").forward(req, resp);
			
			
		}else {
			req.setAttribute("msg", "please login first");
			req.getRequestDispatcher("./login").forward(req, resp);
		}
	}
}

