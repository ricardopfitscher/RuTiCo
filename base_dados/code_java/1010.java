import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int q = fr.nextInt();
        int[] aa = new int[n - 1];
        int[] ab = new int[n - 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) dq.addLast(fr.nextInt());
        for (int i = 0; i < n - 1; i++) {
            int a = dq.removeFirst();
            int b = dq.removeFirst();
            aa[i] = a;
            ab[i] = b;
            int mi = Math.min(a, b);
            int ma = Math.max(a, b);
            dq.addFirst(ma);
            dq.addLast(mi);
        }
        int fm = dq.removeFirst();
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) arr[i] = dq.removeFirst();
        while (q-- > 0) {
            long m = fr.nextLong() - 1;
            if (m < n - 1) {
                System.out.println(aa[(int) m] + " " + ab[(int) m]);
            } else {
                m = m % (n - 1);
                System.out.println(fm + " " + arr[(int) m]);
            }
        }
    }
}
