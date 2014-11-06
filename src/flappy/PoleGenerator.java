package flappy;

import java.awt.Rectangle;
import java.util.LinkedList;

public class PoleGenerator implements Runnable
{
	LinkedList<Rectangle> rectangles;
	
	int poleWidth=100;
	int poleYDistance=300;
	long time =2000; 
	int screnHeight,screenWidth;
	static Thread t;
	public PoleGenerator(LinkedList<Rectangle> r,int scrW,int scrH)
	{
		rectangles=r;
		this.screenWidth=1500;
		this.screnHeight=900;
		poleYDistance=this.screnHeight/3;
		t=new Thread(this);
		t.start();
		poleWidth=this.screenWidth/20;
	}
	
	
	public static void stopThread()
	{
		t.stop();
	}
	
	public void run()
	{
		while(true)
		{
			int random =(int)(screnHeight-poleYDistance - ((screnHeight-poleYDistance))* Math.random());
			rectangles.add(new Rectangle(screenWidth,0,poleWidth,random));
			rectangles.add(new Rectangle(screenWidth,random+poleYDistance,poleWidth,screnHeight-random-poleYDistance));
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
