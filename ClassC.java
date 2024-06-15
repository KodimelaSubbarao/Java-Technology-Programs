package Class;
import java.sql.*;
import java.util.Scanner;
public class ClassC 
{
	void meth1() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Employee ID");
		String id=sc.nextLine();
		System.out.println("Enter Your Employee Name ");
		String name=sc.nextLine();
		System.out.println("Enter Your Employee Job Name");
		String job=sc.nextLine();
		System.out.println("Enter Your Employee Basic Salary");
		float sal=sc.nextFloat();
		
		float hra=sal*93/100;
		float da=sal*61/100;
		float totalSal=sal+hra+da;
		System.out.println(totalSal);
		System.out.println(da);
		System.out.println(hra);
		System.out.println(sal);
		try(sc;)//try with resource block
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				Statement smt=con.createStatement();
				int i=smt.executeUpdate("insert into employee59 values('"+id+"','"+name+"','"+job+"','"+sal+"','"+hra+"','"+da+"','"+totalSal+"')");
				if(i>0)
				{
					System.out.println("Detatils Inserted Successfull.......!");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	void meth2()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE","c##subbu","subbu");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from employee59");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getFloat(5)+"\t"+rs.getFloat(6)+"\t"+rs.getFloat(7));
			}
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
	public static void main(String [] args)
	{
		ClassC cobj=new ClassC();
		cobj.meth2();
	}
}
