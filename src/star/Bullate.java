package star;

public class Bullate extends objects
{
	float t;
	public Bullate(int vx, int vy, int x, int y) {
		super(vx, vy, x, y, 10, 10);
		t=0;
		// TODO Auto-generated constructor stub
	}

	public void run()
	{
		while(true)
		{
			super.run();
		
			for(int i=0;i<MainWindow.objs.size();i++)
			{
				if(this.obj.intersects(MainWindow.objs.get(i).obj.getBounds()))
				{

					MainWindow.objs.get(i).destroy();
					this.destroy();
					break;
				}
			}
			try
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t+=.1;
			
			
			if(t>2)
			{
				this.destroy();
				
				break;
			}
		}
	}
	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		MainWindow.bullets.remove(this);
		super.t.stop();
	}
	
}
