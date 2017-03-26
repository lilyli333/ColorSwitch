import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int xPos, yPos;
	private int originalYPos;
	private static final int SIZE = 10;
	private Color color;
	
	public Ball(int x, int y){
		xPos = x;
		yPos = y;
		originalYPos = y;
		System.out.println("ball is constructed");
		color = Color.RED;
	}
	
	public void jump(Obstacle ob){
		
		if(yPos <= ob.getBottomY() && yPos <= ob.getTopY() && color == ob.getColor()){
			yPos -= 10;
		}
		else if (yPos <= ob.getBottomY() && yPos <= ob.getTopY() && color != ob.getColor()) {
			yPos = originalYPos;
		}
		else
		{
			yPos -= 10;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(xPos, yPos, SIZE, SIZE);
	}
	
	public void changeYPos(int y){
		yPos += y;
	}
	
	public int getY(){
		return yPos;
	}
}
