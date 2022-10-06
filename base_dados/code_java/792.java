import java.io.*;
import java.util.*;

public class cf {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        
        public FastScanner() {
            this(new InputStreamReader(System.in));
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
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }

    static int mod = 1000000007;
    
	public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out); 

        int n=sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n+1];

        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        a[n] = 0;
        Arrays.sort(a);

        for(int i=1;i<=n;i++) {
            if(k == 0) {
                break;
            }
            if(a[i] != a[i-1]) {
                k--;
                pw.println(a[i] - a[i-1]);
            }
        }
        for(int i=0;i<k;i++) pw.println(0);
        pw.close();
    }
}
