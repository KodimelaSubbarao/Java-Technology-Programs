package Class;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.sql.*;
public class ClassB
{

	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
			Statement smt=con.createStatement();
			int i=smt.executeUpdate("insert into student values('Y19ACS480','KORRAYI JAGADEESH',8989895423)");
			int x=smt.executeUpdate("insert into student values('Y19ACS481','BATTINA GOWTHAM',8767787543)");
			System.out.println(i+"\t"+x);
			ResultSet rs=smt.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3));
			}
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
