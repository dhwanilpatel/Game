package star;

public class BigBall extends objects
{
	float s=0.6f;
	public BigBall(float vx, float vy, int x, int y)
	{
		super(vx, vy, x, y,75,75);
		// TODO Auto-generated constructor stub
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

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		MainWindow.score+=40;
		MainWindow.objs.add(new MidBall((this.velocityX+s),( this.velocityY+s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.add(new MidBall((this.velocityX+s), (this.velocityY-s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.add(new MidBall((this.velocityX-s), (this.velocityY+s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.add(new MidBall((this.velocityX-s), (this.velocityY-s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.remove(this);
	}
	
	
}
