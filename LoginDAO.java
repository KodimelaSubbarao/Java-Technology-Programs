package user.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import user.DBConnection;
import user.UserBean;

public class LoginDAO
{
	ArrayList<UserBean> al=new ArrayList<>();
	public ArrayList<UserBean> retrive()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from uservlog");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserBean ub=new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				al.add(ub);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return al;
	}
}
