import java.util.*;
import java.io.*;
public class A{
       
       public static void main(String args[]){
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              int ans = 0;
              for(int i = 1; i <= n; i++){
                     ans += ((i*2) <= n) ? i : n-i+1;
              }
              System.out.println(ans);
       }
}