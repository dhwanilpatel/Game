package TTT;
import java.io.*;

   public class TicTacGame implements Serializable {
      char[] pos = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
      public void clearAll() {
         for (int i=0;i<9;i++) 
            pos[i] = ' ';
      
      }
      public void clear(int i) {
         pos[i]=' ';
      }
      public void clear(int x, int y) {
         pos[x+y*3]=' ';
      }
      public void putX(int i) {
         pos[i]='X';
      }
      public void putX(int x, int y) {
         pos[x+y*3]='X';
      }
   
      public void putO(int i) {
         pos[i]='O';
      }
      public void putO(int x, int y) {
         pos[x+y*3]='O';
      }
      public char get(int i) {
         return pos[i];
      }
      public char get(int x, int y) {
         return pos[x+3*y];
      }
   }	

