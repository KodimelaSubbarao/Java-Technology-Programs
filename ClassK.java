package Class;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ClassK
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
				CallableStatement cs=con.prepareCall("{call stdinsert1(?,?,?,?,?,?,?,?,?,?,?)}");
				System.out.println("-----Enter Student deatils-----");
				System.out.print("Enter the Student Roll NO : ");
				String rno=sc.nextLine();
				System.out.print("Enter the Student Name : ");
				String name=sc.nextLine();
				System.out.print("Enter the Student Branch : ");
				String branch=sc.nextLine();
				System.out.print("Enter the Student City : ");
				String city=sc.nextLine();
				System.out.print("Enter the Student Sate : ");
				String state=sc.nextLine();
				System.out.print("Enter the Student PinCode : ");
				int pcode=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Mail ID : ");
				String mid=sc.nextLine();
				System.out.print("Enter the Student Phone No : ");
				long phno=Long.parseLong(sc.nextLine());
				System.out.print("Enter the Student Subject1 Marks : ");
				int sub1=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Subject2 Marks : ");
				int sub2=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Subject3 Marks : ");
				int sub3=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Subject4 Marks : ");
				int sub4=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Subject5 Marks : ");
				int sub5=Integer.parseInt(sc.nextLine());
				System.out.print("Enter the Student Subject6 Marks : ");
				int sub6=Integer.parseInt(sc.nextLine());
				int tmarks=sub1+sub2+sub3+sub4+sub5+sub6;
				float i=tmarks/600f;
				float f=i*100;
				int percentage=(int)f;
				String percent=percentage+"%";
				String grade;
					if( tmarks>=500)
					{
						grade="A";
					}
					else if( tmarks<500 && tmarks>=450)
					{
						grade="B";
					}
					else if(tmarks<450 && percentage>=270)
					{
						grade="C";
					}
					else if(tmarks<270 &&percentage>=200)
					{
						grade="D";
					}
					else
					{
						grade="F";
					}
				
				cs.setString(1,rno);
				cs.setString(2,name);
				cs.setString(3,branch);
				cs.setString(4,city);
				cs.setString(5,state);
				cs.setInt(6, pcode);
				cs.setString(7,mid);
				cs.setLong(8, phno);
				cs.setInt(9, tmarks);
				cs.setString(10, percent);	
				cs.setString(11, grade);
				cs.execute();
				System.out.println("Insert Successfull");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
