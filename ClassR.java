package Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClassR 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				PreparedStatement ps=con.prepareStatement("insert into image1 values(?,?)");
				PreparedStatement ps1=con.prepareStatement("select * from image1 where id=?");
				System.out.print("Enter the id number : ");
				int id=sc.nextInt();
				ps.setInt(1, id);
			//D:\SD-Card\photos\5296.jpg
				
				System.out.println("Enter the file path & name : ");
				File f=new File(sc.next());
				if(f.exists())
				{
					FileInputStream fis=new FileInputStream(f);
					ps.setBinaryStream(2, fis, f.length());
					int i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("Records inserted Successfull.......");
					}
				}
				else {
					System.out.println("Please Enter Valid File Path and Name");
				}
				System.out.print("Enter the id number : ");
				int id1=sc.nextInt();
				ps1.setInt(1, id1);
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
					FileOutputStream fos=new FileOutputStream("new1.jpg");
					InputStream s=rs.getBinaryStream(2);
					System.out.println(s);
					int i=0;
					while((i=s.read())!=-1)
					{
						fos.write(i);
					}
					fos.close();
				}
			
	
				
			}
			catch(Exception e) { e.printStackTrace();}
		}
	}
}
