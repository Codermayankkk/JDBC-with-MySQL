package jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcPreparedStatement 
{
  public static void main(String args[])
  {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter employee id = ");
    String empid = sc.next();
    
    System.out.println("Enter employee name = ");
    String empname = sc.next();
    
    System.out.println("Enter employee empmailid = ");
    String empmailid = sc.next();
    
    System.out.println("Enter employee empcontact = ");
    String empcontact = sc.next();
	
	Connection cn = null;
	PreparedStatement pst = null;
	
	try
	{
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Loaded");
      
      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db25", "root", "root@1234");
      System.out.println("Connected");
      
      pst = cn.prepareStatement("INSERT INTO emp VALUES(?,?,?,?)");
      
      pst.setString(1, empid);
      pst.setString(2, empname);
      pst.setString(3, empmailid);
      pst.setString(4, empcontact);
      
      int i = pst.executeUpdate();
      if(i>0)
      {
    	  System.out.println(i+" "+"Record affected");
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
