import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    static int n;
     static long TotalTime;
    static Problem[] problems;
    static StringBuilder sb;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        sb = new StringBuilder();
        n = sc.nextInt();
        TotalTime = sc.nextLong();
        problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            problems[i] = new Problem (sc.nextInt(), sc.nextLong(), i);
        }
        Arrays.sort(problems);
        long num = -1;
        long high = n;
        long low = 0;
        int iter = 0;
        while (high - low > 1) {
            num = (high + low) / 2;
            if (test(num, false)) {
                low = num;
            }
            else {
                high = num;
            }
        }
        if (test(high, false))
            num = high;
        else
            num = low;
        test(num, true);
        System.out.print(sb);
    }

    public static boolean test (long num, boolean print) {
        int count = 0;
        long sum = 0L;
        if (print) sb.append(num + "\n" + num + "\n");
        for (int i = 0; i < n && count < num; i++) {
            if (problems[i].a >= num) {
                count++;
                sum += problems[i].t;
                if (print) sb.append((problems[i].index + 1) + " ");
            }
        }
        return (count == num) && (sum <= TotalTime);
    }

    public static class Problem implements Comparable<Problem>  {
        int a;
        long t;
        int index;
        
        public int compareTo(Problem o) {
          return Long.compare(t, o.t);
        }
        public Problem (int a, long t, int index) {
            this.a = a;
            this.t = t;
            this.index = index;
        }
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

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}