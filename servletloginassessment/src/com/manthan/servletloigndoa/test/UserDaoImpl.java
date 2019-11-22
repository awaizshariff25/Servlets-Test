package com.manthan.servletloigndoa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manthan.servletbean.test.UserBean;


public class UserDaoImpl implements UserDao{

	UserBean bean=new UserBean();
	
	@Override
	public UserDao login(int Id, String password) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		UserDao Bean=null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");

			String query="select *from user where username=? and password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Id);
			pstmt.setString(2, password);

			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				bean = new UserBean();
				bean.getId();
				bean.getPassword();
				bean.getAge();
				bean.getGender();
				
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean forgot(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdded=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");

			String query="upadte user set password=? where username=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);

			int n=pstmt.executeUpdate();

			if(n>0)
			{
				isAdded=true;
			}
			else
			{
				isAdded=false;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		

		return isAdded;
	}

	@Override
	public UserBean home( String name) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		UserBean bean = null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");

			String query="select * from user where username=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();

			if(rs.next())
			{
				bean = new UserBean();
				bean.setId("username");
				bean.setPassword(rs.getString("password"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("salary"));
				
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}

		return bean;
		
	}

	@Override
	public boolean register() {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdded=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");

			String query="insert into user values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getGender());
			

			int n=pstmt.executeUpdate();

			if(n>0)
			{
				isAdded=true;
			}
			else
			{
				isAdded=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return isAdded;

	}

	public static UserDao getDaoInstanc() {
		return new UserDaoImpl();
	}

	
	
	
	

}// end of class
