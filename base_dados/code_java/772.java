import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            Debug debug = new Debug();
            int n = in.nextInt();
            int K = in.nextInt();

            List<Integer>[] g = GraphUtils.nextU(in, n, n - 1, true);
            int[] center = GraphUtils.getCenter(g);
            if (center.length == 2) {
                out.println("No");
                return;
            }

            int[][] pars = GraphUtils.parents3(g, center[0]);
            int[] par = pars[0], ord = pars[1], depth = pars[2];
            int[] deg = new int[n];
            for (int i = 0; i < n; ++i) deg[i] = g[i].size();

            if (deg[center[0]] < 3) {
                out.println("No");
                return;
            }

            // all leaves depth = K
            for (int i = 0; i < n; ++i) {
                if (deg[i] == 1) {
                    if (depth[i] != K) {
                        out.println("No");
                        return;
                    }
                } else if (i != center[0]) {
                    if (deg[i] < 4) {
                        out.println("No");
                        return;
                    }
                }
            }
            out.println("Yes");
        }

    }

    static class GraphUtils {
        public static List<Integer>[] nextU(FastReader in, int n, int m, boolean oneIndexed) {
            int diff = oneIndexed ? 1 : 0;
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt() - diff;
                int v = in.nextInt() - diff;
                g[u].add(v);
                g[v].add(u);
            }
            return g;
        }

        public static int[][] parents3(List<Integer>[] g, int root) {
            int n = g.length;
            int[] par = new int[n];
            ArrayUtils.fill(par, -1);

            int[] depth = new int[n];
            depth[0] = 0;

            int[] q = new int[n];
            q[0] = root;
            for (int p = 0, r = 1; p < r; p++) {
                int cur = q[p];
                for (int nex : g[cur]) {
                    if (par[cur] != nex) {
                        q[r++] = nex;
                        par[nex] = cur;
                        depth[nex] = depth[cur] + 1;
                    }
                }
            }
            return new int[][]{par, q, depth};
        }

        public static int[] getCenter(List<Integer>[] g) {
            int n = g.length;
            int[] q = new int[n];
            int[] deg = new int[n];
            int p = 0;
            for (int i = 0; i < n; i++) {
                deg[i] = g[i].size();
                if (g[i].size() <= 1) { // < for n=1
                    q[p++] = i;
                }
            }
            int bound = p == n ? 0 : p;
            for (int z = 0; z < p; z++) {
                if (bound == z && p < n) bound = p;
                int cur = q[z];
                deg[cur]--;
                for (int e : g[cur]) {
                    if (--deg[e] == 1) q[p++] = e;
                }
            }
            assert p == n;
            assert bound >= n - 2 && bound < n;
            if (bound == n - 2) {
                return new int[]{q[n - 2], q[n - 1]};
            } else {
                return new int[]{q[n - 1]};
            }
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class ArrayUtils {
        public static void fill(int[] array, int value) {
            Arrays.fill(array, value);
        }

    }

    static class Debug {
        PrintWriter out;
        boolean oj;
        boolean system;
        long timeBegin;
        Runtime runtime;

        public Debug(PrintWriter out) {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            this.out = out;
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

        public Debug() {
            system = true;
            oj = System.getProperty("ONLINE_JUDGE") != null;
            OutputStream outputStream = System.out;
            this.out = new PrintWriter(outputStream);
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

    }
}

