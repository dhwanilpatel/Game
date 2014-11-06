package tic_tac;

import javax.swing.JButton;
import javax.swing.JFrame;

public class engine
{

	public static String check(JButton[] b)
	{
		if(b[0].getText().equals(b[1].getText())&&b[1].getText().equals(b[2].getText()))
			return b[0].getText();
		else
			if(b[3].getText().equals(b[4].getText())&&b[4].getText().equals(b[5].getText()))
				return b[3].getText();
			else
				if(b[6].getText().equals(b[7].getText())&&b[7].getText().equals(b[8].getText()))
					return b[6].getText();
				else
					if(b[0].getText().equals(b[3].getText())&&b[3].getText().equals(b[6].getText()))
						return b[0].getText();
					else
						if(b[1].getText().equals(b[4].getText())&&b[4].getText().equals(b[7].getText()))
							return b[1].getText();
						else
							if(b[2].getText().equals(b[5].getText())&&b[5].getText().equals(b[8].getText()))
								return b[2].getText();
							else
								if(b[0].getText().equals(b[4].getText())&&b[4].getText().equals(b[8].getText()))
									return b[0].getText();
								else
									if(b[2].getText().equals(b[4].getText())&&b[4].getText().equals(b[6].getText()))
										return b[2].getText();
							
		return "continue";
	}
}
