package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcelTest1 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner  sc=null;
		int no=0;
		String name=null;
		String addrs=null;
		int result=0;
		
	try{
		//read inputs
		sc=new Scanner(System.in);
		if(sc!=null){
			System.out.println("Enter Student number::");
			 no=sc.nextInt();
			System.out.println("Enter Student name::");
			name=sc.next();
			System.out.println("Enter Student Address::");
			addrs=sc.next();
		}//if
		
		
		//register Driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:odbc:xlsxdsn");
		//create Statement object
		if(con!=null)
			ps=con.prepareStatement("INSERT INTO [Sheet1$]  VALUES(?,?,?)");
		//set values query params
		if(ps!=null){
			ps.setInt(1,no);
			ps.setString(2,name);
			ps.setString(3,addrs);
		}
		//execute Query
		if(ps!=null)
			result=ps.executeUpdate();
		  if(result==0)
			  System.out.println("Record not inserted");
		  else
			  System.out.println("Record inserted");
	}//try
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf){
		cnf.printStackTrace();
	}
	catch(Exception e){
		 e.printStackTrace();
	}
	finally{
		//close jdbc objs
		
		try{
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(con!=null)
				con.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		try{
			if(sc!=null)
				sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//finally
	}//main
}//class
