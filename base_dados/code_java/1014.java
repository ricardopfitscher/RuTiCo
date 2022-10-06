import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < m; c++) {
                fw.println((r + 1) + " " + (c + 1));
                fw.println((n - r) + " " + (m - c));
            }
        }
        if (n % 2 != 0) {
            int r = n / 2;
            for (int c = 0; c < m / 2; c++) {
                fw.println((r + 1) + " " + (c + 1));
                fw.println((r + 1) + " " + (m - c));
            }
            if (m % 2 != 0) fw.println((r + 1) + " " + (m / 2 + 1));
        }
        fw.close();
    }
}
