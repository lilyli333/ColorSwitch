import java.awt.Color;
import java.awt.Graphics;

public class Belt extends Obstacle
{
	private int yPos;
	private static int windowX;
	private static final int HEIGHT = 20;
	
	public Belt(int x, int y)
	{
		super();
		yPos = y;
		windowX = x;
	}
	
	public void draw(Graphics g){
		g.setColor(super.getColor());
		g.fillRect(0, yPos, windowX, HEIGHT);
	}
	
	public int getTopY(){
		return yPos;
	}
	public int getBottomY(){
		return yPos + HEIGHT;
	}

	public boolean checkJump(){
		if (Ball.getY() <= getBottomY() && Ball.getColor() != getColor()) {
			return true;
		}
		else{
			return false;
		}
	}
}
