package my;

import java.awt. AWTException;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage; 
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class ss 
{
	public ss() {
	final long serialverstonUID = 1L; 
	try 
	{

			Thread.sleep(120);
			Robot r = new Robot();

			String path = "D://ScreeShot.jpg";

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
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					home frame = new home();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}