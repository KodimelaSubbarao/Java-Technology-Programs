package Class;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ClassT 
{
	private static final  String CREATE_QUERY="CREATE TABLE JOBSEEKER(ID INT,NAME VARCHAR2(20),DBIRTH DATE,PHOTO BLOB,BIODATA CLOB)";
	private static final String INSERT_QUERY="INSERT INTO JOBSEEKER VALUES(?,?,?,?,?)";
	public static void main(String[] args) 
	{
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","subbu");
			PreparedStatement ps1=con.prepareStatement(CREATE_QUERY);
			PreparedStatement ps2=con.prepareStatement(INSERT_QUERY);
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
				System.out.println("Enter Your Name : ");
				sc.nextLine();
				name=sc.nextLine();
				System.out.println("Enter Your Date of birth : ");
				dbirth=sc.nextLine();
				System.out.println("Enter Your Photo Path : (use backward slash seperate folders)");
				pic=sc.next();
				System.out.println("Enter Your Resume Path : (use backward slash seperate folders)");
				resume=sc.next();
				
			}
			if(ps2!=null)
			{
				ps2.setInt(1, id);
				ps2.setString(2, name);
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date d=sdf.parse(dbirth);
				long ms=d.getTime();
				Date date=new Date(ms);
				ps2.setDate(3, date);
				FileInputStream fis=new FileInputStream(pic);
				FileReader fr=new FileReader(resume);
				ps2.setBinaryStream(4, fis);
				ps2.setCharacterStream(5, fr);
				int i=ps2.executeUpdate();
				if(i>0)
					System.out.println("Record Inserted.....");
				else
					System.out.println("Record Not Inserted.....");
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
