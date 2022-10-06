import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        int n;
        int n2;
        InputReader in;
        PrintWriter out;

        public void solve(InputReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
            n = in.readInt();
            n2 = n/2;

            int res = find();
            out.print("! ");
            out.println(res);
        }

        public int find() {
            if (n%4 != 0) return -1;
            int c = compare(0);
            if (c == 0) return 1;
            int s = 1;
            int f = n2-1;
            if (c > 0) {
                s = n2+1;
                f = n-1;
            }
            while (s <= f) {
                int m = (s+f)/2;
                int v = compare(m);
                if (v == 0) return m+1;
                else if (v < 0) s = m+1;
                else f = m-1;
            }
            return -1;
        }

        public int compare(int z) {
            out.print("? ");
            out.println(z+1);
            out.flush();
            int r1 = in.readInt();
            out.print("? ");
            out.println((z+n2)%n+1);
            out.flush();
            int r2 = in.readInt();
            return r1-r2;
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            this.reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String read() {
            try {
                if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return tokenizer.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(read());
        }

        public long readLong() {
            return Long.parseLong(read());
        }

        public void readIntArrays(int[]... arrays) {
            for (int i = 0; i < arrays[0].length; i++) {
                for (int j = 0; j < arrays.length; j++) {
                    arrays[j][i] = readInt();
                }
            }
        }
    }

}