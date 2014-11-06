package egypt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainWindow extends Applet implements Runnable
{

	static ArrayList<Rectangle > rectangles;
	int x;
	int y;
	int vx=5;
	int vy=5;
	static int vb;
	int g=1;
	ball b;
	Thread t;
	static int score;
	 MakeRectangles r;
	
	 static Base base;
	
	public void init()
	{
	
		rectangles=new ArrayList<Rectangle>();
		
		r=new MakeRectangles(rectangles);
		int raw=Integer.parseInt(JOptionPane.showInputDialog(null, "HOW MANY ROWS OF BLOCKS YOU WANT???"));
		int col=Integer.parseInt(JOptionPane.showInputDialog(null, "HOW MANY COLUMNS OF BLOCKS YOU WANT???"));
		r.makeRectangles(raw, col);
		setFocusable(true);
		
		b=new ball(800,500,5,5);
		base=new Base(800);
		
		
		
		t=new Thread(this);
		
		setSize(1800,970);
		this.addKeyListener(new KeyListener() {
			float time=1;
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				Base.vb=0;
				time=1;
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				time+=0.2f;
				
				if(arg0.getExtendedKeyCode()==37)
				{//System.out.println("leftarrow");
					Base.vb=(int) (-10*time);
				}
				else
					if(arg0.getExtendedKeyCode()==39)
						{//System.out.println("rightarrow");
						Base.vb=(int) (10*time);
						}
			}
		});
		
		
		t.start();
	}
	
	public void run()
	{
		//System.out.println("main thread start");
		while(true)
		{
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g)
	{
		
		
		
		Graphics2D g2d=(Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		g2d.fill(b);
		g2d.setColor(Color.BLUE);
		g2d.fill(base);
		try{
		for(Rectangle tmp:rectangles)
		{
			g2d.setColor(Color.white);
			g2d.draw(tmp);
			g2d.setColor(Color.magenta);
			g2d.fill(tmp);
		}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
}
