import java.io.*;
import java.util.*;

public class Main {
    public void solve() {
        int n = ni();
        int a = ni();
        int b = ni();

        long ans = 0;
        HashMap<Long, Long> m = new HashMap<>();
        HashMap<String, Long> s = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ni();
            long vx = ni();
            long vy = ni();
            long v = (long) a * vx - vy;
            String k = vx + "|" + vy;
            long cs = s.getOrDefault(k, 0L);
            long c = m.getOrDefault(v, 0L);
            ans += c - cs;
            m.put(v, c + 1);
            s.put(k, cs + 1);
        }
        write (ans * 2 + "\n");
    }



    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
        try {
            m.out.close();
        } catch (IOException e) {}
    }

    BufferedReader in;
    BufferedWriter out;
    StringTokenizer tokenizer;
    public Main() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String n() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(in.readLine());
            } catch (IOException e) {}
        }
        return tokenizer.nextToken();
    }
    public int ni() {
        return Integer.parseInt(n());
    }
    public long nl() {
        return Long.parseLong(n());
    }
    public void write(String s) {
        try {
            out.write(s);
        } catch (IOException e) {}
    }
}