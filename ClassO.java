package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ClassO 
{
	String url;
	String uname;
	String pword;
	Vector<Connection> v; 
	ClassO(String url,String uname,String pword,Vector<Connection> v)
	{
		this.url=url;
		this.uname=uname;
		this.pword=pword;
		this.v=v;
	}
	void meth1(int n)
	{
			try
			{
				while(v.size()<n)
				{
					Connection con=DriverManager.getConnection(url,uname,pword);
					v.addElement(con);
					con.close();
					System.out.println(con);
				}
				if(v.size()==n)
					System.out.println("Pool is full.....");
			}catch(Exception e) { e.printStackTrace();}
		
	}
	public Connection useingConnection()
	{
		Connection con=v.elementAt(0);
		v.removeElementAt(0);
		return con;		
	}
	public void returnTheconnection(Connection con)
	{
		v.add(con);
		System.out.println("Connection added Successfully to pool agian .......");
	}
}
