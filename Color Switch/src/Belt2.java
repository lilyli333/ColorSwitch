import java.awt.Color;
import java.awt.Graphics;

public class Belt2 extends Obstacle
{
	private int yPos;
	private static int windowX;
	private static final int HEIGHT = 10;
	
	public Belt2(int x, int y)
	{
		super();
		yPos = y;
		windowX = x;
		System.out.println("belt is constructed");
	}
	
	public void draw(Graphics g){
		g.setColor(super.getColor());
		g.fillRect(0, yPos, windowX, HEIGHT);
		System.out.print("belt is drawn");
	}
	
	public int getTopY(){
		return yPos;
	}
	public int getBottomY(){
		return yPos + HEIGHT;
	}
}
