package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*create or replace procedure p_first_pro1(x in number,y out number)as
begin
  y:=x*x;
end;
/
*/

public class CsTest1 {
  private static final String  CALL_PROCEDURE="{ Call P_first_pro1(?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		int result=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter a nynber::");
				no=sc.nextInt();
			}
			//register JDBC driver
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_PROCEDURE);
			//register OUT params with JDBC types
			if(cs!=null)
				cs.registerOutParameter(2, Types.INTEGER);
			//set values to IN params
			if(cs!=null)
				cs.setInt(1,no);
			//execute PL/SQL Procedure
			if(cs!=null)
				cs.execute();
			//gather  resultm from PL/SQL Procedure 
			if(cs!=null)
				result=cs.getInt(2);
			
			System.out.println("Result(SQUARE VALUE):::"+result);
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
	/*	catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}*/
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
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
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//calss
