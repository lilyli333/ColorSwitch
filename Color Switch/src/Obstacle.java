import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Timer;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Obstacle implements ActionListener
{
	Timer timer;
	private long elapsedTime;
	//private Color obstacleColor;
	private Timer clock;
	private Color c;
	
	public Obstacle()  
	{		
		new Thread(()->{
			int in = -1;
			c = Color.GREEN;
			while(true) {
				// do whatever you want
				in = (int) (Math.random()*3 + 1);
				System.out.println("in is: " + in);
				try {
				Thread.sleep(2000);
				//repaint();
				} catch(final InterruptedException e) {
					e.printStackTrace();
				}
				if(in == 1){
					c = Color.RED;
					System.out.println("is red");
				}
				else if(in == 2){
					c = Color.BLUE;
					System.out.println("is blue");
				}
				else{
					c = Color.GREEN;
				}
			}
		}).start();
	}
	
	public Color getColor ()
	{
		return c;
//		System.out.println("start time: " + "elapsed Time : " + elapsedTime);
//		Color red = Color.RED;
//		Color blue = new Color (0, 255, 0);
//		Color green = new Color (0, 0, 255);
//		if (elapsedTime % 3 == 0)
//		{
//			System.out.println("red");
//			return Color.RED;
//		}
//		else if (elapsedTime % 3 == 1)
//		{
//			System.out.println("blue");
//			return Color.BLUE;
//		}
//		else if (elapsedTime % 3 == 2)
//		{
//			System.out.println("green");
//			return Color.GREEN;
//		}
//		else
//		{
//			return Color.GREEN;
//		}
//		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getTopY(){
		return 0;
	}
	public int getBottomY(){
		return 0;
	}
}
