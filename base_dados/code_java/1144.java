import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        SpeedScanner speedScanner = new SpeedScanner();
        PrintWriter out = new PrintWriter(System.out);
        taskSolver(speedScanner, out);
        out.close();
    }


    public static void taskSolver(SpeedScanner speedScanner, PrintWriter out) {
        long n = speedScanner.nextLong();
        long m = speedScanner.nextLong();
        long k = speedScanner.nextLong();
        long l = speedScanner.nextLong();

        long tempM ;

        if ((k+l) < m){
            if (n<m)
                out.print(-1);
            else
                out.print(1);
        }else {
            tempM = (k+l)/m;
            if ((k+l)%m == 0){
                if (tempM*m <= n)
                    out.print(tempM);
                else
                    out.print(-1);
            }else {
                if ((tempM+1)*m <= n)
                    out.print(tempM+1);
                else
                    out.print(-1);
            }
        }
    }


    public static class SpeedScanner {
        BufferedReader br;
        StringTokenizer st;

        public SpeedScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
