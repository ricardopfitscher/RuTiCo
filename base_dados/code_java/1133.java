import java.io.*;
import java.util.*;

public class A_KingEscape {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
    }

    private static class Solver {
        private void solve(InputReader inp, PrintWriter out) {
            int n = inp.nextInt();
            int Qx = inp.nextInt(), Qy = inp.nextInt();
            int Kx = inp.nextInt(), Ky = inp.nextInt();
            int Tx = inp.nextInt(), Ty = inp.nextInt();
            if (((Kx < Qx && Tx < Qx) || (Kx > Qx && Tx > Qx)) && ((Ky < Qy && Ty < Qy) || (Ky > Qy && Ty > Qy))) out.println("YES");
            else out.println("NO");
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}