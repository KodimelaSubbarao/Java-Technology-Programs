package Class;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class ClassQ 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				DatabaseMetaData dmd=con.getMetaData();
				System.out.println("Driver Name: "+dmd.getDriverVersion());
				System.out.println("Driver Name: "+dmd.getDriverName());
				System.out.println("Driver Major Version : "+dmd.getDriverMajorVersion());
//				System.out.println(dmd.getCatalogSeparator());
//				System.out.println(dmd.getCatalogTerm());
				System.out.println(dmd.getDatabaseMajorVersion());
				System.out.println(dmd.getDatabaseMinorVersion());
				System.out.println(dmd.getDatabaseProductName());
				System.out.println(dmd.getDatabaseProductVersion());
				System.out.println(dmd.getDefaultTransactionIsolation());
				System.out.println(dmd.getExtraNameCharacters());
				System.out.println(dmd.getIdentifierQuoteString());
				System.out.println(dmd.getJDBCMajorVersion());
				System.out.println(dmd.getJDBCMinorVersion());
				System.out.println(dmd.getMaxBinaryLiteralLength());
				System.out.println(dmd.getMaxColumnNameLength());
				System.out.println(dmd.getMaxCharLiteralLength());
				System.out.println(dmd.getCatalogSeparator());
				System.out.println(dmd.getMaxColumnsInGroupBy());
				System.out.println(dmd.getMaxColumnsInIndex());
				System.out.println(dmd.getMaxColumnsInOrderBy());
				System.out.println(dmd.getMaxColumnsInSelect());
				System.out.println(dmd.getMaxColumnsInTable());
				System.out.println(dmd.getMaxConnections());
				System.out.println(dmd.getURL());
				System.out.println(dmd.generatedKeyAlwaysReturned());
				
				System.out.println("\n\n");
				PreparedStatement ps=con.prepareStatement
						("update metadata1 set name=?,loc=? where id=?");
				ParameterMetaData pmd=ps.getParameterMetaData();
				System.out.println("count the parameters: "+pmd.getParameterCount());
//				System.out.println(pmd.parameterModeIn);
//				System.out.println(pmd.parameterModeInOut);
//				System.out.println(pmd.parameterModeOut);
//				System.out.println(pmd.parameterNoNulls);
				
				System.out.println("\n\n");
				System.out.print("Enter The Name : ");
				String s=sc.nextLine();
				System.out.print("Enter Your Location: ");
				String s1=sc.nextLine();
				System.out.print("Enter the ID : ");
				int i=sc.nextInt();
				ps.setString(1, s);
				ps.setString(2, s1);
				ps.setInt(3, i);
				int i1=ps.executeUpdate();
				if(i1>0)
					System.out.println("Updated Successfull.....");
				
				PreparedStatement ps1=con.prepareStatement("select * from metadata1 where ID=?");
				System.out.print("Enter the id: ");
				int i2=sc.nextInt();
				ps1.setInt(1, i2);
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				ResultSetMetaData rsmd=rs.getMetaData();
				System.out.println(rsmd.getColumnCount());
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
