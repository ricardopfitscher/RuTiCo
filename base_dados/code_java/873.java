import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Test {

    int readInt() {
        int ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    long readLong() {
        long ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }


    String readLine() {
        StringBuilder b = new StringBuilder();
        try {
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '\n') {
                    break;
                } else {
                    b.append((char) (c));
                }
            }
        } catch (IOException e) {
        }
        return b.toString().trim();
    }

    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int n;
    int[][] units;
    int[] x = new int[2];
    int[][] good;

    boolean check(int i, int j) {
        int a = x[j];
        int u = units[i][0];
        int c = (a + u - 1) / u;
        if (i + c >= n) return false;
        i += c;
        return good[i][1 - j] > 0;
    }

    void start() {
        n = readInt(); x[0] = readInt(); x[1] = readInt();
        units = new int[n][2];
        good = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            units[i][0] = readInt();
            units[i][1] = i + 1;
        }
        Arrays.sort(units, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                good[i][j] = good[i + 1][j];
                if (good[i][j] > 0) continue;
                int u = units[i][0];
                int c = (x[j] + u - 1) / u;
                if (c + i <= n) good[i][j] = i + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (check(i, j)) {
                    writer.println("Yes");
                    int u = units[i][0];
                    int c = (x[j] + u - 1) / u;
                    int i0 = i, c0 = c;
                    i += c;
                    i = good[i][1 - j] - 1;
                    u = units[i][0];
                    c = (x[1 - j] + u - 1) / u;
                    int i1 = i, c1 = c;
                    if (j == 1) {
                        int t = i0;
                        i0 = i1;
                        i1 = t;
                        t = c0;
                        c0 = c1;
                        c1 = t;
                    }
                    writer.println(c0 + " " + c1);
                    for (int k = i0; k < i0 + c0; k++)
                        writer.print(units[k][1] + " ");
                    writer.println();
                    for (int k = i1; k < i1 + c1; k++)
                        writer.print(units[k][1] + " ");
                    return;
                }
            }
        }
        writer.println("No");
    }

    public static void main(String[] args) {
        Test te = new Test();
        te.start();
        writer.flush();
    }
}