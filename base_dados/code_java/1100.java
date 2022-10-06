import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class SolutionB {
      public static void main(String args[])throws IOException{
              Scanner sc = new Scanner(System.in);
              int a[] = new int[1501];
              for(int i = 0; i < 3; i++){
                     a[sc.nextInt()]++;
              }
              if(a[1] > 0 || a[2] > 1 || a[3] > 2 || (a[4] == 2 && a[2] == 1)){
                     System.out.println("YES");
              }else{
                     System.out.println("NO");
              }
      }
}