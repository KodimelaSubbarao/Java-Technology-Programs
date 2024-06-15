package product.admin.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

import product.DBConnection;
import product.admin.ProductBean;

public class UpdateProductDAO 
{
	public int k=0;
	
	public int update(ProductBean pb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update products set name=?,price=?,qty=? where code=? ");
			ps.setString(1, pb.getpName());
			ps.setFloat(2, pb.getpPrice());
			ps.setInt(3, pb.getpQty());
			ps.setString(4, pb.getpCode());
			k=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
