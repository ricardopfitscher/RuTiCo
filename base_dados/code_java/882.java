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

        int n = scanner.nextInt();


        int a[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = i;
        }

        int l = -1, r = -1;

        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        int maxr = -1, maxi = -1;
        for (int i = 0; i < n; i++) {
            if (a[i][1] <= maxr) {
                l = a[i][2] + 1;
                r = maxi + 1;
                break;
            }
            if (a[i][1] > maxr) {
                maxi = a[i][2];
                maxr = a[i][1];
            }
        }

        System.out.println(l + " " + r);


    }

    boolean check(int cnt[][], int[] tcnt, int mid) {
        boolean ok = true;

        for (int j = 0; j < 27; j++) {
            if (cnt[mid][j] < tcnt[j]) {
                ok = false;
            }
        }
        return ok;
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