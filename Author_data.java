package com.bookdata;
import java.sql.Connection;// Library For Create Coonection with DataBase.
import java.sql.PreparedStatement;// Library for Create and Execute the SQL Statements.
import java.sql.ResultSet;//Library for Retrive and Display Data form the datatbase and display on the java application
public class Author_data extends Onlinebook_Management // extend the functionality of Onlinebook_Management class to Book_Data class
{
	int author_id; // variable for store author id.
	String author_name , author_email, author_phone;// variables for stored the values of author_name , author_email, author_phone.
	
	public void add_Author(Connection conn) throws Exception // function to add Author details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variables for stored user choice.
		do
		{
			System.out.println("Enter Author ID : ");
			author_id=sc.nextInt();//Accept author_id from user
			sc.nextLine();
			System.out.println("Enter Author Name : ");
			author_name=sc.nextLine();//Accept author_name form user
			System.out.println("Enter Author Email : ");
			author_email=sc.nextLine();//Accept author_email form user
			System.out.println("Enter Author Phone Number : ");
			author_phone=sc.nextLine();//Accept author_Phone number form user
			
			
			String qur = "insert into author_data (author_id,author_name,author_email,author_phone) value(?,?,?,?)";// insert sql query for insert data into the  Author_details table.
			PreparedStatement ps = conn.prepareStatement(qur);// // execute the sql statement using prepared statement.
			ps.setInt(1,author_id);// set the author values using set() of PreparedStatement.
			ps.setString(2,author_name);
			ps.setString(3,author_email);
			ps.setString(4,author_phone);
			int count = ps.executeUpdate();// storing the execute result into the return value integer.
			if(count>0)// checks the data added or not into the table
			{
				System.out.println("Record Added Successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			System.out.println("DO YOU WANT TO ADD MORE AUTHOR DATA Y/N");
			ch=sc.next().charAt(0);//accepting input from user choice for adding more data in the table
		}while(ch=='Y'||ch=='y');
	}
	
	public void edit_Author(Connection conn) throws Exception // function to edit  Author details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;
		do
		{
		
			System.out.println("What Do You Update In Your Author Record");// display the fields user want to update from the table
			System.out.println("------------------------------------------");
			System.out.println("1. AUTHOR NAME");
			System.out.println("2. AUTHOR EMAIL");
			System.out.println("3. AUTHOR PHONE NUMBER");
			int ch1 =sc.nextInt();// accept choice form user to which field user want to update
			
				switch(ch1)
				{
				case 1:
					// csase 1 for update Author name
					System.out.println("Enter Author Id You want to Update Author Name: ");
					author_id=sc.nextInt();//Accept Author id from user
					sc.nextLine();
					System.out.println("Enter The New Name Of The Author");
					author_name=sc.nextLine();// Accept new name of the Author from user
					
					PreparedStatement ps =conn.prepareStatement("UPDATE  author_data SET author_name = ? WHERE author_id = ?");// update sql query for update data into the table
					ps.setString(1, author_name);// set the new name for the Author
					ps.setInt(2, author_id);// set the Author id
					
					int count=ps.executeUpdate();// storing the execute result into the return value integer
					if(count>0)// checks the data update or not into the table
					{
						System.out.println("Author Name Updated Successfully");
					}
					else
					{
						System.out.println("Author Name Not Updated");
					}
					break;
					
					
				case 2:
					
					// csase 2 for update Author Email
					System.out.println("Enter Author Id You want to Update Author Email: ");
					author_id=sc.nextInt();//Accept Author id from user
					sc.nextLine();
					System.out.println("Enter The New Email For Author");
					author_email=sc.nextLine();// Accept new Author Email of the Author from user
					
					PreparedStatement ps1 =conn.prepareStatement("UPDATE author_data SET author_name = ? WHERE author_id = ?");// update sql query for update data into the table
					ps1.setString(1, author_email);// set the new Author Email for the Author
					ps1.setInt(2, author_id);// set the Author Id
					
					int count1=ps1.executeUpdate();// storing the execute result into the return value integer
					if(count1>0)// checks the data update or not into the table
					{
						System.out.println("Author Email Updated Successfully");
					}
					else
					{
						System.out.println("Author Email Not Updated");
					}
					break;
					
					
				case 3:
					
					// csase 3 for update Author Phone Number
					System.out.println("Enter Author Id You want to Update Phone Number Of Author: ");
					author_id=sc.nextInt();//Accept Author id from user
					sc.nextLine();
					System.out.println("Enter The New Phone Number Of The Author");
					author_phone=sc.toString();// Accept new Author Phone of the Author from user
					
					PreparedStatement ps2 =conn.prepareStatement("UPDATE author_data SET author_phone = ? WHERE author_id = ?");// storing the execute result into the return value integer
					ps2.setString(1, author_phone);// set the new Author Phone number for the Author
					ps2.setInt(2, author_id);// set the Author Id
					
					int count2=ps2.executeUpdate();// storing the execute result into the return value integer
					if(count2>0)// checks the data update or not into the table
					{
						System.out.println("Book Price Updated Successfully");
					}
					else
					{
						System.out.println("Book Price Not Updated");
					}
					break;
				
				default :
					System.out.println("Enter Valid Choice");
					break;
				}
				System.out.println("DO YOU WANT TO UPDATE MORE AUTHOR DATA Y/N");
				ch=sc.next().charAt(0);// Accept user input from user for more data update again
		}while(ch=='Y'||ch=='y');
		
	}
	
	public void author_delete(Connection conn) throws Exception // function to delete Author details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variable to stroed value for perform delete operation again.
		do
		{
			System.out.println("Enter Author Id You Want To Delete Author Data");
			author_id=sc.nextInt();// accept Author id from user for delete Author details
			
			PreparedStatement ps = conn.prepareStatement("delete from author_data WHERE author_id=?");// create sql statement for delete Author data from Author_details table.
			ps.setInt(1,author_id);// set Author id for delete book data
			int count=ps.executeUpdate();//storing the execute result into the return value integer
			if(count>0)// checks the Author data deleted or not into the table
			{
				System.out.println("Author Data Deleted Successfully");
			}
			else
			{
				System.out.println("Author Data Not Deleted");
			}
			System.out.println("DO YOU WANT TO DELETE MORE AUTHOR DATA Y/N");
			ch=sc.next().charAt(0);
		}while(ch=='Y'||ch=='y');
			
	}
	
	
	public void get_author_byId(Connection conn) throws Exception// function to get Author details by using Author_id using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variable to stored values  for get more Author data by using Author_id form the table.
		do
		{
			String qur="select *from author_data where author_id=?";// sql query for retrive data from table
			System.out.println("Enter Author Id : ");
			author_id=sc.nextInt();//accepting Author id from user to retrive Author details.
			PreparedStatement ps = conn.prepareStatement(qur);// create sql statement using preparedstatement.
			ps.setInt(1, author_id);// set the Author id
			ResultSet rs = ps.executeQuery();// execute the sql query and stored into result set for retrive and display Author data.
			while (rs.next()) // next method used to retrive data each row one by one
	        {
	            // Retrieve by column name
	            int author_id = rs.getInt("author_id");
	            String author_name = rs.getString("author_name");
	            String author_email = rs.getString("author_email");
	            String author_phone = rs.getString("author_phone");
	            

	            // Display All Data Of Author Table.
	            System.out.println("Author ID: " + author_id);
	            System.out.println("Author Name: " + author_name);
	            System.out.println("Author Email: " + author_email);
	            System.out.println("Author Phone: " + author_phone);
	            System.out.println("----------------------------");
	        }
			System.out.println("DO YOU WANT TO GET MORE AUTHOR DATA BY ENTERING AUTHOR ID Y/N");
			ch=sc.next().charAt(0);//Accept user input from user for get more Author data  again by using Author id.
		}while(ch=='Y'||ch=='y');
	}
	
	
	public void all_author_details(Connection conn) throws Exception // function to get all Author details  using throws exception passing the Connection conn object for connect with the database.
	{
		PreparedStatement ps = conn.prepareStatement("Select *from author_data"); // create sql statement for display all Authors data form table to java application.
		ResultSet rs = ps.executeQuery();// execute the sql query and stored into result
		
		while (rs.next()) // next method used to retrive data each row one by one
        {
			// Retrieve by column name
            int author_id = rs.getInt("author_id");
            String author_name = rs.getString("author_name");
            String author_email = rs.getString("author_email");
            String author_phone = rs.getString("author_phone");
            

            // Display All Data Of Author Table.
            System.out.println("Author ID: " + author_id);
            System.out.println("Author Name: " + author_name);
            System.out.println("Author Email: " + author_email);
            System.out.println("Author Phone: " + author_phone);
            System.out.println("----------------------------");
        }
		
		
	}
	

	public static void main(String[] args)
	{
		Author_data ad = new Author_data();

	}

}
