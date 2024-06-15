package Class;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class ClassV 
{
	private static final String P_CALL="{call p_temp(?,?)}";
	
	public static void main(String[] args) 
	{
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","subbu");
			CallableStatement cs=con.prepareCall(P_CALL);
			Scanner sc=new Scanner(System.in);)
		{
			System.out.println("Enter id : ");
			int id=sc.nextInt();
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(1, id);
			cs.execute();
			System.out.println(cs.getString(2));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
