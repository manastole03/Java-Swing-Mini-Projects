package my;

import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class scr extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private String user[]={"1234"};
	private String pass[]={"abcd"};
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scr frame = new scr();
					frame.setTitle("Feedback Form Management System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public scr() {
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		
	 	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			Connection database = DriverManager.getConnection("jdbc:mysql://localhost:3306/ss", "root", "danceguru@39");
			  System.out.println("Database Connected!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			  System.out.println("Database not Connected!");
		}
       

		final Color color2 = new Color(174, 182, 191  );
		Color color1 = new Color(93, 109, 126  );
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(color1);
		
		JLabel lblNewLabel = new JLabel("Save your taken the Screenshot");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(152, 13, 804, 126);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("SS Name :");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblUsername.setBounds(280, 170, 163, 52);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField.setBounds(400, 170, 281, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblDob = new JLabel("Date :");
		lblDob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDob.setBounds(280, 300, 158, 32);
		contentPane.add(lblDob);
		
		JComboBox date = new JComboBox();
		for(int i=1;i<=31;i++)
		{
			String str=String.valueOf(i);
			date.addItem(str);
		}
		date.setBounds(400, 300, 109, 27);
		//date.setBackground(col);
		contentPane.add(date);
		JComboBox month = new JComboBox();
		month.setBounds(521, 300, 109, 27);
		month.addItem("Jan");
		month.addItem("Feb");
		month.addItem("Mar");
		month.addItem("Apr");
		month.addItem("May");
		month.addItem("Jun");
		month.addItem("Jul");
		month.addItem("Aug");
		month.addItem("Sep");
		month.addItem("Oct");
		month.addItem("Nov");
		month.addItem("Dec");
		//month.setBackground(col);
		contentPane.add(month);

		JComboBox year = new JComboBox();
		for(int i=1901;i<=2018;i++)
		{
			String str=String.valueOf(i);
			year.addItem(str);
		}
		year.setBounds(641, 300, 109, 27);
		//year.setBackground(col);
		contentPane.add(year);
		
		
		
		btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnNewButton.setBounds(438, 392, 124, 33);
		btnNewButton.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) 
			{
				if (lblUsername == null)
				{
		            JOptionPane.showMessageDialog(null, "Photo Is Required!!!");
		        }
				else 
				{ 			
					int i=1;
					String name = lblUsername.getText();
	                String date =  lblDob.getText();
	                InputStream photo = null;
					try {
						 photo = new FileInputStream(new File("D:\\screenshot"));
							System.out.print("File  found!");

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.print("File not found!");
					}
		            try
		            {
		                
		            	Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ss","root","danceguru@39");
		            	PreparedStatement st= con.prepareStatement(  "INSERT INTO table22(name,date,photo) VALUES (?,?,?)");  

		            	st.setString(1, name);
		            	st.setString(2, date);
		            	st.setBlob(3,photo);
		            	
		            	int j=0;
						j=st.executeUpdate();String n="\n";
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Record is added sucessfully"+n+"Thankyou.");
		            }
		            catch(Exception ex)
		            {
		            	
							System.out.println(ex);	
							JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
							
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
	}

}