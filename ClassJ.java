package Class;
import java.util.Scanner;

import javax.sql.rowset.*;

public class ClassJ {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				RowSetFactory rsf=RowSetProvider.newFactory();
				System.out.println("\t------Choose any Option--------");
				System.out.println("\t1.JdbcRowSet \n\t2.CachedRowSet");
				System.out.print("Enter Your Option: ");
				int i=Integer.parseInt(sc.nextLine());
				switch(i)
				{
				case 1:
					JdbcRowSet jrs=rsf.createJdbcRowSet();
					jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
					jrs.setUsername("c##subbu");
					jrs.setPassword("subbu");
					jrs.setCommand("select * from emp");
					jrs.execute();
					while(jrs.next())
					{
						System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+jrs.getInt(4)+"\t"+jrs.getDate(5)+"\t"+jrs.getFloat(6)+"\t"+jrs.getFloat(7)+"\t"+jrs.getInt(8));						
					}
					jrs.setCommand("select * from test");
					jrs.execute();
					while(jrs.next())
					{
						System.out.println(jrs.getString(1)+"\t"+jrs.getString(2));
					}					
					break;
				case 2:
					CachedRowSet crs=rsf.createCachedRowSet();
					crs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
					crs.setUsername("c##subbu");
					crs.setPassword("subbu");
					crs.setCommand("select * from test where loc=?");
					System.out.print("Enter Your Location Name: ");
					String l=sc.nextLine();
					crs.setString(1, l);
					crs.execute();
					if(crs.next())
					{
						System.out.println(crs.getString(1)+"\t"+crs.getString(2));
					}
					break;
				default:
					System.out.println("Enter Valid Number");
					break;
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
