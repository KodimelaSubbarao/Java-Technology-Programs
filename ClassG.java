package Class;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClassG 
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
				Statement stm=con.createStatement();				
				while(true)
				{
					System.out.println("=======Options=========");
					System.out.println("\t1.User Registration");
					System.out.println("\t2.Show The User Details");
					System.out.println("\t3.User Login");
					System.out.println("\t4.Exit");
					int choice=Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("Enter The Non-Select Query : ");
						String query=sc.nextLine();
						int i=stm.executeUpdate(query);
						if(i>=0)
						{
							System.out.println("Opration Successful Executed i: "+i);
						}
						break;
					case 2:
						System.out.println("Enter the Select Query: ");
						String query1=sc.nextLine();						
						ResultSet rs=stm.executeQuery(query1);
						System.out.println("=========User Details==========");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getLong(7));
						}
						break;
					case 3:
						System.out.println("Enter the Table Name: ");
						String table=sc.nextLine();
						System.out.println("Enter Your UserName :");
						String uname=sc.nextLine();
						System.out.println("Enter Your Password : ");
						String pword=sc.nextLine();
						ResultSet rs1=stm.executeQuery("select * from "+table);
						while(rs1.next())
						{
							if(uname.equalsIgnoreCase(rs1.getString(1)) && pword.equalsIgnoreCase(rs1.getString(2)))
							{
								System.out.println("Login Successfull");
							}
							else
							{
//								if(uname.equals(rs1.getString(1)))
//									System.out.print("Invalid User Name");
//								else if(pword.equals( rs1.getString(2)))
//									System.out.print("Inavalid Password");
//								else
//									System.out.println("Invalid User Name and Password");
//								System.out.println();
								
								System.out.println("User Login Failed");
								break;
							}
						}
						break;	
					case 4:
						System.out.println("Operations closed");
						System.exit(0);
					default:
						System.out.println("Enter The Valid Option.......!");
						break;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}		
	}
}
