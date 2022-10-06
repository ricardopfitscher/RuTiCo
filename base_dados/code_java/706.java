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
        BObtainingTheString solver = new BObtainingTheString();
        solver.solve(1, in, out);
        out.close();
    }

    static class BObtainingTheString {
        public void solve(int testNumber, FastScanner br, PrintWriter pw) {
            int n = br.nextInt();
            String s = br.nextString();
            String t = br.nextString();
            char[] sarr = new char[n];
            char[] tarr = new char[n];
            int[] sAppear = new int[26];
            int[] tAppear = new int[26];
            for (int i = 0; i < s.length(); i++) {
                sarr[i] = s.charAt(i);
                tarr[i] = t.charAt(i);
                sAppear[s.charAt(i) - 'a']++;
                tAppear[t.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (sAppear[i] != tAppear[i]) {
                    pw.println(-1);
                    pw.close();
                }
            }
            ArrayList<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                char curr = tarr[i];
                for (int j = i + 1; j < n; j++) {
                    if (sarr[j] == curr) {
                        for (int k = j; k > i; k--) {
                            ans.add(k);
                            char temp = sarr[k - 1];
                            sarr[k - 1] = sarr[k];
                            sarr[k] = temp;
                        }
                        break;
                    }
                }
            }
            pw.println(ans.size());
            for (int e : ans) {
                pw.print(e + " ");
            }
            pw.close();
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

