package egypt;

import java.awt.geom.Rectangle2D;

public class Base extends Rectangle2D.Double implements Runnable
{
	Thread t;
	int x;
	int y=940;
	static int vb;
	public Base(int x)
	{
		this.x=x;
		t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		
		while(true)
		{
			//System.out.println("base thread start x y vb"+x+" "+ y+" "+vb);
			//System.out.println(vb);
			x+=vb;
			this.setFrame(x,y,200,20);
			
			if(this.getX()>1700)
			{
				x=1690;
				
			}

			if(this.getX()<5)
			{
				x=5;
				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
