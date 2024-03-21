package com.bookdata;
import java.sql.Connection;// Library For Create Coonection with DataBase
import java.sql.PreparedStatement;// Library for Create and Execute the SQL Statements.
import java.sql.ResultSet;//Library for Retrive and Display Data form the datatbase and display on the java application
public class Book_data extends Onlinebook_Management // extend the functionality of Onlinebook_Management class to Book_Data class
{
	int book_id,book_qunt,author_id; // variables for stored the values of book id , book quantity, author id.
	double book_price;// variables for stored the values of book price.
	String book_name;// variables for stored the book name values
	
	public void add_book(Connection conn) throws Exception // function to add book details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variables for stored user choice.
		do
		{
			System.out.println("Enter Book ID : ");
			book_id=sc.nextInt();//Accept book id from user
			sc.nextLine();
			System.out.println("Enter Book Name : ");
			book_name=sc.nextLine();// Accept book name form user
			System.out.println("Enter Book Price : ");
			book_price=sc.nextDouble();// Accept book price form user
			System.out.println("Enter Book Quantity : ");
			book_qunt=sc.nextInt();// Accept Quantity name form user
			
			String qur = "insert into book_data (book_id,book_name,book_price,book_qunt) value(?,?,?,?)";// insert sql query for insert data into the  book_details table.
			PreparedStatement ps = conn.prepareStatement(qur);// execute the sql statement using prepared statement.
			ps.setInt(1,book_id);// set the book values using set() of PreparedStatement.
			ps.setString(2,book_name);
			ps.setDouble(3,book_price);
			ps.setInt(4,book_qunt);
			int count = ps.executeUpdate();// storing the execute result into the return value integer.
			if(count>0)// checks the data added or not into the table
			{
				System.out.println("Record Added Successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			System.out.println("DO YOU WANT TO ADD MORE BOOK DATA Y/N");// asking to user for adding more data into the table.
			ch=sc.next().charAt(0);//accepting input from user choice for adding more data in the table
		}while(ch=='Y'||ch=='y');
	}
	
	
	public void edit_book(Connection conn) throws Exception // function to edit  book details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// Accept Input form user for perform update more data into the table again.
		do
		{
		
			System.out.println("What Do You Update In Your Book Record");// display the fields user want to update form the table
			System.out.println("------------------------------------------");
			System.out.println("1. BOOK NAME");
			System.out.println("2. BOOK PRICE");
			System.out.println("3. BOOK QUNTITY");
			int ch1 =sc.nextInt();// accept choice form user to which field user want to update
			
				switch(ch1)
				{
				case 1:
					// csase 1 for edit book Name
		
					System.out.println("Enter Book Id You want to Update Book Name: ");
					book_id=sc.nextInt();//Accept book id from user
					sc.nextLine();
					System.out.println("Enter The New Name Of The Book");
					book_name=sc.nextLine();// Accept new name of the book from user
					
					PreparedStatement ps =conn.prepareStatement("UPDATE book_data SET book_name = ? WHERE book_id = ?");// update sql query for update data into the table
					ps.setString(1, book_name);// set the new name for the book
					ps.setInt(2, book_id);// set the book id 
					
					int count=ps.executeUpdate();// storing the execute result into the return value integer
					if(count>0)// checks the data update or not into the table
					{
						System.out.println("Book Name Updated Successfully");
					}
					else
					{
						System.out.println("Book Name Not Updated");
					}
					break;
					
					
				case 2:
					
					// csase 2 for update book Price
					System.out.println("Enter Book Id You want to Update Book Price: ");
					book_id=sc.nextInt();//Accept book id from user
					sc.nextLine();
					System.out.println("Enter The New Price Of The Book");
					book_price=sc.nextDouble();// Accept new price of the book from user
					
					PreparedStatement ps1 =conn.prepareStatement("UPDATE book_data SET book_price = ? WHERE book_id = ?");// update sql query for update data into the table
					ps1.setDouble(1, book_price);// set the new price for the book
					ps1.setInt(2, book_id);// set the book id
					
					int count1=ps1.executeUpdate();// storing the execute result into the return value integer
					if(count1>0)// checks the data update or not into the table
					{
						System.out.println("Book Price Updated Successfully");
					}
					else
					{
						System.out.println("Book Price Not Updated");
					}
					break;
					
					
				case 3:
					
					// csase 3 for update book Quantity
					System.out.println("Enter Book Id You want to Update Quantity Of Books: ");
					book_id=sc.nextInt();//Accept book id from user
					sc.nextLine();
					System.out.println("Enter The New Quantity Of The Book");
					book_qunt=sc.nextInt();// Accept new quantity of the book from user
					
					PreparedStatement ps2 =conn.prepareStatement("UPDATE book_data SET book_qunt = ? WHERE book_id = ?");// update sql query for update data into the table
					ps2.setInt(1, book_qunt);// set the new quantity for the book
					ps2.setInt(2, book_id);// set the book id
					
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
				System.out.println("DO YOU WANT TO UPDATE MORE BOOK DATA Y/N");
				ch=sc.next().charAt(0);// Accept user input from user for more data update again.
		}while(ch=='Y'||ch=='y');
		
	}
	
	public void delete_book(Connection conn) throws Exception // function to delete book details using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variable to stroed value for perform delete operation again.
		do
		{
			
			System.out.println("Enter Book Id You Want To Delete Book Data");
			book_id=sc.nextInt();// accept book id from user for delete book details
			PreparedStatement ps = conn.prepareStatement("delete from book_data WHERE book_id=?");// create sql statement for delete book data from book_details table.
			ps.setInt(1,book_id);// set book id for delete book data
			int count=ps.executeUpdate();//storing the execute result into the return value integer 
			if(count>0)// checks the book data deleted or not into the table
			{
				System.out.println("Book Data Deleted Successfully");
			}
			else
			{
				System.out.println("Book Data Not Deleted");
			}
			System.out.println("DO YOU WANT TO DELETE MORE BOOK DATA Y/N");
			ch=sc.next().charAt(0);// Accept Input form user for perform delete operation again..
		}while(ch=='Y'||ch=='y');
			
	}
	
	
	public void get_book_byId(Connection conn) throws Exception // function to get book details by using book_id using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variable to stored values  for get more book data by using book_id form the table.
		do
		{
			String qur="select *from book_data where book_id=?";// sql query for retrive data from table
			System.out.println("Enter Book Id : ");
			book_id=sc.nextInt();//accepting book id from user to retrive book details
			PreparedStatement ps = conn.prepareStatement(qur);// create sql statement using preparedstatement.
			ps.setInt(1, book_id);// set the book id 
			ResultSet rs = ps.executeQuery();// execute the sql query and stored into result set for retrive and display book data. 
			while (rs.next()) // next method used to retrive data each row one by one
	        {
	            // Retrieve by column name
	            int bookId = rs.getInt("book_id");
	            String bookName = rs.getString("book_name");
	            double bookprice = rs.getDouble("book_price");
	            int bookquantity = rs.getInt("book_qunt");
	            

	            // Display values
	            System.out.println("Book ID: " + bookId);
	            System.out.println("Book Name: " + bookName);
	            System.out.println("Book Price: " + bookprice);
	            System.out.println("Book Quantity: " + bookquantity);
	            System.out.println("----------------------------");
	        }
			System.out.println("DO YOU WANT TO GET MORE BOOK DATA BY ENTERING BOOK ID Y/N");
			ch=sc.next().charAt(0);//Accept user input from user for get more book data  again by using book id.
		}while(ch=='Y'||ch=='y');
	}
	
	
	public void all_books_details(Connection conn) throws Exception // function to get all book details  using throws exception passing the Connection conn object for connect with the database.
	{
		PreparedStatement ps = conn.prepareStatement("Select *from book_data");// create sql statement for display all books data form table to java application.
		ResultSet rs = ps.executeQuery();// execute the sql query and stored into result set for retrive and display all books data.
		
		while (rs.next()) // next method used to retrive data each row one by one
        {
			// Retrieve by column name
            int bookId = rs.getInt("book_id");
            String bookName = rs.getString("book_name");
            double bookprice = rs.getDouble("book_price");
            int bookquantity = rs.getInt("book_qunt");
            

            // Display values
            System.out.println("Book ID: " + bookId);
            System.out.println("Book Name: " + bookName);
            System.out.println("Book Price: " + bookprice);
            System.out.println("Book Quantity: " + bookquantity);
            System.out.println("----------------------------");
        }
		
		
	}
	
	
	
	
	
	public void assign_author(Connection conn) throws Exception// function to assign author to a book using throws exception passing the Connection conn object for connect with the database.
	{
		char ch;// variable to stored values  for assign author to a  book data by using book_id and author_id form the table.
		do 
		{
			String qur="update book_details set author_id=? where book_id=? ";// create sql statement for update and set the author id to book id.
			System.out.println("Enter Author ID : ");
			author_id = sc.nextInt();//accept author id from user
			System.out.println("Enter Book ID : ");
			book_id = sc.nextInt();// accept book id from user
			PreparedStatement ps = conn.prepareStatement(qur);// execute sql statement
			ps.setInt(1, author_id);// set the author id
			ps.setInt(2, book_id);// set the book id
			int i = ps.executeUpdate();// storing the execute result into the return value integer
			if(i>0)//checks the author_id assign to a book or not into the table
			{
				System.out.println("AUHTOR ADDED TO A BOOK");
			}
			else
			{
				System.out.println("INVALID AUTHOR ID");
			}
			System.out.println("DO YOU WANT TO SET ANY AUTHOR ID Y/N");//Accept user input from user for assign_author id to a book again by using book id and author id.
			ch=sc.next().charAt(0);
		}while(ch=='Y'||ch=='y');
				
	}
	
	public static void main(String s[])
	{
		Book_data bd = new Book_data();
	}

}
