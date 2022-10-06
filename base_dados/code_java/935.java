import java.io.*;
import java.util.*;

public class Main {

	static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e){e.printStackTrace();}
        }

        public String next() {
            if (st.hasMoreTokens()) return st.nextToken();
            try {st = new StringTokenizer(br.readLine());}
            catch (Exception e) {e.printStackTrace();}
            return st.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}

        public long nextLong() {return Long.parseLong(next());}

        public double nextDouble() {return Double.parseDouble(next());}

        public String nextLine() {
            String line = "";
            if(st.hasMoreTokens()) line = st.nextToken();
            else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
            while(st.hasMoreTokens()) line += " "+st.nextToken();
            return line;
        }
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int best = 1;
        int bestTime = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int time;
            int a = sc.nextInt();
            time = (a%n==0 || a%n<=i) ? a/n : (a+n)/n;
            if(time < bestTime) {
                best = i + 1;
                bestTime = time;
            }
        }

        pw.println(best);
        pw.close();
    }
}
