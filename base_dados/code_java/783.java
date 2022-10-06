import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class OlyaAndMagicalSquare {
    void solve() {
        long[] dp = new long[32];
        dp[0] = 0;
        for (int i = 1; i < 32; i++) {
            dp[i] = 4 * dp[i - 1] + 1;
        }
        
        int T = in.nextInt();
        L:
        while (T-- > 0) {
            int n = in.nextInt(); long k = in.nextLong();
            
            if (n > 31) {
                out.println("YES " + (n - 1));
                continue;
            }
            
            long tot = 0;
            for (int a = n - 1; a >= 0; a--) {
                k -= (1L << (n - a)) - 1;
                if (k < 0) break;
                if (k == 0) {
                    out.println("YES " + a);
                    continue L;
                }
                long limit = (1L << (n + 1 - a)) - 3;
                if (k <= tot || dp[a] > 0 && (k - tot + dp[a] - 1) / dp[a] <= limit) {
                    out.println("YES " + a);
                    continue L;
                }
                tot += dp[a] * limit;
            }
            out.println("NO");
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new OlyaAndMagicalSquare().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
