package Class;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class ClassP
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				//jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE
				System.out.print("Enter The DB Url : ");
				String url=sc.next();
				System.out.print("Enter The User Name : ");
				String uname=sc.next();
				System.out.print("Enter The PassWorrd : ");
				String pword=sc.next();
				ClassO obj=new ClassO(url,uname,pword, new Vector<Connection>());
				System.out.print("Enter the Number of Connectons : ");
				int c=sc.nextInt();
				System.out.println("\n");
				obj.meth1(c);
				
				System.out.println("\n");
				System.out.println("User1 taken Connection");
				Connection con1=obj.useingConnection();
				System.out.println(con1);
				System.out.println("Pool-Size:"+obj.v.size());
				System.out.println("\n");
				
				System.out.println("User2 taken Connection");
				Connection con2=obj.useingConnection();
				System.out.println(con2);
				System.out.println("Pool-Size:"+obj.v.size());
				System.out.println("\n");
				
				System.out.println("User3 taken Connection");
				Connection con3=obj.useingConnection();
				System.out.println(con3);
				System.out.println("Pool-Size:"+obj.v.size());
				System.out.println("\n");
				
				System.out.println("User4 taken Connection");
				Connection con4=obj.useingConnection();
				System.out.println(con4);
				System.out.println("Pool-Size:"+obj.v.size());
				
				System.out.println("\n");
				System.out.println("User1 return Connection");
				obj.returnTheconnection(con1);
				System.out.println("Pool-Size:"+obj.v.size());
				
				System.out.println("User2 return Connection");
				obj.returnTheconnection(con2);
				System.out.println("Pool-Size:"+obj.v.size());
				
				System.out.println("User3 return Connection");
				obj.returnTheconnection(con3);
				System.out.println("Pool-Size:"+obj.v.size());
				
				System.out.println("User4 return Connection");
				obj.returnTheconnection(con4);
				System.out.println("Pool-Size:"+obj.v.size());
				System.out.println("\n");
				Iterator<Connection> i=obj.v.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			/*
			 * oracle.jdbc.driver.T4CConnection@1e178745
			 * oracle.jdbc.driver.T4CConnection@6f10d5b6
			 * oracle.jdbc.driver.T4CConnection@548a24a
			 * oracle.jdbc.driver.T4CConnection@2a693f59
			 * oracle.jdbc.driver.T4CConnection@304bb45b
			 * oracle.jdbc.driver.T4CConnection@25be7b63
			 * oracle.jdbc.driver.T4CConnection@4c163e3
			 * oracle.jdbc.driver.T4CConnection@4d0d9fe7
			 */
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
