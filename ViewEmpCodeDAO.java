package emp.empcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import emp.DBConnection;
import emp.EmployeeBean;

public class ViewEmpCodeDAO 
{
	ArrayList<EmployeeBean> al=new ArrayList<>();
	public ArrayList<EmployeeBean> retrieveCode(EmployeeBean eb)
	{
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from employee59 where eid=?");
			ps.setInt(1, eb.getEid());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb.setEname(rs.getString(2));
				eb.setEjob(rs.getString(3));
				eb.setEsal(rs.getFloat(4));
				eb.setEhra(rs.getFloat(5));
				eb.setEda(rs.getFloat(6));
				eb.setEtotsal(rs.getFloat(7));
				al.add(eb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
