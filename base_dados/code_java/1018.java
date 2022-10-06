import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

    private void solve() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = nextInt(), m = nextInt(), u = 1, d = n;

        while (u < d) {
            for (int i = 1; i <= m; i++) {
                out.println(u + " " + i);
                out.println(d + " " + (m - i + 1));
            }
            u++;
            d--;
        }
        if (u == d) {
            int l = 1, r = m;
            while (l < r) {
                out.println(u + " " + l++);
                out.println(d + " " + r--);
            }
            if (l == r) out.println(u + " " + l);
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
