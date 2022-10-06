/**
 * Created by Aminul on 3/14/2019.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

import static java.lang.Math.max;

public class E_2 {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt(), k = in.nextInt(), N = (int) 5e6 + 1;
        int left = 0, right = 0;
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            if (a[i] == k) left++;
        }
        int f[] = new int[N + 1];
        int ans = 0;
        for (int i = n; i >= 1; i--) {
            if (a[i] == k) left--;
            f[a[i]]++;
            f[a[i]] = max(f[a[i]], 1 + right);
            ans = max(ans, f[a[i]] + left);
            if (a[i] == k) right++;
        }
        pw.println(ans);
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}