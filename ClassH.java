package Class;
import java.util.Scanner;
import java.sql.*;
public class ClassH 
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
				Statement smt=con.createStatement();
				while(true)
				{
					System.out.println("======Option=======");
					System.out.println("\t1.Create/Upadte/Insert/Delete");
					System.out.println("\t2.Select");
					System.out.println("\t3.Exit");
					System.out.println("Choose Your Option.......!");
					int i=Integer.parseInt(sc.nextLine());
					switch(i)
					{
					case 1:
						System.out.println("enter the non-select query");
						String query=sc.nextLine();
						int a=smt.executeUpdate(query);
						if(a>=0)
						{
							System.out.println("operation Successfull a: "+a);
						}
						break;
					case 2:
						System.out.println("Enter the Select Query");
						String query1=sc.nextLine();
						ResultSet rs=smt.executeQuery(query1);
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3));
						}
						break;
					case 3:
						System.out.println("Operations Closed......");
						System.exit(0);
					default:
						System.out.println("Invalid Option.....!");
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
