import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main {

    private FastScanner scanner = new FastScanner();

    public static void main(String[] args) {
        new Main().solve();
    }


    private void solve() {
        int n = scanner.nextInt();

        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();

            LinkedList<Character> st = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if (c == ')' && !st.isEmpty() && st.getLast() == '(') {
                    st.pollLast();
                    continue;
                }
                st.addLast(c);
            }

            int t = st.size();
            Set<Character> set = new HashSet<>(st);
            if (set.size() > 1) {
                continue;
            }
            if (set.isEmpty()) {
                cnt.put(0, cnt.getOrDefault(0, 0) + 1);
                continue;
            }

            if (st.getLast() == '(') {
                cnt.put(t, cnt.getOrDefault(t, 0) + 1);
            } else {
                cnt.put(-t, cnt.getOrDefault(-t, 0) + 1);
            }
        }

        long ans = 0;

        for (int next : cnt.keySet()) {
            if (next == 0) {
                ans += (long) cnt.get(next) * (cnt.get(next) - 1) + cnt.get(next);
            } else if (next > 0) {
                int t = next * -1;
                if (cnt.containsKey(t)) {
                    ans += (long) cnt.get(next) * cnt.get(t);
                }
            }
        }

        System.out.print(ans);

    }

    class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        Integer[] nextA(int n) {
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}