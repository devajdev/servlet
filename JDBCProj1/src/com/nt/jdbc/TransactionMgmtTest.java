package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*SQL> select * from jdbc_account;

ACNO HOLDER                  BALANCE
---------- -------------------- ----------
 101 raja                       9000
 102 rajesh                     8000
*/
public class TransactionMgmtTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int srcAcno=0,destAcno=0;
		int amount=0;
		Connection con=null;
		Statement st=null;
		int result[]=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter source account number:");
				srcAcno=sc.nextInt();
				System.out.println("Enter Dest account number::");
				destAcno=sc.nextInt();
				System.out.println("Enter Amount to transfer::");
				 amount=sc.nextInt();
			}
			//register driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//Begin Transaction 
			con.setAutoCommit(false);
			//create STatement object
			if(con!=null)
				st=con.createStatement();
			//add withdraw,deposite queries to the batch
			if(st!=null){
				 //withdraw
				st.addBatch("update jdbc_account set balance=balance-"+amount+" where acno="+srcAcno);
				 //deposite
				st.addBatch("update jdbc_account set balance=balance+"+amount+" where acno="+destAcno);
			}
			//execut the batch
			if(st!=null){
				result=st.executeBatch();
			}
			
			//perform Transaction mgmt..
			for(int i=0;i<result.length;++i){
				if(result[i]==0){
					flag=true;
					break;
				}
			}
			if(flag==true){
				con.rollback();
				System.out.println("Transaction rolledback-->Money not transffered");
			}
			else{
				con.commit();
				System.out.println("Transaction Committed-->Money  transffered");
			}
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(st!=null)
					st.close();
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
