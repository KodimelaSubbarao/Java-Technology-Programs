package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

public class ClassM 
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
				PreparedStatement ps1=con.prepareStatement("select * from bank where accno=?");
				PreparedStatement ps2=con.prepareStatement("update bank set bal=bal+? where accno=?");
				System.out.println(con.getAutoCommit());
				con.setAutoCommit(false);
				Savepoint sp=con.setSavepoint();
				System.out.println("Enter Your Account Number");
				long acno=sc.nextLong();
				ps1.setLong(1, acno);
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next())
				{
					float bal1=rs1.getFloat(3);
					System.out.println("Enter Your Beneficiary Account Number");
					long acno1=sc.nextLong();
					ps1.setLong(1, acno1);
					ResultSet rs2=ps1.executeQuery();
					if(rs2.next())
					{
						System.out.println("Enter The amount");
						float bal2=sc.nextFloat();
						if(bal2<=bal1)
						{
							ps2.setFloat(1, -bal2);
							ps2.setLong(2, acno);
							int i=ps2.executeUpdate();
							ps2.setFloat(1, bal2);
							ps2.setLong(2, acno1);
							int i1=ps2.executeUpdate();
							if(i1==1 && i==1)
							{
								System.out.println("Transaction Successfull.....");
							}
							else {
								con.releaseSavepoint(sp);
								throw new Exception("Transaction Faild......");
							}
						}
						else {
							throw new Exception("Insufficint Balance.......");
						}
					}
					else {
						throw new Exception("Invalid Beneficiary Account Number");
					}
				}
				else
				{
					throw new Exception("Invalid Account Number");
				}
				con.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
}
