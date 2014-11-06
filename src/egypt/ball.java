package egypt;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ball extends Ellipse2D.Double implements Runnable
{
	
	int x;
	int y;
	int vx;
	int vy;
	int g=1;
	Thread t;
	public ball(int x,int y,int vx,int vy)
	{
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;
		t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		
		while(true)
		{
			this.setFrame(x,y,20,20);
			//System.out.println("ball thread start x y vx vy"+x+" "+ y+" "+vx+" "+vy);
			
			
			try{
		
			for(Rectangle tmp:MainWindow.rectangles)
			{
				if(this.intersects(tmp))
				{
					MainWindow.rectangles.remove(tmp);
					MainWindow.score++;
				}
			}
			}
			catch(Exception e)
			{
				
			}
			
			if(this.intersects(MainWindow.base))
			{
				y=920;
				vy=-vy;	
				
				if(Base.vb==10)
				vx+=50;
				if(Base.vb==-10)
				vx-=50;
				
			}
			
			if(this.getX()>1780)
			{
				x=1780;
				vx=-vx;
			}

			if(this.getX()<5)
			{
				x=5;
				vx=-vx;
			}
			
			if(this.getY()>1000)
			{
				t.stop();
				vy=-vy;
				y=950;
				
			}
			
			if(this.getY()<5)
			{
				y=5;
				vy=-vy;
			}
			
			x+=vx;
			y+=vy;
			vy+=g;
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
