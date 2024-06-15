package app.addemp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.DBConnection;
import app.EmployeeBean;

public class EmployeeAddDAO
{
	public int k=0;
	
	public int insret(EmployeeBean eb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			ps.setString(1, eb.geteId());
			ps.setString(2, eb.geteName());
			ps.setString(3, eb.geteDesg());
			ps.setInt(4, eb.getbSal());
			ps.setFloat(5, eb.getHra());
			ps.setFloat(6, eb.getDa());
			ps.setFloat(7, eb.getTotSal());
			k=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
