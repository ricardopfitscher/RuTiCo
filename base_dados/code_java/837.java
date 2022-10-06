import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.Math.ceil;

public class practise {
    static final int N = 31;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out,true);
    static long c[] = new long[N];
    static int w[] = new int[N];
    public static void main(String[] args) {
        w[0] = 1;
        for(int i=1;i<N;i++) w[i] = w[i-1]*2;
        int n = sc.nextInt(); int l = sc.nextInt();
        for(int i=0;i<N;i++) c[i] = Long.MAX_VALUE;
        for(int i=0;i<n;i++) c[i] = sc.nextInt();
        for(int i=1;i<N;i++) {
            c[i] = min(c[i-1]*2,c[i]);
        }
        long ans = 0;
        for(int i=0;i<N;i++) {
            if( (l&w[i])!=0) {
                ans += c[i];
            }
        }
        long m = 0;
        for(int i=N - 1;i>=0;i--) {
            if((l&w[i])!=0) {
                m += c[i];
            } else {
                ans = min(ans,m+c[i]);
            }
        }
        out.println(ans);
    }

    static long min(long a,long b) {
        return a<b?a:b;
    }
}
