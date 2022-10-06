

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Haya
 */
public class CommentaryBoxes {

    public static void main(String[] args) {
        
        FastReader in = new FastReader();
        
        long n = in.nextLong();
        long m = in.nextLong();
        long a = in.nextLong();
        long b = in.nextLong();
        long total = 0;
        
        long val =(n%m);
        if (n%m != 0){
            
            long x = (val)*b;
            long y = (m-val)*a;
            
            total = Math.min(x, y);
        }
        System.out.println(Math.abs(total));
        
    }

    public static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
            String string = "";
            try {
                string = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return string;
        }

    }

}
