package com.manas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class add extends JFrame
{

	private JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					add frame = new add();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public add() 
	{
		Color color1 = new Color(93, 109, 126  );
		Color col = new Color(174, 182, 191);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 319, 1114, 660);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(color1);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBounds(59, 25, 145, 32);
		name.setBackground(col);
		contentPane.add(name);
		
		JTextArea c_name = new JTextArea();
		c_name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c_name.setBounds(235, 26, 166, 37);
		c_name.setBackground(col);
		contentPane.add(c_name);
		
		JLabel contact = new JLabel("Contact(Phone)");
		contact.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contact.setBounds(59, 107, 164, 32);
		contentPane.add(contact);
		
		JTextArea phone = new JTextArea();
		phone.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		phone.setBounds(235, 102, 166, 37);
		phone.setBackground(col);
		contentPane.add(phone);
		
		JLabel contact1 = new JLabel("Contact(Email)");
		contact1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contact1.setBounds(59, 190, 158, 32);
		contentPane.add(contact1);
		
		JTextArea email = new JTextArea();
		email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		email.setBounds(235, 190, 166, 37);
		email.setBackground(col);
		contentPane.add(email);
		
		
		JLabel sat = new JLabel("Overall Satisfaction ? ");
		sat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		sat.setBounds(59, 264, 179, 32);
		contentPane.add(sat);
		
		JRadioButton radio_btn = new JRadioButton("Yes");
		radio_btn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		radio_btn.setBounds(235, 242, 75, 44);
		radio_btn.setBackground(color1);
		contentPane.add(radio_btn);
		
		JRadioButton radio_btn2 = new JRadioButton("No");
		radio_btn2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		radio_btn2.setBounds(235, 283, 138, 40);
		radio_btn2.setBackground(color1);
		contentPane.add(radio_btn2);
		ButtonGroup btg=new ButtonGroup();
		btg.add(radio_btn2);
		btg.add(radio_btn2);
		
		
		JLabel lblDob = new JLabel("Review Date");
		lblDob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDob.setBounds(481, 25, 158, 32);
		contentPane.add(lblDob);
		
		JComboBox date = new JComboBox();
		for(int i=1;i<=31;i++)
		{
			String str=String.valueOf(i);
			date.addItem(str);
		}
		date.setBounds(662, 32, 48, 27);
		date.setBackground(col);
		contentPane.add(date);
		
		JComboBox month = new JComboBox();
		month.setBounds(739, 32, 75, 27);
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
		month.setBackground(col);
		contentPane.add(month);

		JComboBox year = new JComboBox();
		for(int i=1901;i<=2018;i++)
		{
			String str=String.valueOf(i);
			year.addItem(str);
		}
		year.setBounds(841, 32, 109, 27);
		year.setBackground(col);
		contentPane.add(year);
		
		JLabel lblRollNo = new JLabel("Ambiance Rating");
		lblRollNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblRollNo.setBounds(483, 184, 209, 32);
		contentPane.add(lblRollNo);
		
		JTextArea amb = new JTextArea();
		amb.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		amb.setBounds(662, 185, 166, 37);
		amb.setBackground(col);
		contentPane.add(amb);
		
		JLabel lblClassTeacher = new JLabel("Overall Rating");
		lblClassTeacher.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblClassTeacher.setBounds(481, 261, 158, 32);
		contentPane.add(lblClassTeacher);
		JTextArea over = new JTextArea();
		over.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		over.setBounds(662, 262, 166, 37);
		over.setBackground(col);
		contentPane.add(over);
	
		
		JLabel lblSection = new JLabel("Service Rating");
		lblSection.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSection.setBounds(481, 107, 169, 32);
		contentPane.add(lblSection);
		JTextArea ser = new JTextArea();
		ser.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		ser.setBounds(662, 110, 166, 37);
		ser.setBackground(col);
		contentPane.add(ser);
		
		JLabel lblClass = new JLabel("Your Words");
		lblClass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblClass.setBounds(59, 361, 145, 32);
		contentPane.add(lblClass);
		JTextArea text_ares = new JTextArea();
		text_ares.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		text_ares.setBounds(235, 362, 666, 170);
		text_ares.setBackground(col);
		contentPane.add(text_ares);

		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
				
					String name=c_name.getText();
					String phn= phone.getText();
					String mail = email.getText();

					String  condition="";
					if(radio_btn.isSelected())
					{
						condition="Male";
						
					}
					else if(radio_btn2.isSelected())
					{
						condition="Female";
						
					}
					int i=1;
					String cls=lblClass.getText();
					String rl=amb.getText();
					String tch=over.getText();
					String sec=ser.getText();
					
					
					String dt=(String) date.getSelectedItem();
					String mnth=(String) month.getSelectedItem();
					String yr=(String) year.getSelectedItem();
					
					String date=dt+"/"+mnth+"/"+yr;
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_project_db","root","danceguru@39");
						
						PreparedStatement st= con.prepareStatement("INSERT INTO stud(name,number,email,date,gender,amb,ove,ser,cls) values(?,?,?,?,?,?,?,?,?)");
						
						st.setString(1, name);
						st.setString(2, phn);
						st.setString(3, mail);
						st.setString(4, date);
						st.setString(5, condition);
						st.setString(6, rl);
						st.setString(7, tch);
						st.setString(8, sec);
						st.setString(9, cls);
						
						int j=0;
						j=st.executeUpdate();
						
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
				
					if(i==1)
					{
						String n="\n";
						
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Record is added sucessfully"+n+"Thankyou.");
					}
					else
					{

						JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(420, 550, 160, 40);
		contentPane.add(btnNewButton);
		
	}

	private void setBackground(String string) {
		// TODO Auto-generated method stub
		
	}
}
