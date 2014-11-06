package flappy;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

import javax.swing.JOptionPane;



public class Bird extends Ellipse2D.Double implements Runnable
{
	
	double vY;
	double g;
	double t;
	int score;
	LinkedList<Rectangle> rectangles;
	public Bird(LinkedList<Rectangle> rectangles)
	{
	
		this.rectangles=rectangles;
		this.x= 100;
		this.y= 50;
		this.width=50;
		this.height=50;
		vY=0;
		g=500;
		t=(float) 0.01;
		new Thread(this).start();
	}
	
	public void run() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.y+=(vY*t + 0.5*g*t*t);
			vY += g*t;
		//	System.out.println("bird v"+vY +"    bird y:" +y);
			if(rectangles.size()>=2)
			{
				if(this.intersects(rectangles.get(0)) || this.intersects(rectangles.get(1)) || this.y>=1000 )
					this.die();
				
				
			}
		}
	}
	
	public void jump()
	{
		this.vY=-300;
	}
	
	public void die()
	{
		
		PoleGenerator.stopThread();
		FlappyBird.stopThread();
		JOptionPane.showMessageDialog( null, "GAME OVER\n your score is "+score,null, 1);
		
		System.out.println(score);
		System.exit(0);
	}
}
