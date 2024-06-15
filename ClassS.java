package Class;

import java.io.File
;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClassS 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				PreparedStatement ps=con.prepareStatement("Select * from image1 where id=?");
				System.out.println("Enter the ID : ");
				int id=sc.nextInt();
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					Blob b=rs.getBlob(2);
					byte [] arr=b.getBytes(2, (int)b.length());
					File f=new File("sa1.jpg");
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(arr);
					System.out.println("Image Retrive Successfull....");
					fos.close();					
				}
				else
				{
					System.out.println("Enter valid id number");
				}
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
