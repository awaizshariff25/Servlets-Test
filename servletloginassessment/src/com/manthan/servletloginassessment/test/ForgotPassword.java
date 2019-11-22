package com.manthan.servletloginassessment.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.servletloigndoa.test.UserDao;
import com.manthan.servletloigndoa.test.UserDaoImpl;

@WebServlet("/reset")
public class ForgotPassword  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null) {
			
			UserDao userbean=(UserDao) session.getAttribute("userbean");
			
			
			String name= req.getParameter("username");
			
			
			UserDao dao= UserDaoImpl.getDaoInstanc();
			
			
			if(dao.forgot(name))
			{
				req.setAttribute("msg", "Reset password successfully");
			}
			else
			{
				req.setAttribute("msg", "User not present");
			}
			req.getRequestDispatcher("/reset").forward(req, resp);
		}	
		else
		{
			req.setAttribute("msg", "please login again");
			req.getRequestDispatcher("./login").forward(req, resp);
		}
	}
}
