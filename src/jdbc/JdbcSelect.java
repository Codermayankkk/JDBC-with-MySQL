package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSelect 
{
   public static void main(String args[])
   {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     
     try
     {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	System.out.println("Driver Loaded");
    	
    	cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db25", "root", "root@1234");
    	System.out.println("connected");
    	
    	st = cn.createStatement();
    	String q = "SELECT * FROM emp";
    	
    	rs = st.executeQuery(q);
    	while(rs.next())
    	{
    	  System.out.print(rs.getString(1) + "\t");
    	  System.out.print(rs.getString(2) + "\t");
    	  System.out.print(rs.getString(3) + "\t");
    	  System.out.println(rs.getString(4));
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
