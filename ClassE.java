package Class;
import java.sql.*;
import java.util.Scanner;
public class ClassE 
{
	void meth1()
	{
		Scanner sc=new Scanner(System.in);
	
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				PreparedStatement ps1=con.prepareStatement("insert into product values(?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("select * from product");
				PreparedStatement ps3=con.prepareStatement("select * from product where code = ?");
				//PreparedStatement ps3=con.prepareStatement("update product set  where code = ?");
				while(true)
				{
					System.out.println("========Prodcut Deatils==========");
					System.out.println("\t1.Add Product");
					System.out.println("\t2.View All Products");
					System.out.println("\t3.View Prodcut By Code");
					System.out.println("\t4.Upadte Product By Code");
					System.out.println("\t5.Delete Porduct By Code");
					System.out.println("\t6.Exit");
					System.out.println("\nChoose Your Opeartion.......!\n");
					int i=sc.nextInt();
					switch(i)
					{
					case 1:
						System.out.println("Enter the Product Code:");
						sc.nextLine();
						String code=sc.nextLine();
						System.out.println("Enter the Product Name:");
						String name=sc.nextLine();
						System.out.println("Enter the Product Price:");
						float price=sc.nextFloat();
						System.out.println("Enter the Product Qty:");
						int qty=sc.nextInt();
						System.out.println(code+"\t"+name+"\t"+price+"\t"+qty);
						
						ps1.setString(1, code);
						ps1.setString(2, name);
						ps1.setFloat(3,price);
						ps1.setInt(4, qty);
						int a=ps1.executeUpdate();
						if(a>0)
						{
							System.out.println("Record Inserted Susccefully....!");
						}
						break;
					case 2:
						ResultSet rs=ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
						}
						System.out.println();
						break;
					case 3:
//						System.out.println("Enter the Prod-Code to display the details:");
//						sc.nextLine();
//						String pC2 = sc.nextLine();
//
//						ps3.setString(1, pC2);
//						ResultSet rs2 = ps3.executeQuery();
//						System.out.println("----Product Details-----");
//						if(rs2.next()) {
//						System.out.println(rs2.getString(1)+"\t"+
//
//						rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
//						}else {
//						System.out.println("Invalid Prod-Code...");
//						}
						
						System.out.println("enter the product code:");	
						sc.nextLine();
						String code1=sc.nextLine();
						
						ps3.setString(1, code1);
						ResultSet rs1=ps3.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4));
						}
						else
						{
							System.out.println("Invalid Product Code");
						}
						System.out.println();						
						break;
					case 4:
						System.out.println("enter the product code:");	
						sc.nextLine();
						String code2=sc.nextLine();
						
						ps3.setString(1, code2);
						ResultSet rs2=ps3.executeQuery();
						if(rs2.next())
						{
							
						}
						else
						{
							System.out.println("Invalid Product Code");
						}
						System.out.println();					
						break;
					case 5:
						System.out.println("enter the product code:");	
						sc.nextLine();
						String code3=sc.nextLine();
						
						ps3.setString(1, code3);
						ResultSet rs3=ps3.executeQuery();
						if(rs3.next())
						{
							
						}
						else
						{
							System.out.println("Invalid Product Code");
						}
						System.out.println();					
						break;
					case 6:
						System.out.println("Operations Are Completed");
						con.close();
						System.exit(0);	
						
					default:
						System.out.println("Invalid Option Choosed.....!");
						break;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//System.out.println(e.getMessage());
			}
		}
		
		
	}
	public static void main(String [] args)
	{
		ClassE eobj=new ClassE();
		eobj.meth1();
	}
}
