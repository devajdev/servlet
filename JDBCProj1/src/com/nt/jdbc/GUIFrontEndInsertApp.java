package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIFrontEndInsertApp extends JFrame implements ActionListener,WindowListener  {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	 private JLabel lno,lname,laddrs,lres;
	 private JTextField  tno,tname,taddrs;
	 private JButton btn1;
	 Connection con;
	 PreparedStatement ps;
	 
	 public GUIFrontEndInsertApp() {
		 System.out.println("GUIFrontEndInsertApp:0-param constructor");
		 //frame settings
		setTitle("GUIFrontEndApp");
		setBackground(Color.GRAY);
		setLayout(new FlowLayout());
		setSize(300, 300);
		//add comps
		lno=new JLabel("student number::");
		add(lno);
		tno=new JTextField(10);
		add(tno);
		
		lname=new JLabel("student name::");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		laddrs=new JLabel("Student Address::");
		add(laddrs);
		taddrs=new JTextField(10);
		add(taddrs);
		
		btn1=new JButton("Register");
		btn1.addActionListener(this);
		add(btn1);
		
		lres=new JLabel("");
		lres.setForeground(Color.RED);
		add(lres);
		//set Visibility on
		setVisible(true);
		//Terminate App when close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		
		initialize();
		
	}//constructor
	 
	 private void initialize(){
		 System.out.println("initialize()");
		 try{
			 //register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create PreparedStatement object
			 ps=con.prepareStatement(STUDENT_INSERT_QUERY);
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
	 }//intialize()
	

	public static void main(String[] args) {
		System.out.println("main(-) method....");
		new GUIFrontEndInsertApp();
	}//main


	@Override
	public void actionPerformed(ActionEvent ae) {
		int no=0;
		String name=null,addrs=null;
		int count=0;
		System.out.println("actionPerformed(-)");
		try{
			//read values from text boxes
			no=Integer.parseInt(tno.getText());
			name=tname.getText();
			addrs=taddrs.getText();
			//set values to query params
			ps.setInt(1,no);
			ps.setString(2, name);
			ps.setString(3,addrs);
			//execute the query
			count=ps.executeUpdate();
			if(count!=0)
				lres.setText("Record Inserted");
			else
				lres.setText("Record  not Inserted");
		}//try
		catch(SQLException se){
			se.printStackTrace();
			lres.setText("Record  not Inserted -->"+se.getMessage());
		}
		catch(Exception e){
			e.printStackTrace();
			lres.setText("Record  not Inserted-->"+e.getMessage());
		}
	}//method

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
	System.out.println("windowClosing(-)");
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
		
	}//windowClosing(-)

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}//class
