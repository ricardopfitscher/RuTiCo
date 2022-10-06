import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A {
    static MyScanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws Throwable {
        sc = new MyScanner();
        pw = new PrintWriter(System.out);

        n = sc.nextInt();
        T = sc.nextLong();
        p = new int[n];
        l = new int[n];
        x = new int[n];
        t = new int[n];
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            t[i] = sc.nextInt();
        adj[0] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            adj[i] = new ArrayList<>();
            p[i] = sc.nextInt() - 1;
            l[i] = sc.nextInt();
            adj[p[i]].add(i);
        }

        ftCnt = new long[N];
        ftSum = new long[N];
        ans = new long[n];

        dfs(0);
        pw.println(ans[0]);

        pw.flush();
        pw.close();
    }

    static int n;
    static long T;
    static int[] p, l, x, t;
    static ArrayList<Integer>[] adj;

    static long[] ans;

    static void dfs(int u) {
        update(t[u], x[u], 1L * x[u] * t[u]);
        ans[u] = getMaxCnt();
        long[] vals = {-1, -1, -1};
        for (int v : adj[u]) {
            T -= 2 * l[v];
            dfs(v);
            vals[0] = ans[v];
            Arrays.sort(vals);
            T += 2 * l[v];
        }
        if (u != 0) {
            if (vals[1] != -1)
                ans[u] = Math.max(ans[u], vals[1]);
        } else {
            if (vals[2] != -1)
                ans[u] = Math.max(ans[u], vals[2]);
        }
        update(t[u], -x[u], -1L * x[u] * t[u]);
    }

    static int N = (int) 1e6 + 2;
    static long[] ftCnt, ftSum;

    static void update(int idx, long cnt, long val) {
        while (idx < N) {
            ftCnt[idx] += cnt;
            ftSum[idx] += val;
            idx += (idx & -idx);
        }
    }

    static long getSum(int idx) {
        long ret = 0;
        while (idx > 0) {
            ret += ftSum[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }

    static long getCnt(int idx) {
        long ret = 0;
        while (idx > 0) {
            ret += ftCnt[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }

    static long getMaxCnt() {
        int start = 1, end = N - 1, ans = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getSum(mid) >= T) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        long remT = T - (ans > 1 ? getSum(ans - 1) : 0);
        long cnt = (ans > 1 ? getCnt(ans - 1) : 0);
        long cntOfVal = getCnt(ans) - cnt;
        cnt += Math.min(cntOfVal, remT / ans);
        return cnt;
    }


    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
    }
}