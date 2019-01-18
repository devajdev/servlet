package com.nt.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*SQL> select * from All_student;

SNO SNAME                        M1         M2         M3
---------- -------------------- ---------- ---------- ----------
101 raja                              90         89         89
102 rani                              40         49         89
103 jani                              34         34         78
104 ramesh                       55         45         56
*/

/*CREATE OR REPLACE PROCEDURE P_FIND_PASS_FAIL(m1 in number,
                                                                                                      m2 in number,
                                                                                                      m3 in number,
                                                                                                      result out varchar)as
begin
   if(m1<35 or m2<35 or m3<35) then
    result:='FAIL';
else
     result:='PASS';
  end if;
end;
/
*/


public class GUIMiniProject_AllStmts1 extends  JFrame implements ActionListener{
	private static final String  GET_SNOS_OF_STUDENTS="SELECT SNO FROM ALL_STUDENT ";
	private static final String GET_STUDS_BY_SNO="SELECT SNAME,M1,M2,M3 FROM ALL_STUDENT WHERE SNO=?";
	private static final String CALL_PROCEDURE= "{ call P_FIND_PASS_FAIL(?,?,?,?) }";
	
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	private JTextField tname,tm1,tm2,tm3,tres;
	private JComboBox<Integer> cno;
	private JButton  bDetails, bResult;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
	ResultSet rs1=null,rs2=null;
	
	//constructor
	public GUIMiniProject_AllStmts1() {
		System.out.println("GUIMiniProject_AllStmts::0-param constructor");
		//Frame Settings
		setTitle("GUI All Stmts App");
		setSize(300,300);
		setLayout(new FlowLayout());
		//add comps
		lno=new JLabel("student Id");
		add(lno);
		cno=new JComboBox<Integer>();
		add(cno);
		
	    bDetails=new JButton("Details");
	    bDetails.addActionListener(this);
	    add(bDetails);
	    
	    
	    lname=new JLabel("name::");
	    add(lname);
	    tname=new JTextField(10);
	    add(tname);
	    
	    lm1=new JLabel("marks1::");
	    add(lm1);
	    tm1=new JTextField(10);
	    add(tm1);
	    
	    lm2=new JLabel("marks2::");
	    add(lm2);
	    tm2=new JTextField(10);
	    add(tm2);
	    
	    lm3=new JLabel("marks3::");
	    add(lm3);
	    tm3=new JTextField(10);
	    add(tm3);
	    
	    bResult=new JButton("Result");
	    bResult.addActionListener(this);
	    add(bResult);
	    
	    lres=new JLabel("Result is");
	    add(lres);
	    tres=new JTextField(10);
	    add(tres);
	    		
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       addWindowListener(new MyWindowAdapter());
	       
	       setVisible(true);
	       //disable editng settings on Text boxes
	       tname.setEditable(false);
	       tm1.setEditable(false);
	       tm2.setEditable(false);
	       tm3.setEditable(false);
	       tres.setEditable(false);
	       initialize();
	}//constructor
	
	private void initialize(){
		try{
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create SimpleStatement object
			st=con.createStatement();
			//create JDBC ResultSEt object
			rs1=st.executeQuery(GET_SNOS_OF_STUDENTS);
			//copy snos of rs1(ResultSet obj) to Combox Box component
			while(rs1.next()){
				cno.addItem(rs1.getInt(1));
			}//while
			//create PrpearedStatement object
			ps=con.prepareStatement(GET_STUDS_BY_SNO);
			//create CallableSTatement object
			cs=con.prepareCall(CALL_PROCEDURE);
			//register OUT param with JDBC tupes
			cs.registerOutParameter(4, Types.VARCHAR);
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("main(-)");
		new GUIMiniProject_AllStmts();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int m1=0,m2=0,m3=0;
		String result=null;
		System.out.println("actionPerfomed(-)");
		if(ae.getSource()==bDetails){
			System.out.println("Details Button");
			try{
				//set values to query param
				ps.setInt(1,(int)cno.getSelectedItem());
				//execute the SQL Query
				rs2=ps.executeQuery();
				//read and place the output textBoxes
				if(rs2.next()){
					tname.setText(rs2.getString(1));
					tm1.setText(rs2.getString(2));
					tm2.setText(rs2.getString(3));
					tm3.setText(rs2.getString(4));
				}//if
				
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				  e.printStackTrace();
			}
		}//if
		else {   //for result Button
			System.out.println("result button");
			try{
				//read marks from text boxes
				m1=Integer.parseInt(tm1.getText());
				m2=Integer.parseInt(tm2.getText());
				m3=Integer.parseInt(tm3.getText());
				//set values to IN params
				cs.setInt(1,m1);
				cs.setInt(2,m2);
				cs.setInt(3,m3);
				//execute Query
				cs.execute();
				//gather results from OUT param
				result=cs.getString(4);
				//set result to Text box
				tres.setText(result);
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//else
	}//actionPeformed(-)
	
	private class  MyWindowAdapter extends  WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("WindowClosing(-)");
		  //close jdbc objs
			try{
				if(rs2!=null)
					rs2.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(rs1!=null)
					rs1.close();
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
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
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
			
		}
	}
	
	

}//class
