package product.user.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import product.DBConnection;
import product.user.UserBeans;

public class UserLoginDAO 
{
	public UserBeans ub=null;
	
	public UserBeans logVerfiy(String un,String pw)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from productuser where uname=? and pword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ub=new UserBeans();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setpHno(rs.getLong(5));
				ub.setmId(rs.getString(6));
				ub.setAddr(rs.getString(7));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}
}
