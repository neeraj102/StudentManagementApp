import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{
			System.out.println("PRESS 1 TO ADD student");
			System.out.println("PRESS 2 TO Delete student");
			System.out.println("PRESS 3 TO Display student");
		    System.out.println("PRESS 4 TO Exit App");
			
			int c=Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				//Add student
				System.out.println("Enter user name :");
				String name=br.readLine();
				System.out.println("Enter user phone number :");
				String phone=br.readLine();
				System.out.println("Enter user city :");
				String city=br.readLine();
				
				//create student object to store student
				Student st=new Student(name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);         //method to insert student st
				
				if(answer)
				{
					System.out.println("Student is added successfully...");
				}else {
					System.out.println("Something went wrong try again...");
				}
				
				System.out.println(st);                     //display student info
				
				System.out.println();
				
				
			}
			else if(c==2)
			{
				//delete student
				System.out.println("Enter student id to delete :");
				int userId = Integer.parseInt(br.readLine());
				
				boolean answer = StudentDao.deleteStudent(userId);  //method to delete student
				if(answer)
				{
					System.out.println("Deleted Successfully...");
				}
				else {
					System.out.println("Something went wrong...");
				}
			
			}
			else if(c==3)
			{
				//display student
				StudentDao.showAllStudent();
			}
			else if(c==4)
			{
				//exit
				break;
			}
		}
		System.out.println("Thank you for using my Application...");
		
		
	}

}
