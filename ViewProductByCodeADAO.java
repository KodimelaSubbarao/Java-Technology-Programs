package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductByCodeADAO
{
	ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retriveByCode()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from product where code=?");
			ProductBean pb=ViewProductByCodeServlet.pb;
			ps.setString(1,pb.getCode());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				al.add(pb);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
