import java.lang.Math;

public class GameOfLife extends PApplet{

  int[][] oldCells = new int[32][32];
  int[][] newCells = new int[32][32];
  
  int counter = 0;
  
  //=====REWRITE OLD CELLS=====
  public static void rewrite(int[][] oldCells, int[][] newCells) {
    for (int i = 0; i <= 31; i = i + 1) { //Rows
      for (int j = 0; j <= 31; j = j + 1) { //Columns
        oldCells[i][j] = newCells[i][j];
      }
    }
  }
  //=====REWRITE OLD CELLS=====
  
  
  //=====PRINT ARRAY=====
  public static void printArray(int[][] array) {
    for (int i = 0; i <= 31; i = i + 1) { //Rows
      for (int j = 0; j <= 31; j = j + 1) { //Columns
          System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
  //=====PRINT ARRAY=====
  
  public void settings(){
    size(600, 600);
  }
  
  public void setup(){
    frameRate(4);
    //=====FILL ARRAY=====
    for (int i = 1; i <= 30; i = i + 1) { //Rows
      for (int j = 1; j <= 30; j = j + 1) { //Columns
        if ((float)Math.random() <= 0.1) {
          oldCells[i][j] = 1;
          newCells[i][j] = 1;
        }
      }
    }
    //=====FILL ARRAY=====
  }
  
  public void draw(){
   background(255);
   
   //=====DRAW RECTANGLES=====
   for (int i = 1; i <= 30; i = i + 1) { //Rows
      for (int j = 1; j <= 30; j = j + 1) { //Columns
         if (oldCells[i][j] == 1) {
           fill(0);
           rect(20 * j - 20, 20 * i - 20, 20, 20);
         }
      }
    }
   //=====DRAW RECTANGLES=====
   
   //=====CHECKING RULES=====
    for (int i = 1; i <= 30; i = i + 1) { //Rows
      for (int j = 1; j <= 30; j = j + 1) { //Columns
      //=====LIVING CELLS=====
         if (oldCells[i][j] == 1) {
           for (int p = i - 1; p <= i + 1; p = p + 1) { //Rows
             for (int g = j - 1; g <= j + 1; g = g + 1) { //Columns
               if (oldCells[p][g] == 1 && !(p == i && g == j)) {
                 counter = counter + 1;
               }
             }
           }
           if (counter < 2) {
             newCells[i][j] = 0;
           }
           else if (counter > 3) {
             newCells[i][j] = 0;
           }
           else if (counter == 2 || counter == 3) {
             newCells[i][j] = 1;
           }
           counter = 0;
         }
         //=====LIVING CELLS=====
         
         //=====DEAD CELLS=====
         else if (oldCells[i][j] == 0) {
           for (int p = i - 1; p <= i + 1; p = p + 1) { //Rows
             for (int g = j - 1; g <= j + 1; g = g + 1) { //Columns
               if (oldCells[p][g] == 1 && !(p == i && g == j)) {
                 counter = counter + 1;
               }
             }
           }
           if (counter == 3) {
             newCells[i][j] = 1;
           }
           counter = 0;
         }
         //=====DEAD CELLS=====
      }
    }
    //=====CHECKING RULES=====
    rewrite(oldCells, newCells);
  }
  
  public static void main(String[] args){
      PApplet.main("GameOfLife");
  }
}  
