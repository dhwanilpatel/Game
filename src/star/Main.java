package star;

import java.applet.Applet;
import java.beans.AppletInitializer;
import java.beans.beancontext.BeanContext;

public class Main
{
	
	
	public static void main(String args[])
	{
		MainWindow m;
		m=new MainWindow();
		
		AppletInitializer a=new AppletInitializer() {
			
			@Override
			public void initialize(Applet newAppletBean, BeanContext bCtxt) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void activate(Applet newApplet) {
				// TODO Auto-generated method stub
				newApplet.init();
				newApplet.start();
				System.out.println("applet started");
			}
		};
		
		a.activate(m);
	}
}
