package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcInsertUpdateDelete 
{
  public static void main(String args[])
  {
	Connection cn = null;
    Statement st = null;
	  
	try
    {
	  Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Loaded");
		
	  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc24", "root", "root@1234");
	  System.out.println("Connected");
		
	  st = cn.createStatement();
      String q = "INSERT INTO emp(emp_name, emp_password, emp_mailid, emp_contact) VALUES('Anil Matkar', 'anil', 'aniljimatkar@rediffmail.com', 9074310145)";
		
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
