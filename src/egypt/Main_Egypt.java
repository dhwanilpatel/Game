package egypt;

import javax.swing.JFrame;

public class Main_Egypt
{

	public static void main(String args[])
	{
		JFrame f=new JFrame();
		MainWindow m =new MainWindow();
		m.start();
		m.init();
		f.setContentPane(m);
		f.setSize(1800,1000);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
