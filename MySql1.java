
package com.sa.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql1
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement smt=null;
		ResultSet rs=null;
		
			try
			{
				//oracle.jdbc.driver.OracleDriver ojd=new oracle.jdbc.driver.OracleDriver();
				//DriverManager.registerDriver(ojd);
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:mysql:///subbu","root","Subbu@123");
				if(con!=null)
					smt=con.createStatement();
				String query="select * from product";
				if(smt!=null)
					rs=smt.executeQuery(query);
				if(rs!=null)
				{
					while(rs.next())
					{
						System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
					}
				}
				con.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
