
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class BattleShip {

    public static void main(String[] args) throws IOException {
        StringTokenizer read = new StringTokenizer(In.nString());
        int n = SP.toInt(read.nextToken());
        int k = SP.toInt(read.nextToken());

        char[][] inputs = new char[n][n];
        int[][] counters = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = In.nChars();
            inputs[i] = line;

            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (line[j] == '#') {
                    counter = 0;
                } else if (line[j] == '.') {
                    counter++;
                    if (counter >= k) {
                        for (int a = 0; a < k; a++) {
                            counters[i][j - a]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (inputs[j][i] == '#') {
                    counter = 0;
                } else if (inputs[j][i] == '.') {
                    counter++;
                    if (counter >= k) {
                        for (int a = 0; a < k; a++) {
                            counters[j - a][i]++;
                        }
                    }
                }
            }
        }

        int max = 0;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (counters[i][j] > max) {
                    max = counters[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
        }

        maxX++;
        maxY++;

        Out.print(maxX + " " + maxY);

        Out.close();
    }

    private static class Out {

        private static PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        public static void print(Object o) {
            output.print(o);
        }

        public static void printLn(Object o) {
            output.println(o);
        }

        public static void close() {
            output.close();
        }

    }

    private static class In {

        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static String nString() throws IOException {
            return br.readLine();
        }

        public static char[] nChars() throws IOException {
            return br.readLine().toCharArray();
        }

        public static int nInt() throws IOException {
            return SP.toInt(nString());
        }

        public static long nLong() throws IOException {
            return SP.toLong(nString());
        }

        public static double nDouble() throws IOException {
            return SP.toDouble(nString());
        }

    }

    private static class SP {

        public static String[] split(String line, String separator) {
            return line.split(separator);
        }

        public static int toInt(String s) {
            return Integer.parseInt(s);
        }

        public static long toLong(String s) {
            return Long.parseLong(s);
        }

        public static double toDouble(String s) {
            return Double.parseDouble(s);
        }

    }

}
