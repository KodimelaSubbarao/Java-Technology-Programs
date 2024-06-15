package app.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.AdminBean;
import app.DBConnection;

public class AdminLoginDAO 
{
	public AdminBean ab=null;
	
	public AdminBean verify(String un,String pw)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from empadmin where uname=? and pword=?");
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
				ab.setAddr(rs.getString(5));
				ab.setMild(rs.getString(6));
				ab.setpHno(rs.getLong(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
