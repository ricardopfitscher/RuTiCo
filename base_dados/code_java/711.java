import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.LongBinaryOperator;

public class Main {

    static int N;
    static String S;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        N = sc.nextInt();
        S = sc.next();

        System.out.println( solve() );
    }

    static int MOD = 1_000_000_007;
    static char L = '(';
    static char R = ')';

    static int solve() {
        // (s + L) -> s
        int[] next_L = new int[S.length()+1];
        next_L[S.length()] = S.length();
        for (int s = 0; s < S.length(); s++) {
            if( S.charAt(s) == L ) {
                next_L[s] = s+1;
                continue;
            }

            String fail = S.substring(0, s) + L;
            int reuse = 0;
            for (int ri = 1; ri <= fail.length(); ri++) {
                String f = fail.substring(fail.length()-ri);
                if( S.startsWith(f) ) {
                    reuse = Math.max(reuse, ri);
                }
            }
            next_L[s] = reuse;
        }
        int[] next_R = new int[S.length()+1];
        next_R[S.length()] = S.length();
        for (int s = 0; s < S.length(); s++) {
            if( S.charAt(s) == R ) {
                next_R[s] = s+1;
                continue;
            }

            String fail = S.substring(0, s) + R;
            int reuse = 0;
            for (int ri = 1; ri <= fail.length(); ri++) {
                String f = fail.substring(fail.length()-ri);
                if( S.startsWith(f) ) {
                    reuse = Math.max(reuse, ri);
                }
            }
            next_R[s] = reuse;
        }


        // dp[i][stack][s]
        int[][][] dp = new int[N*2+1][N+1][S.length()+1];
        dp[0][0][0] = 1;

        for (int i = 0; i < N*2; i++) {
            for (int stack = 0; stack <= maxStack(i); stack++) {
                for (int s = 0; s <= S.length(); s++) {
                    if( dp[i][stack][s] == 0 ) continue;

                    // L
                    if( stack < maxStack(i+1) ) {
                        dp[i+1][stack+1][next_L[s]] = (dp[i+1][stack+1][next_L[s]] + dp[i][stack][s]) % MOD;
//                        if( dp[i][stack][s] > 0 ) {
//                            System.out.println("("+  i + " " + stack + " " + s + ") -> (" + (i+1) + " " + (stack+1) + " " + next_L[s] + ") " + dp[i+1][stack+1][next_L[s]]);
//                        }
                    }

                    // R
                    if( stack != 0 ) {
                        dp[i+1][stack-1][next_R[s]] = (dp[i+1][stack-1][next_R[s]] + dp[i][stack][s]) % MOD;
//                        if( dp[i][stack][s] > 0 ) {
//                            System.out.println("("+  i + " " + stack + " " + s + ") -> (" + (i+1) + " " + (stack-1) + " " + next_R[s] + ") " + dp[i+1][stack-1][next_R[s]]);
//                        }
                    }
                }
            }
        }

        return dp[N*2][0][S.length()];
    }

    static int maxStack(int i) {
        if( i <= N ) {
            return i;
        } else {
            return 2*N - i;
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

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}
