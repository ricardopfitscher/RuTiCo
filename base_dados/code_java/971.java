import java.util.*;
 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	 int[][] x = new int [200010][10];
     String a = sc.nextLine(); 
     String b = sc.nextLine(); 
 	  int n = a.length();
	  int m = b.length();
       for (int i = 1; i <= m; i++) {
         for (int j = 0; j < 2; j++) {
           x[i][j] = x[i - 1][j];
         }
         ++x[i][b.charAt(i - 1) - '0'];
       }
       long res = 0;
        for (int i = 0, c; i < n; i++) {
          c = a.charAt(i) - '0';
           for (int j = 0; j < 2; j++) {
             res += Math.abs(c - j) * (x[m - n + i + 1][j] - x[i][j]);
           }
        }
         System.out.println(res);
  }
}