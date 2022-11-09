package com.jdbc;
import java.sql.*;
import java.util.Scanner;
class loancheck{
	long account=0;
	int check=0;
	int check(long account) throws SQLException{
		account=account;
		String url="jdbc:mysql://localhost:3306/bank";
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
			  Statement stt=con.createStatement();
			  ResultSet rs=stt.executeQuery("select * from users_details where account='"+account+"'");
			  while(rs.next()) {
				  String checks=rs.getString("loancheck");
		        	String s="yes";
		        	int a=s.compareTo(checks);
		        	System.out.println(a);
				  if(a==0) {
					  Statement sttt=con.createStatement();
					  ResultSet rssss=sttt.executeQuery("select * from loan where account='"+account+"'");
					  while(rssss.next()) {
						  System.out.println("YOUR REMAINING LOAN AMOUNT IS="+rssss.getInt("amount"));
						  System.out.println("YOUR EMI AMOUNT IS="+rssss.getInt("emi"));
						  System.out.println("YOUR REMAINING TENURE MONTH IS="+rssss.getInt("tenure"));
						  check=1;
					  }
					  
				  }
				  else {
					 check=0; 
				  }
			  }
			 
		return check;
	}
}
class update{
	long account=0;
	int xx=0;
	int yy=0;
	int tt=0;
	int amounts=0;
	int dpdating(long account,int x,int y,int t) throws SQLException {
		account=account;
		xx=x;
		yy=y;
		tt=t;
		amounts=yy-xx;
		tt=tt-1;
		
		
		
		String url="jdbc:mysql://localhost:3306/bank";
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
			  Statement stt=con.createStatement();
			int rs = stt.executeUpdate("update loan set amount='"+amounts+"',tenure='"+tt+"' WHERE account='"+account+"'");
		return 1;
	}
}


class emi{
	int check2=0;
	int time=0;
	int amount=0;
	long account=0;
	int emi=0;
   int payemi(String fname,String lname,long mobile,String pan, long adhar,String city,String email,long account,int balance) throws SQLException {
	   account=account;
		String url="jdbc:mysql://localhost:3306/bank";
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
			ResultSet rs = st.executeQuery("select * FROM users_details WHERE account = '"+account +"'");
	        while(rs.next()) {
	        	String check=rs.getString("loancheck");
	        	String s="yes";
	        	int a=s.compareTo(check);
	        	if(a==0) {
	        	  check2=1;
	        	}
	        	else {
	        		check2=0;
	        	}
	        		
	        }
	      
	   
	   
	   return check2;
   }
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class debit{
	long account=0;
	int amount=0;
	int total=0;
	int balance=0;
	int b=0;
	int debited(long account,int balance) throws SQLException,ArithmeticException {
	
		Scanner sc=new Scanner(System.in);
		account=account;
		System.out.println("ENTER THE AMOUNT YOU WANT TO WITHDRAWL");
		amount=sc.nextInt();
		
		try {
		if(amount>balance) {
			throw new ArithmeticException();
		}
		else {
			balance=balance-amount;
			String url="jdbc:mysql://localhost:3306/bank";
			String username ="root";
			String pass ="";

			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				 Connection con = null;
				try {
					con = DriverManager.getConnection(url,username,pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con = DriverManager.getConnection(url,username,pass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  Statement st=con.createStatement();	
			
				  int x=st.executeUpdate("update users_details set balance='"+balance+"' where account='"+account+"'");
			      if(x>0) {
			    	  System.out.println(amount+"rs DEBITED SUCCESSFULLY TO YOUR ACCOUNT");
			    	  balance=balance+1;
			      }
			
			
			
		}
	}
		
		catch(ArithmeticException e3) {
			System.out.println("AMOUNT IS NOT SUFFICIENT PLEASE ENTER LESS AMOUNT");
			balance=0;
		}
	
		
		
		
		
		 // return 1;
		return balance;
		
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class deposite{
	long account=0;
	int amount=0;
	int total=0;
	int balance=0;
	int credit(long account,int balance) throws SQLException {
		Scanner sc=new Scanner(System.in);
		account=account;
		System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSITE");
		amount=sc.nextInt();
		total=total+amount+balance;
		
		
		String url="jdbc:mysql://localhost:3306/bank";
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
			  int x=st.executeUpdate("update users_details set balance='"+total+"' where account='"+account+"'");
		      if(x>0) {
		    	  System.out.println(amount+"rs CREDITED SUCCESSFULLY TO YOUR ACCOUNT");
		      }
		  return 1;
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class loan{
	String fname="";
	String lname="";
	String email="";
	long mobile=0;
	
	int amount=0;
	int interest=0;
	int roi=8;
	int emi=0;
	int tenure=0;
	int time=0;
	long account=0;
	long adhar=0;
	int totalamount=0;
	long apply(String fname,String lname,long mobile,String pan, long adhar,String city,String email,long account,int balance) throws SQLException {
		account=account;
		fname=fname;
		lname=lname;
		email=email;
		account=account;
		adhar=adhar;
		Scanner sc = new Scanner(System.in);
		 System.out.println("ENTER THE LOAN AMOUNT");
	        amount = sc.nextInt();
	        System.out.println("ENTER THE TIME PERION IN MONTH");
	        time = sc.nextInt();
		interest=(amount*8)/100;
		totalamount=amount+interest;
		emi=amount/time;
		
		
		String url="jdbc:mysql://localhost:3306/bank";
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
			 
		
			int x=st.executeUpdate("insert into loan values('"+fname+"','"+lname+"','"+account+"','"+amount+"','"+emi+"','"+time+"','"+mobile+"','"+email+"')");
		
		  if(x>0) {
			  System.out.println("LOAN SUCCESS");
		  }
		
		
		
		return adhar;
		
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Eligiblity{
	int eligible() {
		int choice=0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your salary");
	int sal = sc.nextInt();
;		System.out.println("Enter your Civil");
	int civil = sc.nextInt();
	System.out.println("Enter your Month having account in bank");
	int month = sc.nextInt();
	
	System.out.println("Enter your month of working company");
	int month1=sc.nextInt();
	
	
	
	System.out.println("enter 1 for take loan "+ "\n"+"Enter 2 for exit");
	int x=sc.nextInt();
	
	
	switch(x) {
	case 1: {
		if(sal>=50000 &&month>=6 && civil>=700&&month1>=6) {
			System.out.println("You are eligible for the loan of upto 5lakhs ");
		}else if(sal>=70000 &&month>=6 && civil>=800 &&month1>=6) {
			System.out.println("You are eligible for the loan of upto 20Lakhs");
		}else if(sal>10000 &&month>=6&& civil>900 &&month1>=6) {
			System.out.println("your are eligible for upto 50Lakhs loan");
		}else {
			System.out.println("Not eligible");
		}
		System.out.println("If you want to take loan press 1"+ "\n"+ "FOr exit 2");
		 choice=sc.nextInt();
		if(choice==1) {
			choice= 1;
		}
		else {
			choice= 0;
		}
	}
	case 2: 
		{
			System.out.println("Thanks for banking with us");
			break;
		}
	}
	
	
	return choice;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 class profiledetails{
		String fname="";
	     String lname="";
		int mobile=0;
	    String pan="";
		long adhar=0;
		String city="";
		String email="";
	    long account=0;
	 int show(String fname,String lname,long mobile,String pan, long adhar,String city,String email,long account,int balance) {
		 System.out.println("                                                    WELCOME TO PROFILE PAGE");
			System.out.println("===============================================================================================================================================");
			System.out.println("NAME="+fname+" "+lname+"                                               MOBILE NUMBER="+mobile+"                        EMAIL ID="+email);
			System.out.println("CITY="+city+"                                                 ACCOUNT NUMBER="+account+"                      ADHAR NUMBER="+adhar);
			System.out.println("AVAILABLE BALANCE="+balance+"                                        AN NUMBER="+pan);
			System.out.println("===============================================================================================================================================");
			System.out.println("===============================================================================================================================================");
			return 1;
		    
	 }
 }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class LoanProject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int xx=0;
		int yy=0;
		int tt=0;
		int zz=0;
		int a=0;
		String fname="";
		String lname="";
		long mobile=0;
		String pan="";
		 long  adhar=0;
		String city="";
		int pincode=0;
		String profession="";
		String email="";
		int password=0;
		long account=0;
		int balance=0;
		String loancheck="no";
		Scanner sc=new Scanner(System.in);
		  String url="jdbc:mysql://localhost:3306/bank";
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
		  
		  System.out.println("                                                        WELCOME TO WELL INTERNATIONAL BANK");
		  System.out.println("=======================================================================================================================================================");
	      System.out.println("  "
	      		+ "                                                      HERE ARE THE SERVICES YOU GET");
	      do {
	      System.out.println("[CLICK 1 FOR SIGNUP][2 FOR LOGIN][3 FOR EXIT]");	
	      a=sc.nextInt();
	      switch(a) {
	      case 1:{
	    		System.out.println("PLEASE ENTER YOUR FIRST NAME");
				 fname=sc.next();
				
				System.out.println("PLEASE ENTER YOUR LAST NAME");
				 lname=sc.next();
				
				System.out.println("PLEASE ENTER YOUR MOBILE NUMBER");
				 mobile=sc.nextLong();
				
				System.out.println("PLEASE ENTER YOUR PAN CARD NUMBER");
				 pan=sc.next();
				
				System.out.println("PLEASE ENTER THE ADHAR NUMBER");
				 adhar=sc.nextLong();
				
				System.out.println("PLEASE ENTER YOUR CITY");
				 city=sc.next();
			
				System.out.println("PLEASE ENTER YOUR PINCODE");
					 pincode=sc.nextInt();
					 
				System.out.println("PLEASE ENTER YOUR PROFESSION");
				 profession=sc.next();
				
				System.out.println("PLEASE ENTER YOUR EMAIL");
				 email=sc.next();
				 
				System.out.println("PLEASE ENTER YOUR PASSWORD");
					 password=sc.nextInt();
					
				System.out.println("PLEASE ENTER YOUR ACCOUNT NUMBER");
					 account=sc.nextLong();
					 
					 int x=st.executeUpdate("insert into users_details values('"+fname+"','"+lname+"','"+mobile+"','"+pan+"','"+adhar+"','"+city+"','"+pincode+"','"+profession+"','"+email+"','"+password+"','"+account+"','"+balance+"','"+loancheck+"')");
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
											//System.out.println("=================================================================================================================================================================================");
											 profiledetails p1=new profiledetails();
											int z= p1.show(fname,lname,mobile,pan,adhar,city,lemail,account,balance);
											if(x>0) {
												choice=9;
											}
										 }
								  else {
									  System.out.println("PLEASE ENTER CORRECT EMAIL ID AND PASSWORD");
								  }
								
								break;
								
							}
							case 2:{
								break;
							}
							
							}
						}
						break;
				}
	  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
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
						//System.out.println("====================================================================");
						fname=rs.getString("fname");
						lname=rs.getString("lname");
						mobile=rs.getLong("mobile");
						pan=rs.getString("pan");
						adhar=rs.getLong("adhar");
						city=rs.getString("city");
						email=rs.getString("email");
						account=rs.getLong("account");
						balance=rs.getInt("balance");
						profiledetails p1=new profiledetails();
						int z= p1.show(fname,lname,mobile,pan,adhar,city,lemail,account,balance);
						if(z>0) {
							int choice=0;
							do {
							System.out.println("ENTER 1 FOW DEPOSITE  | 2 FOR WITHDRAWL  | 3 FOR APPLY A LOAN  |  4 FOR CHECK BALANCE  | 5 FOR PROFILE  |  6 FOR CHECK LOAN STATUS | 7 FOR LOAN PAYMENT");
							 choice=sc.nextInt();
							switch(choice) {
							case 1:{
								
								
								deposite d1=new deposite();
								int p=d1.credit(account,balance);
								if(p==1) {
									System.out.println("SUCCESS");
								}
								choice=9;
								break;
							}
							
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////							
							
							case 2:{
								debit d11=new debit();
								int p=d11.debited(account,balance);
								if(p>0) {
									System.out.println("SUCCESS");
									choice=7;
								}else{
									System.out.println("SOMETHING WENT WRONG PLEASE CHECK YOUR BALANCE");
								}
								choice=7;
								break;
								
							}
							
							
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
							
							case 3:{
								Eligiblity e1=new Eligiblity();
								int y=e1.eligible();
								if(y==1) {
									System.out.println("YOR ARE ELIGIBLE PRESS 1 FOR FURTHER PROCESS 2 FOE EXIT");
									int choice2=sc.nextInt();
									switch(choice2) {
									case 1:{
										loan l1=new loan();
										long z12=l1.apply(fname,lname,mobile,pan,adhar,city,lemail,account,balance);
										if(z12>1) {
											
											int x=st.executeUpdate("update users_details set loancheck='yes' where adhar='"+z12+"'");
											if (x>0) {
												System.out.println(z12);
												System.out.println("LOAN SUCCESS");
											}
											
										}
										break;
										
									}
									case 2:{
										break;
									}
									}
								}
								choice=10;
								break;
							}
							
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
							case 4:{
								
								ResultSet rs2 = st.executeQuery("select * FROM users_details WHERE email = '"+lemail +"'AND password='"+lpassword+"'");
								if(rs2.next()) {
								int balance2=rs2.getInt("balance");
								System.out.println("============================================================================================================");
								System.out.println("                            AVAILABLE BALANCE IN YOUR ACOUNT IS="+balance2);
								System.out.println("============================================================================================================");
								}
							
								choice=8;
								break;
							}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
							case 5:{
								
								ResultSet rs2 = st.executeQuery("select * FROM users_details WHERE email = '"+lemail +"'AND password='"+lpassword+"'");
								if(rs2.next()) {
								int balance2=rs2.getInt("balance");
								profiledetails p12=new profiledetails();
								int x= p12.show(fname,lname,mobile,pan,adhar,city,lemail,account,balance2);
								if(x==1) {
									choice=9;
								}
								}
								break;	
							}	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
							case 6:{
								loancheck l1=new loancheck();
								int f=l1.check(account);
								if(f==1) {
									
									choice=10;
								}
								else {
									System.out.println("YOU DONT HAVE ANY ACTIVE LOAN");
								}
								choice=10;
								break;
								
							}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							case 7:{
								int emi=0;
								int amount=0;
								int time=0;
								emi e1=new emi();
								int s=e1.payemi(fname,lname,mobile,pan,adhar,city,lemail,account,balance);
								if(s==1) {
								ResultSet rst = st.executeQuery("select * FROM loan WHERE account = '"+account +"'");
				        		while(rst.next()) {
				        		emi=rst.getInt("emi");
				        		amount=rst.getInt("amount");
				        		time=rst.getInt("tenure");
				        		
				        		
				        		
				        		System.out.println("YOUR TOTAL DUE AMOUNT IS="+amount+" YOUR EMI AMOUNT IS="+emi);
				        		amount=amount-emi;
			        			time=time-1;
				        		System.out.println("FOR PAY EMI PLEASE PRESS 1 FOR EXIT PLEASE PRESS 2");
				        		int b=sc.nextInt();
				        		switch(b) {
				        		
				        		
				        		
				        		case 1:{
				        			//int xx=0;
				        			//int yy=0;
				        			//int tt=0;
				        			//int zz=0;
				        			Statement stt=con.createStatement();
				        			ResultSet rstt = stt.executeQuery("select * FROM loan WHERE account = '"+account +"'");
				        			while(rstt.next()) {
				        			int emix=rstt.getInt("emi");
				        			int emiy=rstt.getInt("amount");
				        			int emit=rstt.getInt("tenure");
				        			xx=emix;
				        			yy=emiy;
				        			tt=emit;
				        			if(emiy>0) {
				        		 
				        			
				        				update u1=new update();
				        				int t= u1.dpdating(account,xx,yy,tt);
				        				if(t==1) {
				        					
				        					
				        					
				        					
				                     	System.out.println("LOAN PAYMENT SUCCESSFULL");
				        				}
				        				else {
				        					System.out.println("SOMETHINT WENT WRONG PLEASE TRY AGAIN");
				        				}
				        				
				        			}
				        			else {
				        				System.out.println("LOAN CLEAR");
				        			}
				        			}
				        			break;
				        		}
				        		
				        		
				        		
				        		
				        		
				        		
				        		case 2:{
				        			break;
				        		}
				        	
				        		}
				        		
				        	}
							}
								else {
									System.out.println("YOU DONT HAVE ANT ACTIVE LOAN");
								}
								choice=10;
								break;
							}
							
							}
						}while(choice>6);
						}else {
							System.out.println("WE ARE COORENTLY UNAVAILABLE PLEASE TRY AFTER SOME TIME");
						}
						
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
