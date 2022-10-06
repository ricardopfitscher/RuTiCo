import java.io.*;
import java.util.StringTokenizer;
public class Main {
    
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = sc.nextInt();
        long dest = sc.nextLong();
        long max = (long)N * ((long)N + 1L) / 2L;
        if (dest < 2 * N - 1 || dest > max) {
            out.println("No");
            out.close();
            return;
        }
        int[] d = new int[N + 1];
        int[] f = new int[N + 1];
        int K = 1;
        for (; K <= N; K++) {
            long dep = 1L, cnt = 1L, c = 1L;
            long t = 1L;
            while (cnt < N) {
                c = c * K;
                dep++;
                t += (dep * Math.min(c, N - cnt));
                cnt += c;
            }
            if (t <= dest) break;
        }
        out.println("Yes");
        int dep = 1; long cnt = 1L, c = 1L;
        long t = 1L;
        d[1] = 1;
        while (cnt < N) {
            dep++; c = c * K; 
            long x = (long)N - cnt;
            int min;
            if (c >= x) min = (int)x;
            else min = (int)c;
            d[dep] = min;
            t += (dep * Math.min(c, (long)N - cnt)); cnt += c;
        }
        dest -= t;
        int curDep = dep; int nextDep = dep + 1;
        while (dest > 0) {
            if (d[curDep] <= 1) curDep--;
            d[curDep]--;
            long next = Math.min(nextDep++, dest + curDep);
            dest -= ((int)next - curDep);
            d[(int)next]++;
        }
        int first = 1;
        for (int i = 2; i < nextDep; i++) {
            int p = 0, fn = first - d[i - 1] + 1;
            for (int j = first + 1; j <= first + d[i]; j++) {
                if (p == K) {
                    fn++; p = 0;
                }
                p++; f[j] = fn;
            }
            first += d[i];
        }
        for (int i = 2; i <= N; i++)
            out.format("%d ", f[i]);
        out.close();
    }
            
        
    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;
        
        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }
        
        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken("\n");
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
       /* public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = nextInt();
            }
            return a;
        }
        
        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }*/
    }
}