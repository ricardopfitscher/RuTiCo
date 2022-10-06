import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        int[][] ans;
        int[][] x;
        int n;
        int k;
        int ansInd;
        int inplace;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            k = in.nextInt();
            x = new int[4][n];
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < n; i++) {
                    x[j][i] = in.nextInt();
                }
            }
            ans = new int[20_000][3];
            ansInd = 0;
            inplace = 0;
            toSlot();
            if (inplace == 0 && k == 2 * n) {
                out.println(-1);
                return;
            }
            while (inplace != k) {
                rot();
                toSlot();
            }
            out.println(ansInd);
            for (int i = 0; i < ansInd; i++) {
                out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
            }
        }

        void toSlot() {
            for (int i = 0; i < n; i++) {
                if (x[0][i] == x[1][i] && x[1][i] != 0) {
                    ans[ansInd][0] = x[1][i];
                    ans[ansInd][1] = 1;
                    ans[ansInd][2] = i + 1;
                    x[1][i] = 0;
                    ansInd++;
                    inplace++;
                }
                if (x[3][i] == x[2][i] && x[2][i] != 0) {
                    ans[ansInd][0] = x[2][i];
                    ans[ansInd][1] = 4;
                    ans[ansInd][2] = i + 1;
                    x[2][i] = 0;
                    ansInd++;
                    inplace++;
                }
            }
        }

        void rot() {
            int emptyRow = -1;
            int emptyCol = -1;
            for (int i = 0; i < n; i++) {
                if (x[1][i] == 0) {
                    emptyRow = 1;
                    emptyCol = i;
                    break;
                }
                if (x[2][i] == 0) {
                    emptyRow = 2;
                    emptyCol = i;
                    break;
                }
            }
            int moved = 0;
            int dir = (emptyRow == 1) ? 1 : -1;
            while (k - inplace > moved) {
                int nextRow = emptyRow;
                int nextCol = emptyCol - dir;
                if (nextCol < 0) {
                    nextCol = 0;
                    nextRow = 2;
                    dir = -1;
                }
                if (nextCol >= n) {
                    nextCol = n - 1;
                    nextRow = 1;
                    dir = 1;
                }
                if (x[nextRow][nextCol] != 0) {
                    ans[ansInd][0] = x[nextRow][nextCol];
                    ans[ansInd][1] = emptyRow + 1;
                    ans[ansInd][2] = emptyCol + 1;
                    ansInd++;
                    x[emptyRow][emptyCol] = x[nextRow][nextCol];
                    x[nextRow][nextCol] = 0;
                    moved++;
                }
                emptyRow = nextRow;
                emptyCol = nextCol;
            }
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

