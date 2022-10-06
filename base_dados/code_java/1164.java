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
 * @author kessido
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BTheHat solver = new BTheHat();
        solver.solve(1, in, out);
        out.close();
    }

    static class BTheHat {
        PrintWriter out;
        InputReader in;
        int n;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            n = in.NextInt();
            int desiredPair = -1;
            int result = query(1);
            if (result != 0) {
                int l = 2, r = 1 + n / 2;
                while (l < r) {
                    int m = (l + r) / 2;
                    int mRes = query(m);
                    if (mRes == 0) {
                        desiredPair = m;
                        break;
                    } else if (mRes == result) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
            } else {
                desiredPair = 1;
            }
            out.println("! " + desiredPair);
        }

        private int query(int i) {
            int iV = queryValue(i);
            int iN2V = queryValue(i + n / 2);
            if (iV < iN2V) {
                return -1;
            } else if (iV > iN2V) {
                return 1;
            }
            return 0;
        }

        private int queryValue(int i) {
            out.println("? " + i);
            out.flush();
            return in.NextInt();
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NextInt() {
            return Integer.parseInt(next());
        }

    }
}

