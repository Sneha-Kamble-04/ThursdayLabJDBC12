package com.bookdata;
import java.util.*;// Scanner class Library
import java.sql.DriverManager;//Library For Driver Register & Load 
import java.sql.Connection;// Library For Create Coonection with DataBase
public class Onlinebook_Management 
{
	String url="jdbc:mysql://localhost:3306/onlinebookmanagement";// Datatbase Mysql Server Path
	String user="root";// Mysql Server Username
	String pwd="root";//Mysql Server Paasword
	int choice;//Accept choice from user to perfrom Operation on book and author
	char ch;// Sub_Choice for Perfrom Operation one or more Times.
	Scanner sc=new Scanner(System.in);//Scanner class for take input from user.
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Sneha's Book Store");
		Onlinebook_Management om = new Onlinebook_Management();// create object of Book_Mnagenet.
		om.my_operations();// call function to perform operation using class object

	}
	public void my_operations()
	{
		Book_data bd = new Book_data();// Create Book class oject to perform book Operation
		Author_data ad = new Author_data();//Create Author class bject to perform Author Operation 
		
			try
			{
					Class.forName("com.mysql.cj.jdbc.Driver");// Driver Path for register and load the drivers
					Connection conn = DriverManager.getConnection(url,user,pwd);// crete coonection object to stored and connect java application with mysql server.
					
					// List of Operations.
					do
					{
							System.out.println("------------------------------------------");
							System.out.println("1:ADD BOOK");
							System.out.println("2:EDIT BOOK");
							System.out.println("3:DELETE BOOK");
							System.out.println("4:GET BOOK DETAILS BY ID");
							System.out.println("5:VIEW ALL BOOKS DETAILS");
							System.out.println("6:ADD AUTHOR");
							System.out.println("7:EDIT AUTHOR DETAILS");
							System.out.println("8:DELETE AUTHOR");
							System.out.println("9:GET AUTHOR DETAILS BY ID");
							System.out.println("10:VIEW ALL AUTHOR DETAILS");
							System.out.println("11:ASSIGN AUTHOR TO A BOOK");
							
							System.out.println("------------------------------------------");
							System.out.print("Select Your Book Operation You Want to Perform : ");
							
							// Accept choice using scanner class from user to perform operations.
							choice=sc.nextInt();
							switch(choice)
							{
							case 1:
								bd.add_book(conn);// call add book function from Book_Operation for added book data. 
								break;
								
							case 2:
								bd.edit_book(conn);// call edit book function from Book_Operation for edit book data.
								break;
								
							case 3:
								bd.delete_book(conn);// call delete book function from Book_Operation for delete book data.
								break;
							case 4:
								
								bd.get_book_byId(conn);// call get book data function from Book_Operation for retrive book data by using by id.
								break;
								
							case 5:
								bd.all_books_details(conn);// call all book details function from Book_Operation for Display all book data.
								break;
								
							case 6:
								ad.add_Author(conn);// call add author function from Author_Operation for added Author data.
								break;
								
							case 7:
								ad.edit_Author(conn);// call edit author function from Author_Operation for edit Author data.		
								break;
								
							case 8:
								ad.author_delete(conn);// call delete author function from Author_Operation for delete Author data.
								break;
								
							case 9:
								ad.get_author_byId(conn);// call get author data function from Author_Operation for retrive author data by using author id.
								break;
								
							case 10:
								ad.all_author_details(conn);// call all author details function from Author_Operation for Display all Author data.
								break;
								
							case 11:
								bd.assign_author(conn);// call assign author function to assign author_id to book_details table
								break;
								
							default:
								System.out.println("Enter Valid Choice Operation");// default case for invalid choice 
							}
						System.out.println("DO YOU WANT TO PERFORM ANY BOOK OPERATION OR AUTHOR OPERATION Y/N");// asking to user for perform more book operation & author operation again.
						ch=sc.next().charAt(0);// accept choice from user
					}while(ch=='Y'||ch=='y');
			}
					
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			System.out.println("Thank You For Store Books Visist Again !");

	}

}
