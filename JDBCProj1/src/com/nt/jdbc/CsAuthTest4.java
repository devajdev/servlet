/*create or replace procedure  p_authentication(user in varchar2,pass in varchar,result out varchar)
as 
  cnt number(4);
begin
   SELECT COUNT(*)  INTO cnt FROM USERLIST WHERE UNAME=user and PWD=pass;
 if(cnt<>0) then
     result:='VALID CREDENTIALS';
 else
    result:='INVALID CREDENTIALS';
 end if;
end;
*/


package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsAuthTest4 {
   private static final String CALL_PROCEDURE="{ call p_Authentication(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		String uname=null;
		String pass=null;
		Connection con=null;
		CallableStatement cs=null;
		String result=null;
	  try{
		  //read inputs
		  sc=new Scanner(System.in);
		  if(sc!=null){
			  System.out.println("Enter username:::");
			  uname=sc.nextLine(); //gives raja
			  System.out.println("Enter password::");
			  pass=sc.nextLine(); //gives rani
		  }
		  //register JDBC driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create CallableStatement object
		  if(con!=null)
			  cs=con.prepareCall(CALL_PROCEDURE);
		  //register OUT params with JDBC types
		  if(cs!=null)
			  cs.registerOutParameter(3,Types.VARCHAR);
		  //set values to IN params
		  if(cs!=null){
			  cs.setString(1,uname);
			  cs.setString(2,pass);
		  }
		  //call PL/SQL procedure
		  if(cs!=null)
			  cs.execute();
		  //gather results
		  if(cs!=null)
			  result=cs.getString(3);
		  
		  System.out.println("Result is :::"+result);
	  }//try
	  catch(SQLException | ClassNotFoundException e){
		  e.printStackTrace();
	  }
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
		  catch(Exception e){
			  e.printStackTrace();
		  }
	  }//finally
	}//main
}//classs
