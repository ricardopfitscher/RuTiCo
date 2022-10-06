import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

    private void solve() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = nextInt(), m = nextInt();
        boolean[][] used = new boolean[n + 1][m + 1];

        for (int j = 1; j <= (m + 1) / 2; j++) {
            int x1 = 1, x2 = n;
            for (int i = 1; i <= n; i++) {
                if (x1 <= n && !used[x1][j]) {
                    out.println(x1 + " " + j);
                    used[x1++][j] = true;
                }
                if (x2 > 0 && !used[x2][m - j + 1]) {
                    out.println(x2 + " " + (m - j + 1));
                    used[x2--][m - j + 1] = true;
                }
            }
        }

        out.close();
    }

    public static void main(String[] args) {
        new D().solve();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }
}
