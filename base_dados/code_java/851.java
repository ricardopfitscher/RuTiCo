import java.util.*;
import java.io.*;
public class Waw{
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i] = sc.nextLong();
        long[] p = new long[n];
        p[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--){
            if(a[i]<p[i+1]) p[i] = p[i+1]-1;
            else p[i] = a[i];
        }
        long max = p[0];
        long res = p[0] - a[0];
        for(int i=1;i<n;i++){
            if(max < p[i]) max = p[i];
            res += max - a[i];
        }
        System.out.println(res);
    }
}