import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp;
    private static int[] a;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        a = new int[n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            dp[i][i] = 1;
        }

        dp(0, n - 1);

        out.println(dp[0][n - 1]);

        out.flush();
        in.close();
        out.close();
    }

    private static int dp(int from, int to) {
        if (dp[from][to] > 0) return dp[from][to];
        if (from > to) {
            return 1;
        }

        dp[from][to] = Integer.MAX_VALUE;
        for (int i = from; i < to; i++) {
            int now = dp(from, i) + dp(i + 1, to);
            if (dp[from][to] > now) {
                dp[from][to] = now;
            }
        }
        if (a[from] == a[to]) {
            int now = dp(from + 1, to - 1);
            if (dp[from][to] > now) {
                dp[from][to] = now;
            }
        }

        return dp[from][to];
    }

    private static int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int now : values) {
            if (max < now) max = now;
        }
        return max;
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}