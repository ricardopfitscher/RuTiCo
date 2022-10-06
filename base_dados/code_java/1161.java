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
 * @author Pradyumn
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
        FastReader in;
        PrintWriter out;
        int n;

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
            n = in.nextInt();
            if (n % 4 != 0) {
                out.println("! -1");
                return;
            }
            int low = 0;
            int high = n >> 1;
            if (BValue(low) == 0) {
                out.println("! " + (low + 1));
                return;
            }
            int fSign = Integer.signum(BValue(low));
            while (high - low > 1) {
                int mid = (high + low) >> 1;
                int mSign = Integer.signum(BValue(mid));
                if (mSign == 0) {
                    out.println("! " + (mid + 1));
                    return;
                }
                if (mSign == -fSign) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
            out.println("! -1");
        }

        public int BValue(int index) {
            out.println("? " + (index + 1));
            out.flush();
            int f = in.nextInt();
            out.println("? " + (index + 1 + (n >> 1)));
            out.flush();
            int s = in.nextInt();
            return f - s;
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
}

