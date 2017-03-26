import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private static int xPos, yPos;
	private static int originalYPos;
	private static final int SIZE = 10;
	private static Color color;
	
	public Ball(int x, int y){
		xPos = x;
		yPos = y;
		originalYPos = y;
		System.out.println("ball is constructed");
		color = Color.RED;
	}
	
//	public void jump(Obstacle ob){
//		
//		if (yPos <= ob.getBottomY() && yPos <= ob.getTopY() && color != ob.getColor()) {
//			yPos = originalYPos;
//			System.out.println("hit");
//		}
//		else
//		{
//			yPos --;
//			System.out.println("kepp going");
//		}
//	}
	
	public void jump(){
		yPos -= 10;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(xPos, yPos, SIZE, SIZE);
	}
	
	public static int getY(){
		return yPos;
	}
	
	public static Color getColor(){
		return color;
	}

}
