package Class;

import java.sql.*;
import java.util.Scanner;

public class ClassD 
{
	void meth1()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product code");
		int code=sc.nextInt();
		System.out.println("Enter the Product Name");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter the Product Price");
		float price=sc.nextFloat();
		System.out.println("Enter the Product Qty");
		int qty=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
			Statement smt=con.createStatement();
			int i=smt.executeUpdate("insert into product59 values('"+code+"','"+name+"','"+price+"','"+qty+"')");
			if(i>0)
			{
				System.out.println("Values Inserted Successfull.......!");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	void meth2()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from product59");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		ClassD dobj=new ClassD();
		dobj.meth2();
	}
}
