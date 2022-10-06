import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(; T > 0; T--) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
            int m1 = 1, m2 = 1;
            for(int i = 0; i < n; i++) {
                if(arr[i] >= m1) {
                    m2 = m1;
                    m1 = arr[i];
                } else if (arr[i] >= m2) {
                    m2 = arr[i];
                }
            }
            System.out.println(Math.min(Math.min(m1, m2) - 1, n - 2));
        }
    }
}