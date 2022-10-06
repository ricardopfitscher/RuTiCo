import java.io.*;
import java.util.*;

public class A4 {

    public BufferedReader input;
    public PrintWriter output;
    public StringTokenizer stoken = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        new A4();
    }

    A4() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new PrintWriter(System.out);
        run();
        input.close();
        output.close();
    }

    private void run() throws IOException {
        int n = Math.toIntExact(nextLong());
        int m = Math.toIntExact(nextLong());
        int[] coor = new int[n + 1];
        int[] ss = new int[n + 1];
        for (int i = 0; i < n; i++) {
            coor[i] = Math.toIntExact(nextLong());
        }
        coor[n] = 1000000000;
        Arrays.sort(coor);
        for (int i = 0; i < m; i++) {
            long x1 = nextLong();
            long x2 = nextLong();
            nextLong();
            if (x1 == 1 && x2 >= coor[0]) {
                int l = 0;
                int r = n + 1;
                while (r - l > 1) {
                    int mi = (r + l) / 2;
                    if (coor[mi] > x2) {
                        r = mi;
                    } else {
                        l = mi;
                    }
                }
                ss[l]++;
            }
        }
        long[] ans = new long[n + 1];
        ans[n] = ss[n] + n;
        long min = ans[n];
        for (int i = n - 1; i > -1; i--) {
            ans[i] = ans[i + 1] - 1 + ss[i];
            if (ans[i] < min) {
                min = ans[i];
            }
        }
        System.out.println(min);
    }

    private Long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextString());
    }

    private String nextString() throws IOException {
        while (!stoken.hasMoreTokens()) {
            String st = input.readLine();
            stoken = new StringTokenizer(st);
        }
        return stoken.nextToken();
    }
}