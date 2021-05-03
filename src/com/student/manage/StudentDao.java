package com.student.manage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st)    // receive st
	{
		boolean f=false;
		try
		{
			  //jdbc code...
			
		   Connection con=CP.createC();
		   String q="insert into students(sname,sphone,scity) values(?,?,?)";
		   //PreparedStatement
		   PreparedStatement pstmt = con.prepareStatement(q);
		   //set the value of parameter 
		   pstmt.setString(1, st.getStudentName());
		   pstmt.setString(2, st.getStudentPhone());
		   pstmt.setString(3, st.getStudentCity());
		   
		   //execute..
		   pstmt.executeUpdate();
		   f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId)
	{
		// method to delete student
		boolean f=false;
		try
		{
			  //jdbc code...
			
		   Connection con=CP.createC();
		   String q="delete from students where sid=?";
		   //PreparedStatement
		   PreparedStatement pstmt = con.prepareStatement(q);
		   //set the value of parameter 
		   pstmt.setInt(1, userId);     //userId is Integer type  
		   
		   //execute..
		   pstmt.executeUpdate();
		   f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudent()
	{
		// method to display all students
	
		try
		{
			  //jdbc code...
			
		   Connection con=CP.createC();
		   String q="select * from students";   //"students" is table in "student_manage" data base
		   //Create Statement
		   Statement stmt = con.createStatement();
		   
		   //execute...
		   ResultSet set = stmt.executeQuery(q);
		   
		   while(set.next())
		   {
			   int id = set.getInt("sid");              // or set.getInt(1);
			   String name = set.getString("sname");   // or set.getInt(2);
			   String phone = set.getString("sphone"); // or set.getInt(3);
			   String city = set.getString("scity");   // or set.getInt(4);
			   
			   System.out.println("ID : " + id);
			   System.out.println("Name : " + name);
			   System.out.println("Phone : " + phone);
			   System.out.println("City : " + city);
			   System.out.println("++++++++++++++++++++++++++");
		   }
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	

	

}
