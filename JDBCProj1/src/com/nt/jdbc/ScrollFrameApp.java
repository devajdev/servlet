package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrameApp extends JFrame implements ActionListener {
	private static final String  GET_ALL_STUDENTS="SELECT SNO,SNAME,SADD FROM STUDENT";
	private JLabel lno,lname,laddrs;
	private  JTextField tno,tname,taddrs;
	private  JButton bFirst,bNext,bLast,bPrevious;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs; 
	
	public ScrollFrameApp() {
		System.out.println("Constructor");
		setTitle("Scrollframe APp");
		setSize(300, 400);
		setLayout(new FlowLayout());
		setBackground(Color.GRAY);
		//add comps
		lno=new JLabel("student Id");
		add(lno);
		tno=new JTextField(10);
		add(tno);
		
		lname=new JLabel("student Name");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		laddrs=new JLabel("student Address");
		add(laddrs);
		taddrs=new JTextField(10);
		add(taddrs);
		
		bFirst=new JButton("First");
		bFirst.addActionListener(this);
		add(bFirst);
		bNext=new JButton("next");
		bNext.addActionListener(this);
		add(bNext);
		
		bLast=new JButton("Last");
		bLast.addActionListener(this);
		add(bLast);
		bPrevious=new JButton("previous");
		bPrevious.addActionListener(this);
		add(bPrevious);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initialize();
	}//constructor
	
	private  void initialize(){
		System.out.println("initialize()");
		try{
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStaement obj
			ps=con.prepareStatement(GET_ALL_STUDENTS,
					                                            ResultSet.TYPE_SCROLL_SENSITIVE,
					                                              ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//initialize()
	
	
	public static void main(String[] args) {
		System.out.println("main(-)");
		new ScrollFrameApp();
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean flag=false;
		try{
		System.out.println("actionPerformed(-)");
		if(ae.getSource()	==bFirst){
			System.out.println("first Button is clicked");
		
				rs.first();
				flag=true;
		
		}
		else if(ae.getSource()==bLast){
			System.out.println("Last Button is clicked");
			rs.last();
			flag=true;
		}
		else if(ae.getSource()==bNext){
			System.out.println("NExt Button is clicked");
			if(!rs.isLast()){
				rs.next();
				flag=true;
			}
		}
		else{
			System.out.println("previous button is clicked");
			if(!rs.isFirst()){
				rs.previous();
				flag=true;
			}
		}
		
		if(flag==true){
			//set values to text boxes
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			taddrs.setText(rs.getString(3));
		}
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		
	}//actionPerformed(-)
}//calss
