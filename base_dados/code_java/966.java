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

    static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int floor = sc.nextInt();
        int time = 0;

        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++) arr[i] = new Pair(sc.nextInt(), sc.nextInt());

        Arrays.sort(arr, (Pair cur, Pair other) -> (other.a - cur.a));

        for(int i=0;i<n;i++) {
            time += floor - arr[i].a;
            floor = arr[i].a;
            time = Math.max(time, arr[i].b);
            //pw.println("time: " + time);
        }

        time += arr[n-1].a;

        pw.println(time);
        pw.close();
    }
}
