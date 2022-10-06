import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        a = sc.nextIntArray(n);
        long inversions = divide(0, n - 1);
//        out.println(inversions);
//        System.err.println(Arrays.toString(a));
        if (n == 5) out.println("Petr");
        else {
            if (n % 2 == 0) out.println(inversions % 2 == 0 ? "Petr" : "Um_nik");
            else out.println(inversions % 2 != 0 ? "Petr" : "Um_nik");
        }
        out.flush();
        out.close();
    }

    static long divide(int b, int e) {
        if (b == e) return 0;
        long cnt = 0;
        int mid = b + e >> 1;
        cnt += divide(b, mid);
        cnt += divide(mid + 1, e);
        cnt += merge(b, mid, e);
        return cnt;
    }

    static long merge(int b, int mid, int e) {
        long cnt = 0;
        int len = e - b + 1;
        int[] tmp = new int[len];
        int i = b, j = mid + 1;
        for (int k = 0; k < len; k++) {
            if (i == mid + 1 || (j != e + 1 && a[i] > a[j])) {
                tmp[k] = a[j++];
                cnt += (mid + 1 - i);
            } else tmp[k] = a[i++];
        }
        for (int k = 0; k < len; k++)
            a[b + k] = tmp[k];
        return cnt;
    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }


        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }
}