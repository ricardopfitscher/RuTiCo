import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author pandusonu
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // out.print("Case #" + testNumber + ": ");
            int n = in.readInt();
            int[] a = in.readIntArray(n);
            int[][] sol = new int[n][n];
            for (int i = 0; i < n; i++) {
                sol[0][i] = a[i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    sol[i][j] = sol[i - 1][j] ^ sol[i - 1][j + 1];
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    sol[i][j] = Math.max(sol[i][j], Math.max(sol[i - 1][j], sol[i - 1][j + 1]));
                }
            }
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int l = in.readInt() - 1;
                int r = in.readInt() - 1;
                out.println(sol[r - l][l]);
            }
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            try {
                if (curChar >= numChars) {
                    curChar = 0;
                    numChars = stream.read(buf);
                    if (numChars <= 0)
                        return -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return buf[curChar++];
        }

        public int readInt() {
            return (int) readLong();
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new RuntimeException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public int[] readIntArray(int size) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = readInt();
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

