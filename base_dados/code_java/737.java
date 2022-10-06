import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
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
        ReaderFastIO in = new ReaderFastIO(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DConcatenatedMultiples solver = new DConcatenatedMultiples();
        solver.solve(1, in, out);
        out.close();
    }

    static class DConcatenatedMultiples {
        public void solve(int testNumber, ReaderFastIO in, PrintWriter out) {

            Map<Integer, Integer>[] mapMods = new HashMap[11];

            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = in.readArrayInt(n);

            for (int i = 0; i < 11; i++) {
                mapMods[i] = new HashMap<>();
            }

            for (int i = 0; i < n; i++) {
                int pot = getPot(a[i]);
                mapMods[pot].put(a[i] % k, mapMods[pot].getOrDefault(a[i] % k, 0) + 1);
            }

            long ct = 0;

            for (int i = 0; i < n; i++) {

                int ownPot = getPot(a[i]);
                long suffix = a[i] * 10L;
                for (int j = 1; j <= 10; j++) {

                    int mod = (int) (suffix % k);
                    int comMod = (k - mod) % k;
                    int qt = mapMods[j].getOrDefault(comMod, 0);

                    if (j == ownPot && (a[i] % k) == comMod) {
                        qt--;
                    }

                    ct += qt;

                    suffix = (suffix * 10L) % k;
                }

            }

            out.println(ct);
        }

        public int getPot(int x) {

            int ct = 0;

            while (x != 0) {
                x /= 10;
                ct++;
            }

            return ct;
        }

    }

    static class ReaderFastIO {
        BufferedReader br;
        StringTokenizer st;

        public ReaderFastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public ReaderFastIO(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readArrayInt(int n) {

            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }

            return array;
        }

    }
}

