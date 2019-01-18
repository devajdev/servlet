package com.nt.jdbc;
/*SQL> desc shopping_product;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
PID                                                NUMBER(5)
PNAME                                              VARCHAR2(20)
QTY                                                NUMBER(6)
PRICE                                              NUMBER(8,2)

SQL> desc bank_account1;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ACCNO                                              NUMBER(6)
HOLDERNAME                                         VARCHAR2(10)
BALANCE                                            NUMBER(10,2)
*/import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class SavePoint_OnlineShoppingTest {
    private static final String   PRODUCT_SHOPPING="UPDATE SHOPPING_PRODUCT  SET QTY=QTY-1 WHERE PID=?";
    private static final String   PRODUCT_PAYMENT="UPDATE BANK_ACCOUNT1  SET BALANCE=BALANCE-(SELECT PRICE FROM SHOPPING_PRODUCT WHERE PID=?) WHERE ACCNO=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0, acno=0;
		Connection con=null;
		PreparedStatement ps1=null,ps2=null; 
		int result1=0,result2=0;
		Savepoint sp=null;
		boolean isPaymentFailed=false;
	 try{
		//read inputs
		 sc=new Scanner(System.in);
		 if(sc!=null){
		   System.out.println("Enter Product id ");
		    pid=sc.nextInt();
		    System.out.println("Enter Account number:");
		    acno=sc.nextInt();
		 }
		 //establish the connection
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
		 //begin Transaction
		   if(con!=null)
			   con.setAutoCommit(false);
		   //create PreparedStatement objs
		   if(con!=null){
			   ps1=con.prepareStatement(PRODUCT_SHOPPING);
			   ps1.setInt(1,pid);
			   result1=ps1.executeUpdate();
			   
			   if(result1!=0){
				   sp=con.setSavepoint("p1");
				   ps2=con.prepareStatement(PRODUCT_PAYMENT);
				   ps2.setInt(1,pid);
				   ps2.setInt(2,acno);
				   result2=ps2.executeUpdate();
			   }
			   if(result1==0){
				   con.rollback();
				   System.out.println("Product not found try again..");
				   return;
			   }
			   if(result2==0){
				   con.rollback(sp);
				   isPaymentFailed=true;
			   }
			   con.commit();
			   if(!isPaymentFailed)
			     System.out.println("Product found and payment done..");
			   else
				   System.out.println("Product found and payment failed , SO COD is enabled..");
		   }//if
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
			 if(ps1!=null)
				 ps1.close();
		 }
		 catch(SQLException se){
			 se.printStackTrace();
		 }
		 try{
			 if(ps2!=null)
				 ps2.close();
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
}///class
