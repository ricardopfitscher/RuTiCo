import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author caoash
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EMilitaryProblem solver = new EMilitaryProblem();
        solver.solve(1, in, out);
        out.close();
    }

    static class EMilitaryProblem {
        ArrayList<Integer>[] adj;
        int[] sz;
        int[] preorder;
        int curPos;
        int[] pos;

        public void solve(int testNumber, FastScanner br, PrintWriter pw) {
            int n = br.nextInt();
            int q = br.nextInt();
            preorder = new int[n];
            sz = new int[n];
            pos = new int[n];
            curPos = 0;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
            for (int i = 1; i < n; i++) {
                int u = br.nextInt();
                u--;
                adj[u].add(i);
            }
            dfs(0);
            for (int i = 0; i < n; i++) {
                pos[preorder[i]] = i;
            }
            for (int i = 0; i < q; i++) {
                int u = br.nextInt();
                int k = br.nextInt();
                u--;
                if (sz[u] < k) {
                    pw.println("-1");
                } else {
                    pw.println(preorder[pos[u] + k - 1] + 1);
                }
            }
            pw.close();
        }

        public int dfs(int u) {
            preorder[curPos] = u;
            curPos++;
            sz[u]++;
            for (int e : adj[u]) {
                sz[u] += dfs(e);
            }
            return sz[u];
        }

    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastScanner.SpaceCharFilter filter;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

