package Class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class ClassU 
{
	//private static final  String CREATE_QUERY="CREATE TABLE JOBSEEKER(ID INT,NAME VARCHAR2(20),DBIRTH DATE,PHOTO BLOB,BIODATA CLOB)";
	//private static final String INSERT_QUERY="INSERT INTO JOBSEEKER VALUES(?,?,?,?,?)";
	private static final String SELECT_QUERY="SELECT * FROM JOBSEEKER WHERE ID=?";
	public static void main(String[] args) 
	{
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","subbu");
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			Scanner sc=new Scanner(System.in);
			)
		{
//			if(ps1!=null)
//				ps1.executeUpdate(); //table created
			int id=0;
			String name=null,dbirth=null,pic=null,resume=null;
			if(sc!=null)
			{
				System.out.println("Enter your ID : ");
				id=sc.nextInt();			
			}
			if(ps!=null)
			{
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println("Your Id : "+rs.getInt(1));
					System.out.println("Your Name: "+rs.getString(2));
					java.util.Date d=rs.getDate(3);
					System.out.println("Your Date of Birth : "+d);
					InputStream is=rs.getBinaryStream(4);
					InputStream read=rs.getBinaryStream(5);
					OutputStream os=new FileOutputStream("pic.jpg");
					OutputStream write=new FileOutputStream("temp.txt");
					IOUtils.copy(is,os);
					IOUtils.copy(read,write);
					
				}
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
