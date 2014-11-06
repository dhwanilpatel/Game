package TTT;

   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;
   import java.net.*;
   public class TicTacToe {
      public static void main(String args[]) {
         try {
            Frame f = new Frame("TTT");
            f.setSize(360,360);
            f.addWindowListener(
                                  new WindowAdapter() {
                                     public void windowClosing(WindowEvent we) {
                                        System.exit(-1);
                                     }
                                  } ) ;
         	char ch;
         	if (args.length == 0)
         		ch = 'O';
         	else 
         		ch = 'X';
            TicTacPanel ttp = new TicTacPanel(ch);
            Button b = new Button("Clear");
            TicTacAction tta = new TicTacAction(ttp);
            b.addActionListener(tta);
         	ttp.add(b);
            ttp.addMouseListener(tta);
            f.add(ttp);
            f.show();
            Socket s;
            ObjectOutputStream oops;
            ObjectInputStream oips;
            ServerSocket s2=new ServerSocket(7777);;
            switch (ch) {
               case 'O':
            	   try{
            		   
                  s = (s2).accept();
            	   }
            	   catch(Exception e)
            	   {
            		  // System.out.println(e.getMessage());
            		   s = (s2).accept();
            	   }
                  oops = new ObjectOutputStream(s.getOutputStream());
                  oops.writeObject(ttp.ttt);
               	tta.ready = false;
                  break;
               case 'X':
               default:
                  s = new Socket(args[0],7777);
            		tta.ready = true;
            
            }
            while(true) {
               oips = new ObjectInputStream(s.getInputStream());
               ttp.ttt = (TicTacGame)(oips.readObject());
            	ttp.paint(ttp.getGraphics());
               tta.ready = true;
               while (tta.ready) {
                  Thread.sleep(100);
               }
               oops = new ObjectOutputStream(s.getOutputStream());
               oops.writeObject(ttp.ttt);
            }
         }
            catch (Exception e) { 
               System.out.println(e); System.exit(1); }
      
      
      }
   }