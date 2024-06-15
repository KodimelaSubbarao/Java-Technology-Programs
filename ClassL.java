package Class;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class ClassL 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","system","subbu");
				//CallableStatement cs=con.prepareCall("{call stdretrieve(?,?,?,?,?,?,?,?,?,?,?)}");
				//                                              1,2,3,4,5,6,7,8,9,10,11
				CallableStatement cs=con.prepareCall("{call str(?,?,?,?,?,?,?,?,?, ?, ?)}");
				System.out.println("Enter the Student Roll Number ");
				String id=sc.nextLine();
				cs.setString(1, id);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.INTEGER);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.BIGINT);
				cs.registerOutParameter(9, Types.INTEGER);
				cs.registerOutParameter(10, Types.VARCHAR);
				cs.registerOutParameter(11, Types.VARCHAR);
				cs.execute();
				System.out.println(id+"\t"+cs.getString(2)+"\t"+cs.getString(3)+"\t"+cs.getString(4)+"\t"+cs.getString(5)+"\t"+cs.getInt(6)+"\t"+cs.getString(7)+"\t"+cs.getLong(8)+"\t"+cs.getInt(9)+"\t"+cs.getString(10)+"\t"+cs.getString(11));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
