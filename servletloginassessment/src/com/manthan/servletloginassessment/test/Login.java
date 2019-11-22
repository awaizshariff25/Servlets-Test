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


@WebServlet("/login5")
public class Login  extends HttpServlet{

	UserDao dao=UserDaoImpl.getDaoInstanc();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Id=Integer.parseInt(req.getParameter("Id"));
		String password =req.getParameter("password");

		UserDao userbean=dao.login(Id, password);

		if(userbean!=null)
		{
			HttpSession session=req.getSession(true);
			session.setAttribute("userbean",userbean);
			req.getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Invalid Credential!!!!");
			req.getRequestDispatcher("./login").forward(req, resp);
		}

	}
}
