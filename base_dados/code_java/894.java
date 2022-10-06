import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author gaidash
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            final int SIZE = 256;
            final int UNDEF = -1;

            int nPixels = in.nextInt();
            int groupSize = in.nextInt();
            int[] a = in.nextIntArray(nPixels);
            boolean[] exists = new boolean[SIZE];
            int[] left = new int[SIZE];
            int[] right = new int[SIZE];
            int[] ret = new int[nPixels];
            Arrays.fill(ret, UNDEF);

            for (int i = 0; i < nPixels; i++) {
                for (int p = 0; p < SIZE; p++) {
                    if (exists[p] && left[p] <= a[i] && a[i] <= right[p]) {
                        ret[i] = left[p];
                        left[a[i]] = left[p];
                        right[a[i]] = right[p];
                        break;
                    }
                }
                if (ret[i] == UNDEF) {
                    int l = Math.max(a[i] - groupSize + 1, 0);
                    int r = l + groupSize - 1;
                    for (int p = a[i] - 1; p >= 0; p--) {
                        if (exists[p]) {
                            if (p >= l) {
                                int d = p - l;
                                l = p + 1;
                                r += d + 1;
                            }
                            if (right[p] >= l) {
                                right[p] = l - 1;
                            }
                        }
                    }
                    for (int p = a[i] + 1; p < SIZE; p++) {
                        if (exists[p] && left[p] <= r) {
                            r = left[p] - 1;
                        }
                    }
                    left[a[i]] = l;
                    right[a[i]] = r;
                    ret[i] = l;
                }
                exists[a[i]] = true;
            }
//        for (int p : a) {
//            System.out.println("Segment for pixel " + p + " = " + "(" + left[p] + " , " + right[p] + ")");
//        }

            out.print(ret);
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

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void close() {
            writer.close();
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

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

