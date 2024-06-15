package resultsets;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class rowsets 
{
	public static void main(String[] args) {
		new rowsets().meth5();
	}
	public void meth5()
	{	
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			JoinRowSet jrs=rsf.createJoinRowSet();
			jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
			jrs.setUsername("c##subbu");
			jrs.setPassword("subbu");
			jrs.setCommand("select * from emp");
			jrs.execute();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void meth4()
	{	
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			FilteredRowSet jrs=rsf.createFilteredRowSet();
			jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
			jrs.setUsername("c##subbu");
			jrs.setPassword("subbu");
			jrs.setCommand("select * from emp");
			jrs.execute();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void meth3()
	{	
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			WebRowSet jrs=rsf.createWebRowSet();
			jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
			jrs.setUsername("c##subbu");
			jrs.setPassword("subbu");
			jrs.setCommand("select * from emp");
			jrs.execute();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void meth2()
	{	
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			CachedRowSet jrs=rsf.createCachedRowSet();
			jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
			jrs.setUsername("c##subbu");
			jrs.setPassword("subbu");
			jrs.setCommand("select * from emp");
			jrs.execute();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void meth1()
	{	
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			JdbcRowSet jrs=rsf.createJdbcRowSet();
			jrs.setUrl("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE");
			jrs.setUsername("c##subbu");
			jrs.setPassword("subbu");
			jrs.setCommand("select * from emp");
			jrs.execute();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
