package com.nt.jdbc;

import java.sql.CallableStatement;
/*create or replace function 
fx_view_student_delete_by_no(no in number, count out number)return sys_refcursor
as 
 details  sys_refcursor;
begin
  open details for
       SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNO=no;
 DELETE FROM STUDENT WHERE  SNO=no;
count:=SQL%ROWCOUNT;
return details;
end;
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CsFxTest2 {
   private static final String  CALL_FX="{?=call fx_view_student_delete_by_no(?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		int count=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter student number::");
				no=sc.nextInt();
			}
			//register JDBC driver
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_FX);
			//register OUT params,return params with JDBC types
			if(cs!=null){
				cs.registerOutParameter(1, OracleTypes.CURSOR); //return param
				cs.registerOutParameter(3, Types.INTEGER); //OUT param
			}
			//set values to IN params
			if(cs!=null){
				cs.setInt(2,no);
			}
			//execute PL/SQL Function
			if(cs!=null)
				cs.execute();
			//gather return param value
		     if(cs!=null){
		    	 rs=(ResultSet)cs.getObject(1);
		    	 if(rs.next()){
		    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		    		 System.out.println("Record Viewed...");
		    	 }
		    	 else{
		    		 System.out.println("record not found");
		    	 }
		     }
		     
		     //gather OUT param value
		     if(cs!=null)
		    	 count=cs.getInt(3);
		     if(count==0)
		    	 System.out.println("Record not deleted");
		     else
		    	 System.out.println("Record  deleted");
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		/*catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}*/
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
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
}//class
