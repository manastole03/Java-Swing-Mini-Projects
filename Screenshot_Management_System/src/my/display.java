
package my;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class display extends JFrame {

Connection connection = null;
PreparedStatement statement = null;

ResultSet result;

public display()
{
    super("Image Display");
    setSize(600, 600);
    connection = getConnection();
    try { // table name:image and second image is field name
        statement = connection.prepareStatement("select photo from  table22 ");
        result = statement.executeQuery();

        byte[] image = null;
        while (result.next()) 
        {
            image = result.getBytes("photo");

        }
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon = new ImageIcon(img);
        Image scaleImage = icon.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);

        JLabel lPhoto = new JLabel();
        lPhoto.setIcon(icon);
       
        add(lPhoto);

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    setVisible(true);
}

public Connection getConnection() {
    Connection connection = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                // user name:root and password:blank
                "jdbc:mysql://localhost:3306/ss", "root","danceguru@39");

    } catch (Exception e) {
        System.out.println("Error Occured While Getting the Connection: - " + e);
    }
    return connection;
}


public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				display frame = new display();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


}