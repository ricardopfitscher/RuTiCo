import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class LogicalExpression {
    
    int N = 256;
    
    void solve() {
        Expression[] E = new Expression[N];
        for (int i = 0; i < N; i++) E[i] = new Expression();
        
        E[Integer.parseInt("00001111", 2)].update_f("x");
        E[Integer.parseInt("00110011", 2)].update_f("y");
        E[Integer.parseInt("01010101", 2)].update_f("z");
        
        for (int l = 2; l < 40; l++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (E[i].e != null && E[j].t != null && E[i].e.length() + E[j].t.length() + 1 == l) {
                        E[i | j].update_e(E[i].e + '|' + E[j].t);
                    }
                    if (E[i].t != null && E[j].f != null && E[i].t.length() + E[j].f.length() + 1 == l) {
                        E[i & j].update_t(E[i].t + '&' + E[j].f);
                    }
                }
                if (E[i].f != null) E[i ^ (N - 1)].update_f('!' + E[i].f);
            }
        }
        
        String[] res = new String[N];
        for (int i = 0; i < N; i++) res[i] = E[i].calc_best();
        
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(in.nextToken(), 2);
            out.println(res[x]);
        }
    }
    
    static class Expression {
        String e, t, f;
        
        Expression() {
        }
        
        public Expression(String e, String t, String f) {
            this.e = e;
            this.t = t;
            this.f = f;
        }
        
        String calc_best() {
            String best = e;
            if (compare(best, t) > 0) best = t;
            if (compare(best, f) > 0) best = f;
            return best;
        }
        
        void update_e(String ne) {
            if (e == null || compare(e, ne) > 0) {
                e = ne;
                update_f('(' + e + ')');
            }
        }
        
        void update_t(String nt) {
            if (t == null || compare(t, nt) > 0) {
                t = nt;
                update_e(t);
            }
        }
        
        void update_f(String nf) {
            if (f == null || compare(f, nf) > 0) {
                f = nf;
                update_t(f);
            }
        }
        
        int compare(String a, String b) {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new LogicalExpression().solve();
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
