import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main2 {

    private FastScanner scanner = new FastScanner();

    public static void main(String[] args) {
        new Main2().solve();
    }

    private void solve() {

        String a = scanner.nextLine(), b = scanner.nextLine();

        int n = b.length(), m = a.length();

        int p[] = new int[n];

        p[0] = b.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + (b.charAt(i) - '0');
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            int cur = a.charAt(i) - '0';

            int cnt = p[n - m + i] - (i > 0 ? p[i - 1] : 0);

            if (cur == 0) {
                ans += cnt;
            } else {
                ans += n - m + 1  - cnt;
            }
        }

        System.out.println(ans);

    }


    class Pair {
        int c, f;
    }

    class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();

        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Integer[] nextA(int n) {
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            return a;
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