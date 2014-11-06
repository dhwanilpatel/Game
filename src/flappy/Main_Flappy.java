package flappy;

import javax.swing.JFrame;

import egypt.MainWindow;

public class Main_Flappy
{

	public static void main(String args[])
	{
		JFrame f=new JFrame();
		FlappyBird b =new FlappyBird();
		b.start();
		b.init();
		f.setContentPane(b);
		f.setSize(1800,1000);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}