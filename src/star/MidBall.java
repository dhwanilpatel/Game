package star;

public class MidBall extends objects
{
	float s=0.3f;
	public MidBall(float vx, float vy, int x, int y)
	{
		super(vx, vy, x, y,50,50);
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
		MainWindow.score+=80;
		MainWindow.objs.add(new SmallBall((this.velocityX+s),(this.velocityY+s),(int) this.obj.getX(),(int)this.obj.getY()));
		// TODO Auto-generated method stub
		MainWindow.objs.add(new SmallBall((this.velocityX+s), (this.velocityY-s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.add(new SmallBall((this.velocityX-s), (this.velocityY+s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.add(new SmallBall((this.velocityX-s), (this.velocityY-s),(int) this.obj.getX(),(int)this.obj.getY()));
		MainWindow.objs.remove(this);
	}
	

}
