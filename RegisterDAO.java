package user.reg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import user.DBConnection;
import user.UserBean;

public class RegisterDAO 
{
	public static int k=0;
	
	public int insert(UserBean ub)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into userTable values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ub.getMailId());
			ps.setString(2, ub.getfName());
			ps.setString(3, ub.getmName() );
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getFullName());
			ps.setString(6, ub.getFatherName());
			ps.setString(7, ub.getuName());
			ps.setString(8, ub.getpWord());
			ps.setLong(9, ub.getPhNo());
			ps.setLong(10, ub.getaPhNo());
			ps.setString(11, ub.getAddress());
			k=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
