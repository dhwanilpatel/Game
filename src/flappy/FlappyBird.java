package flappy;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;



public class FlappyBird extends Applet implements Runnable,MouseListener
{
	LinkedList<Rectangle> rectangles = new LinkedList<Rectangle>();
	Bird b = new Bird(rectangles);
	PoleGenerator p = new PoleGenerator(rectangles,this.getWidth(),this.getHeight());
	static Thread t;
	public FlappyBird()
	{
		addMouseListener(this);
		t=new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g)
	{
		
		setBackground(Color.black);
		g.setColor(Color.red);
		g.setFont(new Font ("serif", Font. BOLD, 58));
		g.drawString(""+b.score, 900, 450);
		g.setColor(Color.BLUE);
		g.fillOval((int)b.getX(), (int)b.getY(), (int)b.getWidth(), (int)b.getHeight());
		g.setColor(Color.GREEN);
		for(Rectangle rect:rectangles)
		{
			g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
		}
	}
	public static void stopThread()
	{
	t.stop();	
	}
	
	public void run()
	{
		float vX=10;
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			
			if(rectangles.get(0).getX()==100)
			{
				b.score++;
			}
			
			if(rectangles.get(0).getX()<=-100)
			{

				rectangles.remove(0);
				rectangles.remove(0);
			}
			
			for(Rectangle rect:rectangles)
			{
				 rect.setFrame(new Rectangle2D.Double(rect.getX()-vX,rect.getY(),rect.width,rect.height));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		b.jump();
	//	System.out.println("mmm");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
