import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scan.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (solve(i, vals)) {
                out.print('A');
            } else {
                out.print('B');
            }
        }

        out.close();
    }

    static HashMap<Integer, Boolean> dpResult = new HashMap<>();

    private static boolean solve(int pos, int[] vals) {
        if (dpResult.containsKey(pos)) return dpResult.get(pos);
        int val = vals[pos];
        boolean hasLose = false;
        for (int i = pos; i < vals.length; i += val) {
            if (i == pos) continue;
            if (vals[i] <= vals[pos]) continue;
            if (hasLose) break;
            if (!solve(i, vals)) {
                hasLose = true;
            }
        }
        for (int i = pos; i >= 0; i -= val) {
            if (i == pos) continue;
            if (vals[i] <= vals[pos]) continue;
            if (hasLose) break;
            if (!solve(i, vals)) {
                hasLose = true;
            }
        }
        dpResult.put(pos, hasLose);
        return hasLose;
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------

}