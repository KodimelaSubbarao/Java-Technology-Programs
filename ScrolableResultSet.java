package resultsets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrolableResultSet 
{
	public static void statements()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=smt.executeQuery("select * from emp");
			rs.first();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			rs.absolute(5);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			rs.last();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			System.out.println();
			//rs.afterLast();
			rs.beforeFirst();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			System.out.println();
			rs.afterLast();
			rs.relative(8); //it is used only after the afterLast() only
			while(rs.previous())
			{
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		ScrolableResultSet.statements();
	}
}

/*
 	type:
	 	1. TYPE_FORWORD_ONLY ->1003
	 	2. TYPE_SCROLL_INSENSITIVE ->1004 , we can changes apply on result-set and can not apply instance/buffer table
	 	3. TYPE_SCROLL_SENSITIVE ->1005,we can changes apply on result-set and also apply instance/buffer table
	 Mode:
	 	1. CONCUR_READ_ONLY ->1007
	 	2. CONCUR_UPDATABLE ->1008
	 	
	 Methods:
	 	1. afterLast() -> Cursor points to the after the last row of the table
	 	2. beforeFirst() -> Cursor points to the before the first row of the table
	 	3. first() -> Cursor points to first row
	 	4. last() -> Cursor points to last row
	 	5. next() -> Cursor moves the forward direction
	 	6. previous() -> Cursor moves the backward direction
	 	7. absolute(int) -> It is Makes the cursor points to specified row number.
	 	8. relative(int) -> It is move the cursor from current position by increment/decrement value;
	 	
 */