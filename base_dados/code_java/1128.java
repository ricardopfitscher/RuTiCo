import java.io.*;
import java.util.*;

public class A1008 {
    public static void main(String [] args) /*throws Exception*/ {
        InputStream inputReader = System.in;
        OutputStream outputReader = System.out;
        InputReader in = new InputReader(inputReader);//new InputReader(new FileInputStream(new File("input.txt")));new InputReader(inputReader);
        PrintWriter out = new PrintWriter(outputReader);//new PrintWriter(new FileOutputStream(new File("output.txt")));
        Algorithm solver = new Algorithm();
        solver.solve(in, out);
        out.close();
    }
}

class Algorithm {
    void solve(InputReader ir, PrintWriter pw) {

        long n = ir.nextLong(), k = ir.nextLong();
        long l = Math.max(1, k - n), r = (k + 1) / 2;
        l = Math.max(0, r - l);
        pw.print(l);

    }

}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    String nextLine(){
        String fullLine = null;
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                fullLine = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return fullLine;
        }
        return fullLine;
    }

    String [] toArray() {
        return nextLine().split(" ");
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
    double nextDouble() {
        return Double.parseDouble(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }

}