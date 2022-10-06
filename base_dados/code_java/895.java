import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Main {

    private FastScanner scanner = new FastScanner();

    public static void main(String[] args) {
        new Main().solve();
    }

    private List<Integer>[] gr = new ArrayList[1000_000+5];
    private int dp[][] = new int[21][1000_000+5];
    private boolean used[] = new boolean[1000_000+5];

    void init(int v, int p) {
        Stack<Integer> st = new Stack<>();
        st.push(v);
        st.push(p);
        while (!st.isEmpty()) {
            p = st.pop();
            v = st.pop();
            used[v] = true;

            dp[0][v] =  p;
            for (int i = 1; i <= 20; i++) {
                if (dp[i - 1][v] != -1) {
                    dp[i][v] = dp[i - 1][dp[i - 1][v]];
                }
            }

            for (int next : gr[v]) {
                if (!used[next]) {
                    st.push(next);
                    st.push(v);
                }
            }

        }
    }


    private void solve() {
        int n = scanner.nextInt(), k = scanner.nextInt();
        boolean[] ans = new boolean[1000_000 + 5];

        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i ++) {
            int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
            gr[u].add(v);
            gr[v].add(u);
        }

        k = n - k - 1;
        ans[n - 1] = true;

        init(n - 1 , n - 1);

        int t, d, next;
        for (int i = n - 2; i >= 0; i--) {
            t = i;
            d = 1;
            if (ans[i]) {
                continue;
            }
            for (int j = 20; j >= 0; j--){
                next = dp[j][t];
                if (next != -1 && !ans[next]) {
                    t = next;
                    d +=  1 << j;
                }
            }

            if (d <= k) {
                k -=d;
                t = i;

                while (!ans[t]) {
                    ans[t] = true;
                    t = dp[0][t];
                }
            }
            if (k == 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            if (!ans[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}