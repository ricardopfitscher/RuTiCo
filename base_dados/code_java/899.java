import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DBookshelves solver = new DBookshelves();
        solver.solve(1, in, out);
        out.close();
    }

    static class DBookshelves {
        long[] arr;
        long[] pre;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int k = in.scanInt();
            long arr[] = new long[n + 1];
            for (int i = 1; i <= n; i++) arr[i] = in.scanLong();
            out.println(findIt(arr, k));

        }

        long findIt(long arr[], int k) {
            this.arr = arr;
            pre = new long[arr.length];
            for (int i = 1; i < this.arr.length; i++) pre[i] = this.arr[i] + pre[i - 1];
            long answer = 0;
            for (int bit = 63; bit >= 0; bit--)
                if (is_poi(answer | (1l << bit), k)) answer |= (1l << bit);
            return answer;

        }

        boolean is_poi(long num, int k) {
            int n = arr.length - 1;
            boolean dp[][] = new boolean[n + 1][k + 1];
            dp[0][0] = true;
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int left = 0; left < j; left++) {
                        dp[j][i] |= (dp[left][i - 1] && (((pre[j] - pre[left]) & num) == num));
                    }
                }
            }
            return dp[n][k];
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public long scanLong() {
            long I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

    }
}

