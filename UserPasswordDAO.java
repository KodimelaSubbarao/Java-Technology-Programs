package product.user.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

import product.DBConnection;

public class UserPasswordDAO 
{
	public int k=0;
	public int password(String n,String p)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update productuser set pword=? where uname=?");
			ps.setString(1, p);
			ps.setString(2, n);
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
