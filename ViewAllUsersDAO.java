package product.admin.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product.DBConnection;
import product.user.UserBeans;
public class ViewAllUsersDAO 
{
	ArrayList<UserBeans> al=new ArrayList<UserBeans>();
	public ArrayList<UserBeans> retrive()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from productuser");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserBeans ub=new UserBeans();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setpHno(rs.getLong(5));
				ub.setmId(rs.getString(6));
				ub.setAddr(rs.getString(7));
				al.add(ub);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
