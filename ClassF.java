package Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClassF 
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","c##subbu","subbu");
				PreparedStatement ps1=con.prepareStatement("insert into Books values(?,?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("select * from Books");
				PreparedStatement ps3=con.prepareStatement("select * from Books where bcode=?");
				PreparedStatement ps4=con.prepareStatement("update Books set bprice=?,bqty=bqty+? where bcode=?");
				PreparedStatement ps5=con.prepareStatement("delete from Books where bcode=?");
				while(true)
				{
					System.out.println("----------Options---------");
					System.out.println("\t1.Add Book Details");
					System.out.println("\t2.View All Book Details");
					System.out.println("\t3.View Book Details By Code");
					System.out.println("\t4.Update Book Details By Code");
					System.out.println("\t5.Delete Book Details By Code");
					System.out.println("\t6.Exit");
					System.out.println("\n\t\t Choose Optiob.......!");
					int option=Integer.parseInt(sc.nextLine());
					switch(option)
					{
					case 1:
						System.out.println("Enter the Book Code: ");
						String code=sc.nextLine();
						System.out.println("Enter the Book Name: ");
						String name=sc.nextLine();
						System.out.println("Enter the Book Author: ");
						String author=sc.nextLine();
						System.out.println("Enter the Book Price: ");
						float price=Float.parseFloat(sc.nextLine());
						System.out.println("Enter the Book Qty");
						int qty=Integer.parseInt(sc.nextLine());
						System.out.println(code+" "+name+" "+author+" "+price+" "+qty);
						ps1.setString(1, code);
						ps1.setString(2, name);
						ps1.setString(3, author);
						ps1.setFloat(4, price);
						ps1.setInt(5, qty);
						int i=ps1.executeUpdate();
						if(i>0)
						{
							System.out.println("Details Added Successfully.......");
						}
						System.out.println("\n\n");
						break;
					case 2:
						System.out.println("\n\t===========Book Details============\n");
						ResultSet rs1=ps2.executeQuery();
						while(rs1.next())
						{
							System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getFloat(4)+"\t"+rs1.getInt(5));
						}
						System.out.println("\n\n");
						break;
					case 3:
						System.out.println("Enter the Book Code: ");					
						String code1=sc.nextLine();
						ps3.setString(1, code1);
						ResultSet rs2= ps3.executeQuery();
						if(rs2.next())
						{
							System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
						}
						else
						{
							System.out.println("Invalid code.....!");
						}
						break;
					case 4:
						System.out.println("Enter the Book Code: ");
						String code2=sc.nextLine();
						ps3.setString(1, code2);
						ResultSet rs3=ps3.executeQuery();
						if(rs3.next())
						{
							System.out.println("Old Book Price: "+rs3.getFloat(4));
							System.out.println("Enter the New Book Price: ");
							float price1=Float.parseFloat(sc.nextLine());
							System.out.println("Old Book Qty: "+rs3.getInt(5));
							System.out.println("Enter New Book Qty: ");
							int qty1=Integer.parseInt(sc.nextLine());
							ps4.setFloat(1, price1);
							ps4.setInt(2, qty1);
							ps4.setString(3, code2);
							int a=ps4.executeUpdate();
							if(a>0)
							{
								System.out.println("Updated Successfully......");
							}							
						}
						else
						{
							System.out.println("Inavalid code......!");
						}
						break;
					case 5:
						System.out.println("Enter The Book Code:");
						String code3=sc.nextLine();
						ps3.setString(1, code3);
						ResultSet rs4=ps3.executeQuery();
						if(rs4.next())
						{
							ps5.setString(1, code3);
							int x=ps5.executeUpdate();
							if(x>0)
							{
								System.out.println("Deleted Successfully.......!");
							}
						}
						else
						{
							System.out.println("Inavlid Code.......!");
						}
						break;
					case 6:
						System.out.println("Operations Closed");
						System.exit(0);						
					default :
						System.out.println("Enter Invalid Option......!");
						break;
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
