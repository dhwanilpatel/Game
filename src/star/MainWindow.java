package star;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MainWindow extends Applet implements Runnable
{

	public static int score;
	public static ArrayList<objects> objs=new ArrayList<objects>();
	public static ArrayList<objects> bullets=new ArrayList<objects>();
	public static Thread t;
	public Plane plane;

	public void init()
	{
		setSize(1365,655);
		setFocusable(true);
		objs.add(new BigBall(0.5f, 0.5f, 10, 10));
		plane=new Plane(getWidth()/2,getHeight()/2, getWidth()/2-20, getHeight()/2+80,getWidth()/2+20 ,getHeight()/2+80);
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("key pessed");  
				plane.keyPressed(e);
			}
		});
		t=new Thread(this);
		t.start();
	}	
	
	public void paint(Graphics g)
	{
		setBackground(Color.black);
		for(int i=0;i<20;i++)
		{
			//System.out.println(1);
			g.setColor(Color.WHITE);
			g.fillOval((int)(Math.random()*1365), (int)(Math.random()*655), 5,5);
		}
		g.setColor(Color.gray);
		try
		{
			for(objects o:this.objs)
			{
				g.fillOval((int)o.obj.getX(),(int) o.obj.getY(), (int)o.obj.getWidth(),(int) o.obj.getHeight());
			}
		}
		catch(Exception e)
		{
			
		}
		g.setColor(Color.blue);
		int[] a1={(int)this.plane.tri.line1.x1,(int)this.plane.tri.line2.x1,(int)this.plane.tri.line3.x1};
		int[] a2={(int)this.plane.tri.line1.y1,(int)this.plane.tri.line2.y1,(int)this.plane.tri.line3.y1} ;
		g.fillPolygon(a1,a2, 3);
		g.setColor(Color.yellow);
		try
		{
		for(objects o:bullets)
		{
			g.fillOval((int)o.obj.getX(),(int) o.obj.getY(), (int)o.obj.getWidth(),(int) o.obj.getHeight());
		}
		}
		catch(Exception e)
		{
			
		}
		
		Font f=new Font("Arial",Font.ITALIC,50);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString(score+"", 50,50);
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			this.repaint();
			if(this.objs.isEmpty())
			{
			//	t.stop();
				JOptionPane.showMessageDialog(null, "You Won Your Score is "+score);
				System.exit(0);
			}
			try 
			{
				Thread.sleep(9);
			}
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
