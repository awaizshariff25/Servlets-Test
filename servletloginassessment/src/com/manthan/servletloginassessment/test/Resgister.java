package com.manthan.servletloginassessment.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.servletbean.test.UserBean;
import com.manthan.servletloigndoa.test.UserDao;
import com.manthan.servletloigndoa.test.UserDaoImpl;


@WebServlet("/register")
public class Resgister extends HttpServlet{

	private UserDao dao= new UserDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {

			UserBean bean=(UserBean) session.getAttribute("bean");

			String id=req.getParameter("username");
			String password=req.getParameter("password");
			int age=Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");

			UserBean bean1 = new UserBean();
			bean1.setId(id);
			bean1.setPassword(password);
			bean1.setAge(age);
			bean1.setGender(gender);

		
			if(dao.register())
			{
				req.setAttribute("msg", "User Register successfully");
			}else {
				req.setAttribute("msg", "failed to Register");
			}
			req.getRequestDispatcher("/home").forward(req, resp);

		}else {
			req.setAttribute("msg", "please login again");
			req.getRequestDispatcher("./login").forward(req, resp);
		}
	}
}
