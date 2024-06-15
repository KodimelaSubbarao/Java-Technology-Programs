package com.voidmain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection
{
	
	private DBConnection()
	{
		
	}
	public static Connection getConnection() throws SQLException,ClassNotFoundException
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:xe","system","subbu");
		}
		catch(SQLException | ClassNotFoundException sql)
		{
			sql.printStackTrace();
			throw sql;
		}
		return con;
	}
}
