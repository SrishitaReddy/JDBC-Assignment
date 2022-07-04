package jdbcdemo1;
import java.sql.*;
import java.util.*;
class Emp
{
	Connection con;
	PreparedStatement stmt;
	
    Emp()
	{
    	 try
    	 {
    		 Class.forName("com.mysql.jdbc.Driver");
    		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
	}
    void insertDatabase()
    {
    	try
    	{
		stmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Employee Id :");
		int id=sc.nextInt();
		System.out.print("Enter Employee Name :");  
		String name=sc.next();
		System.out.print("Enter Employee Age :");
	    int age=sc.nextInt();
		System.out.print("Enter Employee Salary :");
		int sal=sc.nextInt();
		System.out.print("Enter Employee Designation :");
		String desig=sc.next();
		
		stmt.setInt(1, id);
		stmt.setString(2,name);
		stmt.setInt(3,age);
		stmt.setInt(4,sal);
		stmt.setString(5, desig);
		System.out.println("Data inserted successfully...");
		stmt.execute();
		
    	}
		 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    }
    void display()
    {
    	System.out.println("Perform crud opertion on databases");
		System.out.println("Press 1 for insert data in database");
		System.out.println("Press 2 for display data in database");
		System.out.println("Press 3 for update data in database");
		System.out.println("Press 1 for delete data in database");
		System.out.println("Press 5 for exit from crud operations");
    }
    void viewDatabase()
    {
    	try
    	{
    	ResultSet rs=stmt.executeQuery("Select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3)+""+rs.getInt(4)+""+rs.getString(5));
		}
		
    	}
    	catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
    }
    void updateDatabase()
    {
    	try
    	{
    	stmt=con.prepareStatement("update emp set sal=? where ID=?");
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter id to change the salary");
		int Id1=sc.nextInt();
		System.out.println("Enter salary for the update");
		int salary=sc.nextInt();
		stmt.setInt(1, salary);
		stmt.setInt(2, Id1);
		stmt.execute();
		System.out.println("updatesd");
		
    	}
		 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    }
		
		void deleteDataFromDatabase()
		{
			try
			{
				
			Scanner sc=new Scanner(System.in);
			stmt=con.prepareStatement("delete from emp  where ID=?");
			System.out.println("enter the id ");
			int ID2=sc.nextInt();
			stmt.setInt(1,ID2);
			stmt.execute();
			System.out.println("Data is deleted");
			
			}
			 catch(Exception e)
	    	 {
	    		 System.out.println(e);
	    	 }
		}
		
		
	
}
public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp e1=new Emp();
		System.out.println("Perform crud opertion on databases");
		System.out.println("Press 1 for insert data in database");
		System.out.println("Press 2 for display data in database");
		System.out.println("Press 3 for update data in database");
		System.out.println("Press 1 for delete data in database");
		System.out.println("Press 5 for exit from crud operations");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			int n=sc.nextInt();
			switch(n)
			{
				case 1: e1.insertDatabase();
						e1.display();
						break;
				case 2: e1.viewDatabase();
						e1.display();
						break;
				case 3: e1.updateDatabase();
						e1.display();
						break;
				case 4: e1.deleteDataFromDatabase();
						e1.display();
						break;
				case 5:	System.out.println("exit");
						break;
				default: System.out.println("you entered wrong option");
			}
			if(n>=5)	
				break;
		}

	}

}