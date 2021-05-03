package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
//CP - Connection Provider - used to connect with database
public class CP
{
	static Connection con; 
	
	public static Connection createC()
	{
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");  //"com.mysql.jdbc.Driver" or "com.mysql.cj.jdbc.Driver"
		    
			//create the connection...
			String user= "root";
			String password= "1234";
			String url= "jdbc:mysql://localhost:3306/student_manage";	//"student_manage" is database name in MySQL Command Line Client
			
			con =DriverManager.getConnection(url, user, password);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}
 