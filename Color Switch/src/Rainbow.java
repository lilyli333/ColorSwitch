// Written by Lily Li on 10/10

import java.awt.*;
import javax.swing.*;
import java.awt.event. *;
import java.util.Random;

public class Rainbow extends JPanel implements ActionListener
{
  // Declare skyColor:
  private final Color SKYCOLOR;
  private int cloudX, xCenter, yCenter, xSpeed, ySpeed, randNum;

  public Rainbow()
  {
	  SKYCOLOR = new Color(204,255,255);
    setBackground(SKYCOLOR);
    
    Timer clock = new Timer(30, this); 
    clock.start();
    cloudX = 0;
    xCenter = 100;
    yCenter = 100;
    xSpeed = 5;
    ySpeed = 7;
    randNum = (int )(Math.random() * 50 + 1);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    
    
 
    // Declare and initialize the radius of the large semicircle:
    int largeRadius = 100;
    
    int startAng = 0;
    int arcAng = 180;
    
    Color lightRed = new Color(255,51,51);
    g.setColor(lightRed);

    // Draw the large semicircle:
    //g.fillArc(x, y, width, height, startAngle, arcAngle);
     g.fillArc(xCenter - largeRadius, yCenter-largeRadius, largeRadius*2, largeRadius*2, startAng, arcAng);

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    Color lightOrange = new Color (255,153,51);
    g.setColor(lightOrange);
    int orangeRadius = (largeRadius *6)/7;
    g.fillArc(xCenter-orangeRadius, yCenter- orangeRadius, orangeRadius*2, orangeRadius*2, startAng, arcAng);
    
    Color lightYellow = new Color(255,255,102);
    g.setColor(lightYellow);
    int yellowRadius = largeRadius * 5 / 7;
    g.fillArc(xCenter-yellowRadius, yCenter-yellowRadius , yellowRadius*2, yellowRadius*2, startAng, arcAng);
    
    Color lightGreen = new Color(153,255,153);
    g.setColor(lightGreen);
    int greenRadius = largeRadius * 4/7;
    g.fillArc(xCenter - greenRadius, yCenter- greenRadius, greenRadius*2, greenRadius*2, startAng, arcAng);
    
    Color lightBlue = new Color(102,178,255);
    g.setColor(lightBlue);
    int blueRadius = largeRadius * 3/7;
    g.fillArc(xCenter - blueRadius, yCenter-blueRadius, blueRadius*2, blueRadius*2, startAng, arcAng);
    
    Color violet = new Color(229,153,255);
    g.setColor(violet);
    int violetRadius = largeRadius * 2/7;
    g.fillArc(xCenter - violetRadius, yCenter - violetRadius, violetRadius*2, violetRadius*2, startAng, arcAng);
    
    g.setColor(SKYCOLOR);
    int skyRadius = largeRadius * 1/7;
    g.fillArc(xCenter - skyRadius, yCenter - skyRadius, skyRadius*2, skyRadius*2, startAng, arcAng);
    
    //draw clouds
    //int cloudX = 0;
    //cloudX ++;
    g.setColor(Color.WHITE);
    g.fillOval(cloudX, 20, 60, 60);
    g.fillOval(cloudX + 40, 20, 50, 50);
    g.fillOval(cloudX - 35, 20, 50, 50);
    
    if(cloudX + largeRadius> getWidth()){
    	cloudX = -100;
    }
    
    for(int i = 0; i < 100; i++){
    	g.setColor(Color.WHITE);
    	g.fillOval(getWidth()+1, randNum, 10, 10);
    }
    
     if(xCenter + largeRadius> getWidth()){
    	 xSpeed = -5;
    	 ySpeed = 1;
     }
     
     if(xCenter - largeRadius< 0){
    	 xSpeed = 7;
    	 ySpeed = -5;
     }
     
     if(yCenter + largeRadius> getWidth()){
    	 xSpeed = 3;
    	 ySpeed = -5;
     }
     if(yCenter - largeRadius< 0) {
    	 xSpeed = -2;
    	 ySpeed = 6;
     }
  }
  
  public void actionPerformed(ActionEvent e)
  {
    cloudX+=5;
    xCenter += xSpeed;
    yCenter += ySpeed;
    repaint();
   
  }


  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 200, 600, 500);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
