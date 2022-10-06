import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) {
        FastScanner scn = new FastScanner();
        int n = scn.nextInt();
        int s = scn.nextInt();
        if (s <= n) {
            System.out.println(1);
        } else if (s > n) {
            if(s%n == 0){
                System.out.println(s/n);
            } else {
                System.out.println(s/n + 1);
            }
        }

    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
