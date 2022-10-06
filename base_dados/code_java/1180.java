import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class SolutionB {
       
      public static void main(String args[])throws IOException{
              Scanner sc = new Scanner(System.in);
              long a[] = new long[14];
              for(int i = 0; i < 14; i++)
                     a[i] = sc.nextLong();
              long cpy[] = new long[14];
              long max = 0;
              for(int i = 0; i < 14; i++){
                     if(a[i] == 0)continue;
                     long score = 0;
                     long curr = a[i];
                     for(int j = 0; j < 14; j++)
                            cpy[j] = a[j];
                     cpy[i] = 0;
                     long amnt = curr / 14l;
                     for(int j = 0; j < 14; j++){
                            cpy[j] += amnt;
                     }
                     amnt = curr % 14;
                     for(int j = i + 1; j < i + 1 + amnt; j++){
                            cpy[j % 14]++;
                     }
                     for(int j = 0; j < 14; j++){
                            if(cpy[j] % 2 == 0)
                                   score += cpy[j];
                     }
                     max = Math.max(max, score);
              }
              System.out.println(max);
      }
}