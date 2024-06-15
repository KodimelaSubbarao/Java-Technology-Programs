package product.user.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

import product.DBConnection;
import product.user.UserBeans;

public class AddUserDAO 
{
	public int k=0;
	
	public int insert(UserBeans ub)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into productuser values(?,?,?,?,?,?,?)");
			ps.setString(1,ub.getuName() );
			ps.setString(2,ub.getpWord() );
			ps.setString(3, ub.getfName());
			ps.setString(4,ub.getlName() );
			ps.setLong(5, ub.getpHno());
			ps.setString(6, ub.getmId());
			ps.setString(7,ub.getAddr() );
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
