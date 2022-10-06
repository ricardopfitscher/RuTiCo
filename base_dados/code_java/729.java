import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.ni(), K = in.ni();
            long mod = 998244353;
            long[][] dp = new long[n + 1][n + 1];
            for (int lim = 1; lim <= n; lim++) {
                long sum = 1;
                dp[0][lim] = 1;
                for (int i = 1; i <= n; i++) {
                    dp[i][lim] = (dp[i][lim] + sum) % mod;
                    sum = (sum + dp[i][lim]) % mod;
                    if (i >= lim)
                        sum = (sum - dp[i - lim][lim] + mod) % mod;
                }
            }
            long ans = 0;
            for (int k = 1; k < Math.min(K, n + 1); k++) {
                long h = dp[n][k] - dp[n][k - 1];
                int lim = K / k;
                if (K % k == 0)
                    lim--;
                if (lim > n)
                    lim = n;
                ans += dp[n][lim] * h % mod;
            }
            out.println(2 * ans % mod);
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

    }
}

