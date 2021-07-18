package com.manas;

import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import com.manas.*;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class adm_login extends JFrame {

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
					adm_login frame = new adm_login();
					frame.setTitle("Feedback Form Management System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public adm_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		
		final Color color2 = new Color(174, 182, 191  );
		Color color1 = new Color(93, 109, 126  );
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(color1);
		
		JLabel lblNewLabel = new JLabel("Feedback Form Management Admin Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(152, 13, 804, 126);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481, 170, 281, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 286, 281, 68);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Admin-ID");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(250, 178, 193, 52);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(250, 286, 193, 52);
		contentPane.add(lblPassword);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnNewButton.setBounds(538, 392, 224, 73);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=0,j=0;
				String ustr=textField.getText();
				@SuppressWarnings("deprecation")
				String pstr=passwordField.getText();
				try{
					System.out.println("add");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_project_db","root","danceguru@39");
					
					PreparedStatement st= con.prepareStatement("Select user,pass from adm where user=? and pass=?");
					
					st.setString(1,ustr);
					st.setString(2,pstr);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
					
						i=1;
					}
					else{
					
						i=0;
					}
				}
				catch(Exception w1)
				{
				System.out.println(w1);	
				}
				
				if(i==1)
				{
					dispose();
					adm_home ah=new adm_home();
					ah.setTitle("Faculty Home");
					ah.setVisible(true);
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
				}
			}
		});
	
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("User Panel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				user us=new user();
				us.setTitle("Student-Login");
				us.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnNewButton_1.setBounds(250, 387, 262, 83);
		contentPane.add(btnNewButton_1);
		
		label_1 = new JLabel("");
	//	label_1.setIcon(new ImageIcon("C:\\Users\\Soumyadeep\\Desktop\\a11.jpg"));
		label_1.setBounds(0, 0, 1008, 562);
		contentPane.add(label_1);
	}

}