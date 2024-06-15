package product.admin.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import product.DBConnection;
import product.admin.AdminBean;

public class AdminLogDAO 
{
	public AdminBean ab=null;
	public AdminBean verify(String un,String pw)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from productadmin where uname=? and pword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ab=new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setpHno(rs.getLong(5));
				ab.setmId(rs.getString(6));								
				ab.setAddr(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ab;
	}
}
