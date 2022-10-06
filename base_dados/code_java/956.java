import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Ribhav
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CGlassCarving solver = new CGlassCarving();
        solver.solve(1, in, out);
        out.close();
    }

    static class CGlassCarving {
        public void solve(int testNumber, FastReader s, PrintWriter out) {
            TreeMap<Long, Integer> mapH = new TreeMap<>();
            TreeMap<Long, Integer> mapV = new TreeMap<>();
            TreeMap<Long, Integer> hDiff = new TreeMap<>();
            TreeMap<Long, Integer> vDiff = new TreeMap<>();
            long width = s.nextInt();
            long height = s.nextInt();
            mapH.put(0L, 1);
            mapV.put(0L, 1);
            mapV.put(width, 1);
            mapH.put(height, 1);
            vDiff.put(width, 1);
            hDiff.put(height, 1);
            long maxV = height;
            long maxH = width;
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                char ch = s.nextCharacter();
                long cut = s.nextInt();
                if (ch == 'H') {
                    Long next = mapH.higherKey(cut);
                    Long prev = mapH.lowerKey(cut);
                    Long diff = next - prev;
                    int freq = hDiff.get(diff);
                    if (freq == 1) {
                        hDiff.remove(diff);
                    } else {
                        hDiff.put(diff, freq - 1);
                    }
                    hDiff.put(next - cut, hDiff.getOrDefault(next - cut, 0) + 1);
                    hDiff.put(cut - prev, hDiff.getOrDefault(cut - prev, 0) + 1);
                    mapH.put(cut, mapH.getOrDefault(cut, 0) + 1);
                } else {
                    Long next = mapV.higherKey(cut);
                    Long prev = mapV.lowerKey(cut);
                    Long diff = next - prev;
                    int freq = vDiff.get(diff);
                    if (freq == 1) {
                        vDiff.remove(diff);
                    } else {
                        vDiff.put(diff, freq - 1);
                    }
                    vDiff.put(next - cut, vDiff.getOrDefault(next - cut, 0) + 1);
                    vDiff.put(cut - prev, vDiff.getOrDefault(cut - prev, 0) + 1);
                    mapV.put(cut, mapV.getOrDefault(cut, 0) + 1);
                }

                out.println(hDiff.lastKey() * vDiff.lastKey());
            }
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

