import java.util.*;
import java.io.*;

public class RGBSubstring {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int Q = scanner.nextInt();
        while(Q-->0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String s1 = "RGB";
            String s2 = "GBR";
            String s3 = "BRG";
            char[] arr = scanner.next().toCharArray();
            int[] cnts = new int[3];
            for(int i = 0; i < K; i++) {
                int ind = i % 3;
                if (arr[i] != s1.charAt(ind)) cnts[0]++;
                if (arr[i] != s2.charAt(ind)) cnts[1]++;
                if (arr[i] != s3.charAt(ind)) cnts[2]++;
            }
            int ans = Math.min(Math.min(cnts[0], cnts[1]), cnts[2]);
            for(int i = K; i < N; i++) {
                int ind = (K-1)%3;
                int[] nextCnts = new int[3];
                nextCnts[1] = cnts[0];
                nextCnts[2] = cnts[1];
                nextCnts[0] = cnts[2];
                if ('R' != arr[i-K]) nextCnts[1]--;
                if ('G' != arr[i-K]) nextCnts[2]--;
                if ('B' != arr[i-K]) nextCnts[0]--;
                if (arr[i] != s1.charAt(ind)) nextCnts[0]++;
                if (arr[i] != s2.charAt(ind)) nextCnts[1]++;
                if (arr[i] != s3.charAt(ind)) nextCnts[2]++;
                cnts = nextCnts;
                for(int j = 0; j < 3; j++) ans = Math.min(ans, cnts[j]);
            }
            out.println(ans);
        }
        out.flush();
    }
    
    public static class FastScanner {
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
        
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
