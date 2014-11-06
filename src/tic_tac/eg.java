package tic_tac;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class eg implements ActionListener
{

	
	public static void main(String args[])
	{
		eg e=new eg();
		e.go();
	}

	private int counter=1;
	private JButton[] b=new JButton[9];
	JLabel l=new JLabel();
	JFrame f=new JFrame();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
	
	public void go()
	{
		
		//f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
		
		
		
		for(int i=0;i<9;i++)
			{
			b[i]=new JButton("\n");
			b[i].setActionCommand("b"+i);
			b[i].addActionListener(this);
			
			}
		
		p1.add(b[0]);
		p1.add(b[1]);
		p1.add(b[2]);
		
		f.add(p1,BorderLayout.NORTH);
		
		
		
		p2.add(b[3]);
		p2.add(b[4]);
		p2.add(b[5]);
		
		f.add(p2,BorderLayout.CENTER);
		
		
		
		p3.add(b[6]);
		p3.add(b[7]);
		p3.add(b[8]);
		
		f.add(p3,BorderLayout.SOUTH);
		f.add(l,BorderLayout.EAST);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(150,170);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String tmp=arg0.getActionCommand();
		if(counter%2==0)
		{
		for(int i=0;i<9;i++)
		{
			if(b[i].getActionCommand().equals(tmp) && b[i].getText().equals("\n"))
				{
				b[i].setText("X");
				counter++;
				if(engine.check(b).equals("X")||engine.check(b).equals("O"))
					{
					System.out.println("stop");
					l.setText(engine.check(b)+"wins");
					
					reset();
					}
					
				break;
				}
		}
		}
		
		else
		{
			for(int i=0;i<9;i++)
			{
				if(b[i].getActionCommand().equals(tmp) && b[i].getText().equals("\n"))
					{
					b[i].setText("O");
					counter++;
					if(engine.check(b).equals("X")||engine.check(b).equals("O"))
					{
						System.out.println("stop");
						l.setText(engine.check(b)+"wins");
					
					reset();
					}
					break;
					}
			}
		}
	}
	
	public void reset()
	{
		counter=1;
		for(int i=0;i<9;i++)
		{
		b[i].setText("\n");
		}
		//f.add(p2,BorderLayout.CENTER);
	}
}
