package my;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class database
{

    private Connection database;

    public Connection connect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Found!");
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Driver Not Found!");
            System.out.println("Driver Found!" + e);
            System.exit(0);
        }

        try
        {
            database = DriverManager.getConnection("jdbc:mysql://localhost:3306/ss", "root", "danceguru@39");
            System.out.println("Database Connected!");
        } 
        catch (Exception exp)
        {
            JOptionPane.showMessageDialog(null, "Database Connection Failed!");
            System.out.println("Database Connection Failed!" + exp);
            System.exit(0);
        }
        return database;
    }
}

