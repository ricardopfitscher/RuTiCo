import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class TwoSquares {
    
    int INF = 1000;
    
    void solve() {
        int[][] s1 = new int[4][2];
        for (int i = 0; i < 4; i++) {
            s1[i][0] = in.nextInt();
            s1[i][1] = in.nextInt();
        }
        
        int[][] s2 = new int[4][2];
        for (int i = 0; i < 4; i++) {
            s2[i][0] = in.nextInt();
            s2[i][1] = in.nextInt();
        }
        
        if (ok(s1, s2)) {
            out.println("Yes");
            return;
        }
        
        rotate(s1);
        rotate(s2);
        
        if (ok(s2, s1)) {
            out.println("Yes");
            return;
        }
        
        out.println("No");
    }
    
    void rotate(int[][] s) {
        for (int i = 0; i < 4; i++) {
            int x = s[i][0], y = s[i][1];
            s[i][0] = x - y;
            s[i][1] = x + y;
        }
    }
    
    boolean ok(int[][] s1, int[][] s2) {
        int xmin = INF, xmax = -INF, ymin = INF, ymax = -INF;
        for (int i = 0; i < 4; i++) {
            xmin = Math.min(xmin, s1[i][0]);
            xmax = Math.max(xmax, s1[i][0]);
            ymin = Math.min(ymin, s1[i][1]);
            ymax = Math.max(ymax, s1[i][1]);
        }
        
        for (int i = 0; i < 4; i++) {
            if (s2[i][0] >= xmin && s2[i][0] <= xmax && s2[i][1] >= ymin && s2[i][1] <= ymax) return true;
        }
        
        int[] mid2 = new int[]{s2[0][0] + s2[2][0], s2[0][1] + s2[2][1]};
        return mid2[0] >= xmin * 2 && mid2[0] <= xmax * 2 && mid2[1] >= ymin * 2 && mid2[1] <= ymax * 2;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new TwoSquares().solve();
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
