package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Retrieve_Data 
{
//	@DESKTOP-08IIGEE
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				PreparedStatement ps=con.prepareStatement("select * from emp where deptno=?");
				System.out.print("Enter the emp deptno: ");
				int table=sc.nextInt();
				ps.setInt(1, table);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
