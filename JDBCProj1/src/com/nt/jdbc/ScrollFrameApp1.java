package com.nt.jdbc;

import java.awt.EventQueue;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScrollFrameApp1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection con;
	private PreparedStatement ps;
	private  ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrollFrameApp1 window = new ScrollFrameApp1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrollFrameApp1() {
		initialize();
		makeConnection();
	}
	
	
	private  void makeConnection(){
		try{
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement object
			ps=con.prepareStatement("SELECT SNO,SNAME,SADD FROM STUDENT",
					                                            ResultSet.TYPE_SCROLL_SENSITIVE,
					                                            ResultSet.CONCUR_UPDATABLE);
			//ceate Scrollable ResultSet obj
			rs=ps.executeQuery();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing(-)");
				//close jdbc objs
				try{
					if(rs!=null)
						rs.close();
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
					if(con!=null)
						con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}
		});
		frame.setBounds(100, 100, 586, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("sno");
		lblNewLabel.setBounds(51, 30, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(155, 27, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("sname");
		lblNewLabel_1.setBounds(51, 79, 69, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 76, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("sadd");
		lblNewLabel_2.setBounds(51, 145, 69, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(165, 142, 146, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("First");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.first();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(26, 187, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!rs.isLast()){
					    rs.next();
					
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					}
					}
				catch(SQLException se){
					se.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(155, 184, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("previous");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					if(!rs.isFirst()){
					    rs.previous();
					
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					}
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(283, 184, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("last");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.last();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(413, 184, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
	}
}
