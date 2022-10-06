import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DEhabIEsheOdnaOcherednayaZadachaNaXor solver = new DEhabIEsheOdnaOcherednayaZadachaNaXor();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabIEsheOdnaOcherednayaZadachaNaXor {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int c = 0;
            int d = 0;

            int prevSign = 0;
            int nextSign;
            boolean zeroOut = true;
            for (int i = 29; i >= 0; i--) {
                if (zeroOut) {
                    print(c, d, out);
                    prevSign = read(in);
                }

                print((1 << i) | c, (1 << i) | d, out);
                nextSign = read(in);

                if (prevSign == nextSign) {
                    zeroOut = false;

                    print((1 << i) | c, d, out);
                    nextSign = read(in);

                    if (nextSign < 0) {
                        c = (1 << i) | c;
                        d = (1 << i) | d;
                    }
                } else {
                    zeroOut = true;

                    if (nextSign < 0) c = (1 << i) | c;
                    else d = (1 << i) | d;
                }
            }

            out.printf("! %d %d", c, d);
            out.flush();
        }

        private void print(int c, int d, PrintWriter out) {
            out.printf("? %d %d\n", c, d);
            out.flush();
        }

        private int read(InputReader in) {
            return in.nextInt();
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

