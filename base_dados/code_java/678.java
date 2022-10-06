
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class Main {
    static boolean LOCAL = System.getSecurityManager() == null;


    static class TaskA {

        int n, m;
        int []a, b;

        void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < n; i++) b[i] = in.nextInt();
            double l = 0, r = 1e9 + 1;
            while (abs(l - r) > 1e-6) {
                double m = (l + r) / 2;
                if (can(m))
                    r = m;
                else
                    l = m;
            }
            if (r == 1e9 + 1) out.println(-1);
            else out.println(l);
        }

        boolean can(double fuel) {
            for (int i = 0; i < n; i++) {
                if (fuel < 0)
                    return false;
                fuel -= (m + fuel) / a[i];
                fuel -= (m + fuel) / b[(i+1)%n];
            }
            if (fuel < 0) return false;
            else return true;
        }

        void debug(Object...os) {
            System.err.println(deepToString(os));
        }
    }


    public static void main(String[] args) {
        if (LOCAL) {
            try {
                System.setIn(new FileInputStream("in.txt"));
            } catch (Throwable e) {
                LOCAL = false;
            }
        }
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.run(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
