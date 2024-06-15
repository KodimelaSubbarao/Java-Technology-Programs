package Class;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class ClassN 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","system","subbu");
				CallableStatement cs=con.prepareCall("{call ?:=totalmarks(?)}");
				cs.registerOutParameter(1, Types.INTEGER);
				System.out.println("Enter Student Roll Number");
				String rno1=sc.nextLine();
				cs.setString(2, rno1);
				cs.execute();
				System.out.println("Total Marks: "+cs.getInt(1));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
