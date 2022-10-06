import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author llamaoo7
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DRecoveringBST solver = new DRecoveringBST();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRecoveringBST {
        private boolean gcd(int a, int b) {
            if (a == 0) return b != 1;
            return gcd(b % a, a);
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n + 20];
            boolean[][] g = new boolean[n + 20][n + 20];
            boolean[][] dpl = new boolean[n + 20][n + 20];
            boolean[][] dpr = new boolean[n + 20][n + 20];
            for (int i = 1; i <= n; i++) a[i] = in.nextInt();
            for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) g[i][j] = gcd(a[i], a[j]);
            for (int len = 0; len < n; len++) {
                for (int left = 1; left + len <= n; left++) {
                    int right = left + len;
                    for (int vert = left; vert <= right; vert++) {
                        boolean lg = (vert == left || dpr[left][vert - 1]);
                        boolean rg = (vert == right || dpl[vert + 1][right]);
                        if (!(lg && rg)) continue;
                        if (g[vert][left - 1]) dpl[left][right] = true;
                        if (g[vert][right + 1]) dpr[left][right] = true;
                    }
                }
            }
            for (int vert = 1; vert <= n; vert++) {
                boolean lg = vert == 1 || dpr[1][vert - 1];
                boolean rg = vert == n || dpl[vert + 1][n];
                if (lg && rg) {
                    out.println("Yes");
                    return;
                }
            }
            out.println("No");
        }

    }
}

