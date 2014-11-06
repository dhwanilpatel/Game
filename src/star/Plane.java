package star;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Plane implements KeyListener,Runnable
{
	public Triangle tri;
	int velocityX,velocityY;
	Thread t;
	public boolean a,b;
	public Plane(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		this.tri=new Triangle(x1, y1, x2, y2, x3, y3);
		this.velocityX=(int)(2*Math.random()-1);
		this.velocityY=(int)(2*Math.random()-1);
		t=new Thread(this);
		t.start();
	}

	public void keyPressed(KeyEvent key) 
	{
		int k=key.getExtendedKeyCode();
		if(k==37)
			tri.setaxaycounterclk();
		else if(k==39)
			tri.setaxayclk();
		else if(k==38)
		{
			this.velocityX+=0.03*tri.ax;
			this.velocityY+=0.03*tri.ay;
		}	
		else if(k==32)
		{
			this.bul();
		}
	}

	public void bul()
	{
		if(MainWindow.bullets.size()>=2)
		{
			
		}
		else
		{
			MainWindow.bullets.add(new Bullate((int)tri.ax, (int)tri.ay,(int) tri.line1.x1, (int)tri.line1.y1));
			/*try
			{
				//Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	public void keyReleased(KeyEvent arg0) {
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() 
	{
		while(true)
		{
		//	System.out.println(tri.ax+" "+tri.ay);
	try
	{
		for(objects o:MainWindow.objs)
		{
			if(this.tri.intersect(o.obj))
			{
				MainWindow.t.stop();
				JOptionPane.showMessageDialog(null, "game over \nScore is "+MainWindow.score);
				System.exit(0);
			}
		}
	}
	catch(Exception e)
	{
		
	}
		if(tri.line1.x1>1365 && tri.line2.x1>1365 && tri.line3.x1>1365)
		{
			tri.line1.x1-=1362;
			tri.line2.x1-=1362;
			tri.line3.x1-=1362;
		}
		if(tri.line1.y1>655 && tri.line2.y1>655 && tri.line3.y1>655)
		{
			tri.line1.y1-=652;
			tri.line2.y1-=652;
			tri.line3.y1-=652;
		}
		if(tri.line1.y1<0 && tri.line2.y1<0 && tri.line3.y1<0)
		{
			tri.line1.y1+=652;
			tri.line2.y1+=652;
			tri.line3.y1+=652;
		}
		if(tri.line1.x1<0 && tri.line2.x1<0 && tri.line3.x1<0)
		{
			tri.line1.x1+=1362;
			tri.line2.x1+=1362;
			tri.line3.x1+=1362;
		}
		
		tri = new Triangle((int)(tri.line1.x1+velocityX),(int)(tri.line1.y1+velocityY),(int)(tri.line2.x1+velocityX),(int)(tri.line2.y1+velocityY),(int)(tri.line3.x1+velocityX),(int)(tri.line3.y1+velocityY));
		a=false;
		b=false;
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
	}
	public int clipY(double pos)
	{
		if(!b)
			return (int)pos;
		if(pos<0)
			return 653;
		if(pos>655)
			return 2;
		return (int)pos;
	}
	public int clip(double pos)
	{
		if(!a)
			return (int)pos;
		if(pos<0)
			return 1363;
		if(pos>1365)
			return 2;
		return (int)pos;
	}

	
	public void destroy()
	{
		
	}
}
