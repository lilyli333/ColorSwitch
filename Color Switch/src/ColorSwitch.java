import java.awt.*;
import java.awt.RenderingHints.Key;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.KeyEvent;

// Declare skyColor:
public class ColorSwitch extends JPanel implements ActionListener, KeyListener {
	private Ball b;
	 private Belt belt;
	 private Belt belt2;
	private final int WIDTH = getWidth();
	private final int HEIGHT = getHeight();
	private boolean beltCrossed, belt2Crossed;

	public ColorSwitch() {
		JFrame w = new JFrame("Color Switch");
		w.setBounds(300, 200, 600, 500);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = w.getContentPane();
		c.add(this);
		w.setFocusable(true);
		w.requestFocusInWindow();
		w.addKeyListener(this);
		w.setVisible(true);
		
		b = new Ball(getWidth() / 2, getHeight() - 10);

		
		 belt = new Belt(getWidth(), 200);
		 belt2 = new Belt (getWidth(), 300);
		
		 
		 new Thread(()->{
				while(true) {
					// do whatever you want
					repaint();
					beltCrossed = belt.checkJump();
					belt2Crossed = belt2.checkJump();
					try {
					Thread.sleep(100);
					} catch(final InterruptedException x) {
						x.printStackTrace();
					}
				}
			}).start();
	}

	// Draws the rainbow.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		b.draw(g);
		belt.draw(g);
		//UNCOMMENT FOR SECOND BELT (it doesn't completely work)
		belt2.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		
//		while(b.getY() < getHeight()-10){
//			b.jump();
//			System.out.println("falling");
//		}

	}

	public static void main(String[] args) {
		ColorSwitch sw = new ColorSwitch();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(beltCrossed == false && belt2Crossed == false)
				b.jump();
			else{
				 JOptionPane.showMessageDialog(null,
		    	          "Gamed ended. Please play again",
		    	          "Game end!", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			repaint();
		}
		System.out.println("hello");

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
