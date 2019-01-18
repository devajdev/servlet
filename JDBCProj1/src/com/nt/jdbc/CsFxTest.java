package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsFxTest {
  private static final String CALL_FX="{?= call fx_get_Emps_by_no(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter employee number::");
				no=sc.nextInt();
			}//if
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create CalalbleStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_FX);
			//register return,OUT params with JDBC types
			if(cs!=null){
				cs.registerOutParameter(1,Types.VARCHAR); //return param
				cs.registerOutParameter(3,Types.VARCHAR);  //out param
				cs.registerOutParameter(4,Types.INTEGER); //out param
			}
			//set values to IN param
			if(cs!=null)
				cs.setInt(2,no);
			//call PL/SQL function
			if(cs!=null)
				cs.execute();
			//gather results from return ,OUT params
			if(cs!=null){
				System.out.println("Name::"+cs.getString(3));
				System.out.println("Salary ::"+cs.getInt(4));
				System.out.println("Desg ::"+cs.getString(1));
			}
		}//try
		catch(ClassNotFoundException  | SQLException  e ){
			System.out.println("Employee Not found");
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close objects
			try{
				if(cs!=null)
					cs.close();
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
