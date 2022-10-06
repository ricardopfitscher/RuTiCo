
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class KingEscape {

    public static void main(String[] args) {
        Reader read = new Reader();

        int n = read.nextInt();
        int a1 = read.nextInt();
        int a2 = read.nextInt();
        int b1 = read.nextInt();
        int b2 = read.nextInt();
        int c1 = read.nextInt();
        int c2 = read.nextInt();

        if (b1 > a1 && b2 > a2 && c1 > a1 && c2 > a2)
            System.out.print("YES");
        else if (b1 > a1 && b2 < a2 && c1 > a1 && c2 < a2)
            System.out.print("YES");
        else if (b1 < a1 && b2 > a2 && c1 < a1 && c2 > a2)
            System.out.print("YES");
        else if (b1 < a1 && b2 < a2 && c1 < a1 && c2 < a2)
            System.out.print("YES");
        else
            System.out.print("NO");
    }

    private static class Reader {

        private final BufferedReader reader;
        private final String separator;
        private String ln;
        private String[] tokens;
        private int ptr;

        Reader(String separator, InputStream input) {
            this.reader = new BufferedReader(new InputStreamReader(input));
            this.separator = separator;
            this.ptr = -1;
        }

        Reader(String separator) { this(separator, System.in); }

        Reader() { this(" "); }

        String nextStr(){
            if (Objects.isNull(ln)) {
                try {
                    ln = reader.readLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (Objects.nonNull(ln)) {
                    tokens = ln.split(separator);
                    ptr = 0;
                } else {
                    throw new NoSuchElementException("no next element");
                }

            } else if (ptr == tokens.length) {
                ln = null;
                tokens = null;
                ptr = -1;
                return nextStr();
            }

            return tokens[ptr++];
        }

        int nextInt() { return Integer.parseInt(nextStr()); }

        long nextLong() { return Long.parseLong(nextStr()); }

        double nextDouble() { return Double.parseDouble(nextStr()); }
    }
}
