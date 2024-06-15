package app.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.DBConnection;
import app.EmployeeBean;

public class EmpLoginDAO
{
	public EmployeeBean eb =null;
	public EmployeeBean verify(String id)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from employee where eid=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb=new EmployeeBean();
				eb.seteId(rs.getString(1));
				eb.seteName(rs.getString(2));
				eb.seteDesg(rs.getString(3));
				eb.setbSal(rs.getInt(4));
				eb.setHra(rs.getFloat(5));
				eb.setDa(rs.getFloat(6));
				eb.setTotSal(rs.getFloat(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return eb;
	}
}
