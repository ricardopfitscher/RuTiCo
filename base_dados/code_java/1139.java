import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve4 {

    public static void main(String[] args) throws IOException {
      FastReader sc = new FastReader();
      int x= sc.nextInt();
      int y= sc.nextInt();
      int z= sc.nextInt();
      int t1= sc.nextInt();
      int t2= sc.nextInt();
      int t3= sc.nextInt();
      if(Math.abs(x-y)*t1 < (Math.abs(x-z)+Math.abs(x-y))*t2+3*t3 ) System.out.println("NO");
      else System.out.println("YES");
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException ex) {
            }
            return s;
        }
    }

}
