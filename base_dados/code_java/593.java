import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class SolutionB {
       
      public static void main(String args[])throws IOException{
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              int k = sc.nextInt();
              Set<Integer> set1 = new HashSet<Integer>();
              Set<Integer> set2 = new HashSet<Integer>();
              int a[] = new int[n];
              for(int i = 0; i < n; i++){
                     a[i] = sc.nextInt();
                     if(!set1.contains(a[i])){
                            set1.add(a[i]);
                     }else{
                            System.out.println(0);
                            return;
                     }
              }
              for(int i = 0; i < n; i++){
                     int b = a[i] & k;
                     if(b != a[i] && set1.contains(b)){
                            System.out.println(1);
                            return;
                     }
                     //if(!set2.contains(b)){
                            //set2.add(b);
                     //}else{
                       //     System.out.println(2);
                         //   return;
                     //}
              }
              for(int i = 0; i < n; i++){
                     int b = a[i] & k;
                     if(b != a[i] && set2.contains(b)){
                            System.out.println(2);
                            return;
                     }else{
                            set2.add(b);
                     }
              }
              System.out.println(-1);
      }
}