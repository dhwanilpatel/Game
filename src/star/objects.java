package star;

import java.awt.geom.Ellipse2D;

public abstract class objects implements Runnable 
{
	public Ellipse2D.Double obj;
	public float velocityX;
	public float velocityY;
	public Thread t;
	
	public objects(float vx,float vy,int x,int y,int w,int h)
	{
		this.obj=new Ellipse2D.Double(x,y,w,h);
		this.velocityX=vx;
		this.velocityY=vy;
		t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		// TODO Auto-generated method stub
	//ystem.out.println(this.obj.getX()+" "+this.obj.getY()+"        "+this.velocityX+" "+this.velocityY);
		obj.setFrame((this.obj.getX()+this.velocityX)>1365?1:((this.obj.getX()+this.velocityX)<0?1364:(this.obj.getX()+this.velocityX)),(this.obj.getY()+this.velocityY)>655?2:(this.obj.getY()+this.velocityY)<0?653:(this.obj.getY()+this.velocityY),this.obj.getWidth(),this.obj.getHeight());
	}
	
	public abstract void destroy();

}
