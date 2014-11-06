package star;

public class SmallBall extends objects
{

	public SmallBall(float vx, float vy, int x, int y)
	{
		super(vx, vy, x, y,25,25);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() 
	{
		// TODO Auto-generated method stub
		MainWindow.score+=40;
		MainWindow.objs.remove(this);
	}
	
	public void run()
	{
		while(true)
		{
			super.run();
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

}
