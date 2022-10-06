import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class SequenceTransformation {
    void solve() {
        int p = 1, n = in.nextInt();
        while (n > 0) {
            if (n == 1) {
                out.print(p + " ");
                break;
            }
            if (n == 2) {
                out.print(p + " ");
                out.print(2 * p + " ");
                break;
            }
            if (n == 3) {
                out.print(p + " ");
                out.print(p + " ");
                out.print(3 * p + " ");
                break;
            }
            for (int i = 0; i < (n + 1) / 2; i++) {
                out.print(p + " ");
            }
            p *= 2;
            n /= 2;
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new SequenceTransformation().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
