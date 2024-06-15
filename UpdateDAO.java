package app.edit;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.DBConnection;
import app.EmployeeBean;

public class UpdateDAO 
{
	public int k=0;
	
	public int update(EmployeeBean eb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update employee set bsal=?,hra=?,da=?,totsal=? where eid=?");
			ps.setInt(1, eb.getbSal());
			ps.setFloat(2, eb.getHra());
			ps.setFloat(3, eb.getDa());
			ps.setFloat(4, eb.getTotSal());
			ps.setString(5, eb.geteId());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	
}
