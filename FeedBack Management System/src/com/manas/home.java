package com.manas;

import java.awt.EventQueue;
import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import java.sql.Connection;

import java.sql.PreparedStatement;

public class home extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public home() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 319, 1014, 460);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(490, 441, 97, 25);
		contentPane.add(btnNewButton);
		
		 String[][] data =new String[100][2];
		 int i=0,j=0;
		 List li1=new List();
		 List li2=new List();
		 List li3=new List();
		 List li4=new List();
		 List li5=new List();
		 List li6=new List();
		 List li7=new List();
		 List li8=new List();
		        // Column Names 
		        String[] columnNames = { "Name",  }; 
		  
		        // Initializing the JTable 
		      
		
		try{
			System.out.println("add");
			
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("add");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_project_db","root","danceguru@39");
			//System.out.println("add");
			
			PreparedStatement st= con.prepareStatement("Select name,number,email,date,gender,amb,ove,ser,cls from stud");
			//System.out.println("add");
			//st.setString(7,city);
			
			ResultSet rs=st.executeQuery();
			
			li1.add("|Name|");
		
		
			
			while(rs.next())
			{
				/*data[i][j]=rs.getString(1);
				j++;
				data[i][j]=rs.getString(2);
				//System.out.println(data[i][j]);
				i++;*/
				li1.add(rs.getString(1) + "-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4)+"-"+rs.getString(5));
				i++;
				
				
			}
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		String data1[][]=new String[i][i];
	
		j=0;
		for (int k=0;k<i;k++)
		{
		
			data1[k][j]=li1.getItem(k);
			j++;			
			j=0;
		}
		table = new JTable(data1,columnNames);
		table.setBounds(12, 13, 1014, 460); 
		contentPane.add(table);		
		
		//JScrollBar scrollBar = new JScrollBar(table);
		//scrollBar.setBounds(12, 13, 69, 330);
		//contentPane.add(scrollBar);
	//	  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//	        JScrollPane pane = new JScrollPane(table);
	//        add(pane, BorderLayout.CENTER);
	}
}
