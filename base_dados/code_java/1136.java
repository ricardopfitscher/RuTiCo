import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class FunctionHeight {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        long n = sc.nl();
        long k = sc.nl();
        long ans = (n+k-1)/n;
        System.out.println(ans);
    }

    /////////// TEMPLATE FROM HERE /////////////////
    private static class MyScanner {
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

        int ni() {
            return Integer.parseInt(next());
        }

        float nf() {
            return Float.parseFloat(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
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