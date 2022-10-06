import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author \/
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            TaskC.pair[] songs = new TaskC.pair[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                songs[i] = new TaskC.pair(in.nextInt(), in.nextInt());
                sum += songs[i].a;
            }
            Arrays.sort(songs);

            int res = 0;
            int idx = n - 1;
            while (sum > m) {
                if (idx < 0) {
                    break;
                }
                sum -= (songs[idx].a - songs[idx].b);

                res++;
                idx--;
            }

            if (sum > m) {
                out.println(-1);
            } else {
                out.println(res);
            }
        }

        static class pair implements Comparable<TaskC.pair> {
            int a;
            int b;

            pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public int compareTo(TaskC.pair p) {
                return (this.a - this.b) - (p.a - p.b);
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

