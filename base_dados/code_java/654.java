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
 * @author Priya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        contest1 solver = new contest1();
        solver.solve(1, in, out);
        out.close();
    }

    static class contest1 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            String s = "";
            int count = 0;

            int copya = a;
            int copyb = b;
            int change = 0;

            if (x == 1) {
                if (copya > copyb) {
                    while (a > 0) {
                        s += '0';
                        a--;
                    }
                    while (b > 0) {
                        s += '1';
                        b--;
                    }
                } else {
                    while (b > 0) {
                        s += '1';
                        b--;
                    }
                    while (a > 0) {
                        s += '0';
                        a--;
                    }

                }

            } else {
                // out.println("got in");
                if (copya > copyb) {
                    while (change <= x - 1) {
                        if (change % 2 == 0) {
                            s += '0';
                            change++;
                            a--;
                        } else {
                            s += '1';
                            change++;
                            b--;
                        }
                    }

                } else if (copyb >= copya) {
                    //out.println("got in in ");
                    while (change <= x - 1) {
                        //out.println(change+" hmm");
                        if (change % 2 == 0) {
                            s += '1';
                            change++;
                            b--;
                        } else {
                            s += '0';
                            change++;
                            a--;
                        }
                    }
                }

                char z = s.charAt(s.length() - 1);
                //out.println(z+" hm");
                if (z == '0') {
                    while (a > 0) {
                        s += '0';
                        a--;
                    }
                    while (b > 0) {
                        s += '1';
                        b--;
                    }
                } else {
                    while (b > 0) {
                        s += '1';
                        b--;
                    }
                    while (a > 0) {
                        s += '0';
                        a--;
                    }
                }
            }
            out.println(s);
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
}

