package com.jdbc;
import java.sql.*;
import java.util.*;

class profile{
	
	
	
	void kala() throws SQLException {
	
	String url="jdbc:mysql://localhost:3306/zomato";
	String username ="root";
	String pass ="";

	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		  Connection con =  DriverManager.getConnection(url,username,pass);
		try {
			con = DriverManager.getConnection(url,username,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Statement st=con.createStatement();
}
	
	
	
	
	int mobile=0;
	int password=0;
	String fname="";
	String lname="";
	String email="";
	String city="";
	String state="";
	String landmark="";
	void show(String fname,String lname,int mobile,String email, String city,String state,String landmark) {
		fname=fname;
		lname=lname;
		mobile=mobile;
		email=email;
		city=city;
		state=state;
		landmark=landmark;
		System.out.println("                                             WELCOME TO PROFILE PAGE");
		System.out.println("===============================================================================================================================================");
		System.out.println("NAME="+fname+" "+lname+"                           MOBILE NUMBER="+mobile+"                  EMAIL ID="+email);
		System.out.println("CITY="+city+"                                 STATE="+state+"                      LANDMARK="+landmark);
		System.out.println("===============================================================================================================================================");
	}
}
class Signup{
	String name,email,password,city,state,landmark;
     int mobile;
	void signup(String name,int mobile,String email,String password,String city,String state,String landmark) {
		name=name;
		mobile=mobile;
		email=email;
		password=password;
		city=city;
		state=state;
		landmark=landmark;
}
}
public class Zomato {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		int a=0;
		int mobile=0;
		int password=0;
		String fname="";
		String lname="";
		String email="";
		String city="";
		String state="";
		String landmark="";
		Scanner sc=new Scanner(System.in);
		  String url="jdbc:mysql://localhost:3306/zomato";
		  String username ="root";
		  String pass = "";

		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Connection con =  DriverManager.getConnection(url,username,pass);
			try {
				con = DriverManager.getConnection(url,username,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Statement st=con.createStatement();
			  do {
			  System.out.println("ENTER 1 FOR SIGNUP 2 FOR LOGIN");
				 a=sc.nextInt();
				switch(a) {
				case 1:{
					System.out.println("PLEASE ENTER YOUR FIRST NAME");
					 fname=sc.next();
					
					System.out.println("PLEASE ENTER YOUR LAST NAME");
					 lname=sc.next();
					
					System.out.println("PLEASE ENTER YOUR MOBILE NUMBER");
					 mobile=sc.nextInt();
					
					System.out.println("PLEASE ENTER YOUR EMAIL ID");
					 email=sc.next();
					
					System.out.println("PLEASE ENTER YOUR PASSWORD");
					 password=sc.nextInt();
					
					System.out.println("PLEASE ENTER YOUR CITY");
					 city=sc.next();
				
					System.out.println("PLEASE ENTER YOUR STATE");
					 state=sc.next();
					
					System.out.println("PLEASE ENTER YOUR LANDMARK");
					 landmark=sc.next();
					
					
					
					int x=st.executeUpdate("insert into users_details values('"+fname+"','"+lname+"','"+mobile+"','"+email+"','"+password+"','"+city+"','"+state+"','"+landmark+"')");
					if(x>0) {
						System.out.println("SIGNUP SUCCESS NOW YOU CAN LOGIN TO THE APPLICATION");
						System.out.println("====================================================================");
						System.out.println("DO YOU WANT TO LOGIN PRESS 1 IF YES OR PRESS 2 FOR EXIT");
						int choice=sc.nextInt();
						switch(choice) {
						case 1:{
							
							
							System.out.println("PLEASE ENTER YOUR EMAIL ID");
							 String lemail=sc.next();
							
							System.out.println("PLEASE ENTER YOUR PASSWORD");
							 int lpassword=sc.nextInt();
							// String query=("select * FROM users_details WHERE email = "+lemail +"AND password="+lpassword);
							  ResultSet rs = st.executeQuery("select * FROM users_details WHERE email = '"+lemail +"'AND password='"+lpassword+"'");
							  if(rs.next()) {
										System.out.println("LOGIN SUCCESS");
										System.out.println("WE REDIRECT YOU TO YOUR PROFILE PAGE");
										System.out.println("");
										//System.out.println("=================================================================================================================================================================================");
										 profile p1=new profile();
										 p1.show(fname,lname,mobile,lemail,city,state,landmark);
									 }
							  else {
								  System.out.println("PLEASE ENTER CORRECT EMAIL ID AND PASSWORD");
							  }
							
							break;
							
						}
						case 2:{
							break;
						}
						default:{
							System.out.println("WRONG CHOICE PLEASE SELECT 1 FOR LOGIN AND 2 FOR EXIT");
						}
						}
					}
					break;
				}
				case 2:{
					System.out.println("PLEASE ENTER YOUR EMAIL ID");
					 String lemail=sc.next();
					
					System.out.println("PLEASE ENTER YOUR PASSWORD");
					 int lpassword=sc.nextInt();
					// String query=("select * FROM users_details WHERE email = "+lemail +"AND password="+lpassword);
					  ResultSet rs = st.executeQuery("select * FROM users_details WHERE email = '"+lemail +"'AND password='"+lpassword+"'");
					  if(rs.next()) {
								System.out.println("LOGIN SUCCESS");
								System.out.println("WE REDIRECT YOU TO YOUR PROFILE PAGE");
								System.out.println("");
								//System.out.println("====================================================================");
								fname=rs.getString("fname");
								lname=rs.getString("lname");
								mobile=rs.getInt("mobile");
								city=rs.getString("city");
								city=rs.getString("city");
								state=rs.getString("state");
								landmark=rs.getString("landmarkusers");
								 profile p1=new profile();
								 p1.show(fname,lname,mobile,lemail,city,state,landmark);
							 }
					  else {
						  System.out.println("PLEASE ENTER CORRECT EMAIL ID AND PASSWORD");
					  }
					  
					  break;
				         }
				default:{
					System.out.println("WRONG CHOICE PLEASE SELECT 1 FOR SIGNUP AND 2 FOR LOGIN");
					break;
				}
				
				}
				
	}while(a>2);
				
	}

}
