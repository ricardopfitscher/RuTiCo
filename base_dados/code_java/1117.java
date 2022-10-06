 
 


import java.util.Scanner;
import javafx.geometry.Point2D;

 
public class ChessKing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
long size = input.nextLong();
long a = input.nextLong();
long b = input.nextLong();
  long sum = a+b;
   long d = sum-2;
   long d1 = size*2 - sum;
if(d<d1) System.out.println("White");
else if(d>d1) System.out.println("Black");
else System.out.println("White");


    }
    
}
