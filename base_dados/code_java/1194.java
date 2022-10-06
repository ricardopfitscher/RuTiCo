import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt(), v = fr.nextInt();
        if (v >= n)
            out.println(n - 1);
        else
            out.println((n - v) * (n - v + 1) / 2 + v - 1);
        out.flush();
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

        int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[] memset(int n, int val) {
            int ar[] = new int[n];
            Arrays.fill(ar, val);
            return ar;
        }
    }
}