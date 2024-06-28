package jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUser 
{
  public static void main(String args[])
  {
	Scanner sc = new Scanner(System.in);
	
	/*System.out.print("Enter employee id = ");
	String empid = sc.next();*/
	
	System.out.print("Enter employee name = ");
	String empname = sc.next();
	
	System.out.print("Enter employee mailid = ");
	String empmailid = sc.next();
	
	System.out.print("Enter employee contact = ");
	String empcontact = sc.next();
	
	Connection cn = null;
	Statement st = null;
	
	try
	{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  System.out.println("Driver Loaded");
	  
	  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc24", "root", "root@1234");
	  System.out.println("Connected");
	  
	  st = cn.createStatement();
	  String q = "INSERT INTO emp(emp_name, emp_password, emp_mailid, emp_contact) VALUES('"+empname+"', '"+empmailid+"', '"+empcontact+"')";
	  
	  int i = st.executeUpdate(q);
	  if(i>0)
	  {
		System.out.println(i+" "+"record affected");  
	  }
	  cn.close();
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e);
	}
	catch(SQLException e)
	{
		System.out.println(e);
	}
  }
}
