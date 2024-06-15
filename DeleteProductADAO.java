package product.admin.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

import product.DBConnection;

public class DeleteProductADAO 
{
	public int k=0;
	
	public int delete(String code)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from products where code=?");
			ps.setString(1, code);
			k=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
