import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class EhabAndAComponentChoosingProblem {
    
    long INF = (long) 1e18;
    
    int n;
    int[] a;
    
    int[][] G;
    
    void solve() {
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] fr = new int[n - 1], to = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            fr[i] = in.nextInt() - 1;
            to[i] = in.nextInt() - 1;
        }
        G = build_graph(n, fr, to);
        
        int[][] ret = bfs(G, 0);
        int[] par = ret[0], ord = ret[2];
        
        long best = -INF;
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int u = ord[i];
            dp[u] = a[u];
            for (int v : G[u]) {
                if (v != par[u]) {
                    if (dp[v] > 0) dp[u] += dp[v];
                }
            }
            best = Math.max(best, dp[u]);
        }
        
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            int u = ord[i];
            dp[u] = a[u];
            for (int v : G[u]) {
                if (v != par[u]) {
                    if (dp[v] > 0) dp[u] += dp[v];
                }
            }
            if (dp[u] == best) {
                dp[u] = -INF;
                k++;
            }
        }
        
        out.printf("%d %d%n", best * k, k);
    }
    
    int[][] bfs(int[][] G, int root) {
        int n = G.length;
        
        int[] par = new int[n];
        Arrays.fill(par, -1);
        
        int[] dep = new int[n];
        dep[root] = 0;
        
        int[] qu = new int[n];
        qu[0] = root;
        for (int l = 0, r = 1; l < r; l++) {
            int u = qu[l];
            for (int v : G[u]) {
                if (v != par[u]) {
                    qu[r++] = v;
                    par[v] = u;
                    dep[v] = dep[u] + 1;
                }
            }
        }
        
        return new int[][]{par, dep, qu};
    }
    
    int[][] build_graph(int n, int[] from, int[] to) {
        int[][] G = new int[n][];
        int[] cnt = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) G[i] = new int[cnt[i]];
        for (int i = 0; i < from.length; i++) {
            G[from[i]][--cnt[from[i]]] = to[i];
            G[to[i]][--cnt[to[i]]] = from[i];
        }
        return G;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new EhabAndAComponentChoosingProblem().solve();
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
