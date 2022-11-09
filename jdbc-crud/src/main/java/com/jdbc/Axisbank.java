package com.jdbc;
import java.sql.*;
public class Axisbank {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	   int age=100;
	   String name="chutu lal";

		 String url="jdbc:mysql://localhost:3306/axis";
		  String username ="root";
		  String pass = "";
		  
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Connection con = DriverManager.getConnection(url,username,pass);
		  Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("SELECT * from user");
		 while(rs.next()) {
			 System.out.println(rs.getString("name")+" "+rs.getLong("age")+" "+rs.getString("soj")+" "+rs.getString("city")+" "+rs.getString("address"));
		 }
		 // int x=st.executeUpdate("insert into user values('chutu',500,'30/18/12','bihar','patna')");
		 // if(x>0) {
			//  System.out.println("success");
		  //}
		// int rs=st.executeUpdate("DELETE from user where name='sumit'");
		 //System.out.println("success");
		 // ResultSet rs = st.executeQuery("SELECT * from user");
		  //while(rs.next()) {
			//  System.out.println(rs.getLong("age") + "" + rs.getString("name")+":"+ rs.getString("address")+":"+rs.getString("city")+rs.getString("soj"));
		 // }
		//  Statement st = con.createStatement();
	
		//  int x = st.executeUpdate("UPDATE user set name = '" + name  + 
               //   "' WHERE age = '" +age+ "'");
		 // if(x>0) {
			  System.out.println("success");
		 // }
      
		  
		  //while(rs.next())
		 // {
		   
		//  System.out.println(rs.getLong("age") + "" + rs.getString("name")+":"+ rs.getString("city")+":"+rs.getString("address"));
		//  }

	}

}
