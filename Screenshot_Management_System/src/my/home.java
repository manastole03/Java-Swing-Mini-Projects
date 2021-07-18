package my;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.border.EmptyBorder;



public class home extends JFrame {
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	private JLabel label_1;
	private JPanel panal;


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
		
		
		final Color color2 = new Color(174, 182, 191  );
		Color color1 = new Color(93, 109, 126  );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		
		panal = new JPanel();
		panal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panal);
		panal.setLayout(null);
		//((RootPaneContainer) panal).getContentPane().setBackground(Color.BLUE);
		panal.setBackground(color1);
		
		JLabel label2 = new JLabel(" Welcome to Screenshot Management System");
		label2.setForeground(color2);
		label2.setFont(new Font("Lato", Font.PLAIN, 45));
		label2.setBounds(12, 42, 1008, 93);
		panal.add(label2);
		
		/*JLabel label1 = new JLabel(" Please Give Your Valuable Feedback.....");
		label1.setForeground(color2);
		label1.setFont(new Font("Lato", Font.PLAIN, 47));
		label1.setBounds(24, 130, 1008, 93);
		panal.add(label1);*/
		

		/*JLabel label3 = new JLabel("(Please take out some time and share your valueable feedback for us.\n"
				+ "Which helps us for improvement.)");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Lato", Font.PLAIN, 20));
		label3.setBounds(24, 220, 1008, 93);
		panal.add(label3);*/
		
		btnNewButton = new JButton("Take SS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{

			       
						Thread.sleep(120);
						Robot r = new Robot();

						String path = "D:\\manas.png";

						Rectangle capture= new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

						BufferedImage Image = r.createScreenCapture(capture);

						ImageIO.write( Image, "jpg", new File(path));

						System.out.println("Image saved");

				} 
				catch (AWTException | IOException | InterruptedException ex )
				{
					System.out.println(ex);
				} 
			}
		});
		btnNewButton.setFont(new Font("Lato", Font.BOLD, 30));
		btnNewButton.setBounds(520, 372, 400, 150);
		btnNewButton.setBackground(color2);
		panal.add(btnNewButton);
		
		
		btnNewButton_1 = new JButton("View Screenshots");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				scr obj=new scr();
				obj.setTitle("Feedback");
				obj.setVisible(true);
	}
		});
		btnNewButton_1.setFont(new Font("Lato", Font.BOLD, 31));
		btnNewButton_1.setBounds(36, 372, 400, 150);
		btnNewButton_1.setBackground(color2);
		panal.add(btnNewButton_1);
		
		
		label_1 = new JLabel("");
		//label_1.setIcon(new ImageIcon("https://cdn.pixabay.com/photo/2017/07/02/09/53/feedback-2463927__340.jpg"));
		label_1.setBounds(0, 0, 1008, 562);
		panal.add(label_1);
	}

}