import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class Main {

    static int T;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        T = sc.nextInt();

        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] a = sc.nextIntArray(n);
            int[] ans = solve(n, a);
            StringJoiner j = new StringJoiner(" ");
            for (int each : ans) {
                j.add(String.valueOf(each));
            }
            pw.println(j.toString());
        }
        pw.flush();
    }

    static int[] solve(int N, int[] A) {

        shuffle(A);
        Arrays.sort(A);
        int cur = A[0];
        int time = 1;
        double r = 0;
        int prev = -1;
        int a = -1;
        int b = -1;
        for (int i = 1; i < N; i++) {
            if( cur == A[i] ) {
                time++;

                if( time == 2 ) {
                    if( prev != -1 ) {
                        double r1 = (double)prev/cur;
                        if( r1 > r ) {
                            r = r1;
                            a = prev;
                            b = cur;
                        }
                    }
                    prev = cur;
                }

                if( time == 4 ) {
                    return new int[]{cur, cur, cur, cur};
                }

            } else {
                time = 1;
                cur = A[i];
            }
        }

        return new int[]{a, a, b, b};
    }

    static void shuffle(int[] a) {
        Random r = ThreadLocalRandom.current();
        for (int i = a.length-1; i >= 0; i--) {
            int j = r.nextInt(i+1);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    @SuppressWarnings("unused")
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken("\n");
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        int[] nextIntArray(int n, int delta) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt() + delta;
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static <A> void writeLines(A[] as, Function<A, String> f) {
        PrintWriter pw = new PrintWriter(System.out);
        for (A a : as) {
            pw.println(f.apply(a));
        }
        pw.flush();
    }

    static void writeLines(int[] as) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int a : as) pw.println(a);
        pw.flush();
    }

    static void writeLines(long[] as) {
        PrintWriter pw = new PrintWriter(System.out);
        for (long a : as) pw.println(a);
        pw.flush();
    }

    static int max(int... as) {
        int max = Integer.MIN_VALUE;
        for (int a : as) max = Math.max(a, max);
        return max;
    }

    static int min(int... as) {
        int min = Integer.MAX_VALUE;
        for (int a : as) min = Math.min(a, min);
        return min;
    }

    static void debug(Object... args) {
        StringJoiner j = new StringJoiner(" ");
        for (Object arg : args) {
            if (arg instanceof int[]) j.add(Arrays.toString((int[]) arg));
            else if (arg instanceof long[]) j.add(Arrays.toString((long[]) arg));
            else if (arg instanceof double[]) j.add(Arrays.toString((double[]) arg));
            else if (arg instanceof Object[]) j.add(Arrays.toString((Object[]) arg));
            else j.add(arg.toString());
        }
        System.err.println(j.toString());
    }
}
