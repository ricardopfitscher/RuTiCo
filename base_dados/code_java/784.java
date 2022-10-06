/*
Keep solving problems.
*/

import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    int n;
    int m;
    char[][] mat;
    long base = 397;
    void solve() throws IOException {
        n = nextInt();
        m = nextInt();
        mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = nextString().toCharArray();
        }

        int alpha = 26;
        long[] pow = new long[alpha];
        pow[0] = 1;
        for (int i = 1; i < alpha; i++) {
            pow[i] = pow[i - 1] * base % MOD;
        }

        long res = 0;
        for (int l = 0; l < m; l++) {
            //[l, r]
            long[] hash = new long[n];
            long[] mask = new long[n];
            for (int r = l; r < m; r++) {
                for (int i = 0; i < n; i++) {
                    hash[i] += pow[mat[i][r] - 'a'];
                    hash[i] %= MOD;
                    mask[i] = mask[i] ^ (1L << (mat[i][r] - 'a'));
                }

                int start = 0;
                while (start < n) {
                    if ((mask[start] & (mask[start] - 1)) != 0) {
                        start++;
                        continue;
                    }

                    int end = start;
                    List<Long> l1 = new ArrayList<>();
                    while (end < n && (mask[end] & (mask[end] - 1)) == 0) {
                        l1.add(hash[end]);
                        end++;
                    }

                    start = end;
                    res += manacher(l1);
                }
            }
        }

        outln(res);
    }

    long manacher(List<Long> arr) {
        int len = arr.size();
        long[] t = new long[len * 2 + 3];
        t[0] = -1;
        t[len * 2 + 2] = -2;
        for (int i = 0; i < len; i++) {
            t[2 * i + 1] = -3;
            t[2 * i + 2] = arr.get(i);
        }

        t[len * 2 + 1] = -3;
        int[] p = new int[t.length];
        int center = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        long res = 0;
        for (int i = 0; i < 2 * len; i++) {
            int parLength = p[i + 2];
            if (i % 2 == 0) {
                res += (parLength + 1) / 2;
            }
            else {
                res += parLength / 2;
            }
        }

        return res;
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    long gcd(long a, long b) {
        while(a != 0 && b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        outln(String.format("%.9f%n", val));
    }
    public CFA() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFA();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}