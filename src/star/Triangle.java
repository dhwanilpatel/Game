package star;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Triangle	
{
	Line2D.Double line1,line2,line3;
	int x,y;
	float ax,ay;
	public Triangle(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		this.line1=new Line2D.Double(x1,y1,x2,y2);
		this.line2=new Line2D.Double(x3,y3,x1,y1);
		this.line3=new Line2D.Double(x2,y2,x3,y3);
		double centerX = (float)(line1.x1+line2.x1+line3.x1)/3;
		double centerY = (float)(line1.y1+line2.y1+line3.y1)/3;

		ax=(float) (x1-centerX);
		ay=(float) (y1-centerY);
	}
	public boolean intersect(Ellipse2D.Double obj)
	{
		if(line1.intersects(obj.getBounds()) || this.line2.intersects(obj.getBounds()) || this.line3.intersects(obj.getBounds()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setaxaycounterclk()
	{
		double centerX = (float)(line1.x1+line2.x1+line3.x1)/3;
		double centerY = (float)(line1.y1+line2.y1+line3.y1)/3;
		double angle;
		
		double theta=0.06;
		
		double length=Math.sqrt((line1.x1-centerX)*(line1.x1-centerX)+(line1.y1-centerY)*(line1.y1-centerY));
		angle=Math.atan2(line1.y1-centerY, line1.x1-centerX);
		double x1 = length*Math.cos(angle-theta)+centerX;
		double y1 = length*Math.sin(angle-theta)+centerY;
		ax=(float) (x1-centerX);
		ay=(float) (y1-centerY);
		length=Math.sqrt((line2.x1-centerX)*(line2.x1-centerX)+(line2.y1-centerY)*(line2.y1-centerY));
		angle=Math.atan2(line2.y1-centerY, line2.x1-centerX);
		double x2 = length*Math.cos(angle-theta)+centerX;
		double y2 = length*Math.sin(angle-theta)+centerY;
		
		length=Math.sqrt((line3.x1-centerX)*(line3.x1-centerX)+(line3.y1-centerY)*(line3.y1-centerY));
		angle=Math.atan2(line3.y1-centerY, line3.x1-centerX);
		double x3 = length*Math.cos(angle-theta)+centerX;
		double y3 = length*Math.sin(angle-theta)+centerY;
		
		line1.setLine(x1, y1, x2, y2);
		line2.setLine(x3, y3, x1, y1);
		line3.setLine(x2, y2, x3, y3);
		
	}
	
	public void setaxayclk()
	{
		double centerX = (float)(line1.x1+line2.x1+line3.x1)/3;
		double centerY = (float)(line1.y1+line2.y1+line3.y1)/3;
		double angle=Math.atan2(ay, ax);
		
		double theta=-0.06;
		
		double length=Math.sqrt((line1.x1-centerX)*(line1.x1-centerX)+(line1.y1-centerY)*(line1.y1-centerY));
		angle=Math.atan2(line1.y1-centerY, line1.x1-centerX);
		double x1 = length*Math.cos(angle-theta)+centerX;
		double y1 = length*Math.sin(angle-theta)+centerY;
		ax=(float) (x1-centerX);
		ay=(float) (y1-centerY);
		length=Math.sqrt((line2.x1-centerX)*(line2.x1-centerX)+(line2.y1-centerY)*(line2.y1-centerY));
		angle=Math.atan2(line2.y1-centerY, line2.x1-centerX);
		double x2 = length*Math.cos(angle-theta)+centerX;
		double y2 = length*Math.sin(angle-theta)+centerY;
		
		length=Math.sqrt((line3.x1-centerX)*(line3.x1-centerX)+(line3.y1-centerY)*(line3.y1-centerY));
		angle=Math.atan2(line3.y1-centerY, line3.x1-centerX);
		double x3 = length*Math.cos(angle-theta)+centerX;
		double y3 = length*Math.sin(angle-theta)+centerY;
		
		line1.setLine(x1, y1, x2, y2);
		line2.setLine(x3, y3, x1, y1);
		line3.setLine(x2, y2, x3, y3);
	}
}
