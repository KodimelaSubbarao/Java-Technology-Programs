package app.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.DBConnection;
import app.EmployeeBean;

public class DeleteDAO 
{
	public int k=0;
	public int delete(String eb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
			ps.setString(1, eb);
			k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
