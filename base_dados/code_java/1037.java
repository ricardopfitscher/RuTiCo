//package ContestEd69;

import java.io.*;
import java.util.StringTokenizer;

public class mainD {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);
    public static long[] arr;
    public static void main(String[] args) throws IOException {
        int n=enter.nextInt();
        int m=enter.nextInt();
        long k=enter.nextLong();
        arr=new long[n+1];
        for (int i = 1; i <n+1 ; i++) {
            arr[i]=enter.nextLong();
        }
        long[] summ=new long[n+1];
        for (int i = 1; i <n+1 ; i++) {
            summ[i]+=arr[i]+summ[i-1];
        }

        long[] best=new long[n+1];

        for (int i = 1; i <n+1 ; i++) {
            best[i]=Math.max(0, ((i-m>=0) ? best[i-m]+summ[i]-summ[i-m]-k:0));
        }
        long ans=best[1];

        for (int i = 1; i <n+1 ; i++) {
            ans=Math.max(ans,best[i]);
            for (int j = 1; j <m ; j++) {
                ans=Math.max(ans, ((i-j>=0) ? best[i-j] -k +summ[i]-summ[i-j]:0));
            }
        }
        System.out.println(ans);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
