package emp.add;

import java.sql.Connection;
import java.sql.PreparedStatement;

import emp.DBConnection;
import emp.EmployeeBean;

public class AddEmployeeDAO 
{
	public static int k=0;
	public static int inesrt(EmployeeBean eb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into employee59 values(?,?,?,?,?,?,?)");
			ps.setInt(1, eb.getEid());
			ps.setString(2, eb.getEname());
			ps.setString(3, eb.getEjob());
			ps.setFloat(4, eb.getEsal());
			ps.setFloat(5, eb.getEhra());
			ps.setFloat(6, eb.getEda());
			ps.setFloat(7, eb.getEtotsal());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
