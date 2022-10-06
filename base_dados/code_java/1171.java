import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author programajor
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        BigInteger mod = new BigInteger("1000000007");

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            BigInteger x = new BigInteger(in.next());
            BigInteger k = new BigInteger(in.next());
            if (x.longValue() == 0) {
                out.print(x);
                return;
            }
            BigInteger pow = powerWithMod(new BigInteger("2"), k);
            BigInteger current = x.mod(mod).multiply(pow).mod(mod);
            BigInteger result = current.multiply(new BigInteger("2")).mod(mod)
                    .subtract(pow.subtract(new BigInteger("1")).mod(mod))
                    .mod(mod);
            out.print(result);
        }

        BigInteger powerWithMod(BigInteger base, BigInteger exponent) {
            if (exponent.longValue() == 0) {
                return new BigInteger("1");
            }
            BigInteger temp = powerWithMod(base, exponent.divide(new BigInteger("2")));
            BigInteger term = temp.mod(mod);
            if (exponent.mod(new BigInteger("2")).intValue() == 0) {
                return term.multiply(term.mod(mod)).mod(mod);
            } else {
                return term.multiply(term.mod(mod)).multiply(base.mod(mod)).mod(mod);
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

    }
}

