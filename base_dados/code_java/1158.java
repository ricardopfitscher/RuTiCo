import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    FastScanner in;
    PrintWriter out;

    void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

    public static void main(String[] args) {
        new Main().run();
    }

    void solve() {
        int t = in.nextInt();

        for (int sdfsdf = 0; sdfsdf < t; sdfsdf++) {
            long n = in.nextLong();
            long k = in.nextLong();

            if (n == 1) {
                if (k == 1)  {
                    out.println("YES 0");
                } else {
                    out.println("NO");
                }
                continue;
            }

            if (k == 3) {
                if (n == 2) {
                    out.println("NO");
                } else {
                    out.println("YES " + (n - 1));
                }
                continue;
            }

            long cuts = 1;
            long squares = 4;
            int zoom = 1;

            while (k > cuts + squares) {
                cuts += squares;
                squares *= 4;
                zoom++;
            }

            if (zoom > n) {
                out.println("NO");
                continue;
            }

            if (zoom == n && k > cuts) {
                out.println("NO");
                continue;
            }

            long current_cuts = k - cuts;

            if (current_cuts > squares - (2L * Math.sqrt(squares) - 1L)) {
                out.println("YES " + (n - zoom - 1L));
            } else {
                out.println("YES " + (n - zoom));
            }
        }
    }
}
