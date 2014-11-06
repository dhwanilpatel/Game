package egypt;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MakeRectangles
{

	private ArrayList<Rectangle> rectangles;
	public MakeRectangles(ArrayList<Rectangle> r)
	{
		rectangles = r;
	}
	public void makeRectangles(int raw,int col)
	{
		Rectangle tmp;
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<raw;j++)
			{
				//System.out.println("aaa");
			tmp=new Rectangle(i*(1800/(col)), j*(480/(raw)),1800/col-20, 480/raw-20);
			rectangles.add(tmp);
		
			}
		}	
	}
}
