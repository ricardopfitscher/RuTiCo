import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author El-Bishoy
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        D2C982_cut_them_all solver = new D2C982_cut_them_all();
        solver.solve(1, in, out);
        out.close();
    }

    static class D2C982_cut_them_all {
        int n;
        ArrayList<Integer>[] adj;
        int[] sizes = new int[n];
        boolean[] visited = new boolean[n];

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            n = in.nextInt();
            if ((n & 1) == 1) {
                out.println(-1);
                return;
            }
            sizes = new int[n];
            visited = new boolean[n];
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 1; i < n; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }

            int root = 0;
            for (int i = 1; i < n; i++) {
                if (adj[i].size() > adj[root].size()) {
                    root = i;
                }
            }

            dfs(root);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((sizes[i] & 1) == 0) cnt++;
            }
            out.println(cnt - 1);

        }

        int dfs(int u) {

            visited[u] = true;
            int cnt = 1;

            for (int w : adj[u])
                if (!visited[w])
                    cnt += dfs(w);

            sizes[u] = cnt;
            return cnt;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

