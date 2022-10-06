
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class P1196D2 {

    static boolean multipleIndependent = true;

    void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        char[] s = in.next().toCharArray();
        int[] dp = new int[3];
        char[] c = {'R', 'G', 'B'};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            dp[0] += s[i] == c[(i + 0) % 3] ? 0 : 1;
            dp[1] += s[i] == c[(i + 1) % 3] ? 0 : 1;
            dp[2] += s[i] == c[(i + 2) % 3] ? 0 : 1;
        }
        min = Math.min(Math.min(Math.min(dp[0], dp[1]), dp[2]), min);
//        System.out.println(Arrays.toString(dp));
        for (int i = k; i < n; i++) {
            dp[0] += (s[i] == c[(i + 0) % 3] ? 0 : 1) - (s[i - k] == c[(i - k + 0) % 3] ? 0 : 1);
            dp[1] += (s[i] == c[(i + 1) % 3] ? 0 : 1) - (s[i - k] == c[(i - k + 1) % 3] ? 0 : 1);
            dp[2] += (s[i] == c[(i + 2) % 3] ? 0 : 1) - (s[i - k] == c[(i - k + 2) % 3] ? 0 : 1);
            min = Math.min(Math.min(Math.min(dp[0], dp[1]), dp[2]), min);
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(min);
    }


    /* -----: Template :----- */
    static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {
        P1196D2 p = new P1196D2();
        int q = multipleIndependent ? in.nextInt() : 1;
        while (q-- > 0) {
            p.run();
        }
    }

    int numLength(long n) {
        int l = 0;
        while (n > 0) {
            n /= 10;
            l++;
        }
        return l;
    }

    <R> long binarySearch(long lowerBound, long upperBound,
            R value, Function<Long, R> generatorFunction, Comparator<R> comparator) {
        if (lowerBound <= upperBound) {
            long mid = (lowerBound + upperBound) / 2;
            int compare = comparator.compare(generatorFunction.apply(mid), value);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                return binarySearch(mid + 1, upperBound, value, generatorFunction, comparator);
            } else {
                return binarySearch(lowerBound, mid - 1, value, generatorFunction, comparator);
            }
        } else {
            return -1;
        }
    }

    <T> Integer[] sortSimultaneously(T[] key, Comparator<T> comparator,
            Object[]... moreArrays) {
        int n = key.length;
        for (Object[] array : moreArrays) {
            if (array.length != n) {
                throw new RuntimeException("Arrays must have equals lengths");
            }
        }
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Comparator<Integer> delegatingComparator = (a, b) -> {
            return comparator.compare(key[a], key[b]);
        };
        Arrays.sort(indices, delegatingComparator);
        reorder(indices, key);
        for (Object[] array : moreArrays) {
            reorder(indices, array);
        }
        return indices;
    }

    void reorder(Integer[] indices, Object[] arr) {
        if (indices.length != arr.length) {
            throw new RuntimeException("Arrays must have equals lengths");
        }
        int n = arr.length;
        Object[] copy = new Object[n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[indices[i]];
        }
        System.arraycopy(copy, 0, arr, 0, n);
    }

    int prodMod(int a, int b, int mod) {
        return (int) (((long) a) * b % mod);
    }

    long prodMod(long a, long b, long mod) {
        long res = 0;
        a %= mod;
        b %= mod;
        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res + a) % mod;
            }
            a = (a << 1) % mod;
            b >>= 1;
        }
        return res;
    }

    long sumMod(int[] b, long mod) {
        long res = 0;
        for (int i = 0; i < b.length; i++) {
            res = (res + b[i] % mod) % mod;
        }
        return res;
    }

    long sumMod(long[] a, long mod) {
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            res = (res + a[i] % mod) % mod;
        }
        return res;
    }

    long sumProdMod(int[] a, long b, long mod) {
        long res = sumMod(a, mod);
        return prodMod(res, b, mod);
    }

    long sumProdMod(long[] a, long b, long mod) {
        long res = sumMod(a, mod);
        return prodMod(res, b, mod);
    }

    long sumProdMod(int[] a, int[] b, long mod) {
        if (a.length != b.length) {
            throw new RuntimeException("Arrays must have equals lengths");
        }
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            res = (res + prodMod(a[i], b[i], mod)) % mod;
        }
        return res;
    }

    long sumProdMod(long[] a, long[] b, long mod) {
        if (a.length != b.length) {
            throw new RuntimeException("Arrays must have equals lengths");
        }
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            res = (res + prodMod(a[i], b[i], mod)) % mod;
        }
        return res;
    }

    int[] toPrimitive(Integer[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    int[][] toPrimitive(Integer[][] arr) {
        int[][] res = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            res[i] = toPrimitive(arr[i]);
        }
        return res;
    }

    long[] toPrimitive(Long[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    long[][] toPrimitive(Long[][] arr) {
        long[][] res = new long[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            res[i] = toPrimitive(arr[i]);
        }
        return res;
    }

    Integer[] toWrapper(int[] arr) {
        Integer[] res = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    Integer[][] toWrapper(int[][] arr) {
        Integer[][] res = new Integer[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            res[i] = toWrapper(arr[i]);
        }
        return res;
    }

    Long[] toWrapper(long[] arr) {
        Long[] res = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    Long[][] toWrapper(long[][] arr) {
        Long[][] res = new Long[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            res[i] = toWrapper(arr[i]);
        }
        return res;
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public <T> T[] nextIntArray(int n, Function<Integer, T> function, Class<T> c) {
            T[] arr = (T[]) Array.newInstance(c, n);
            for (int i = 0; i < n; i++) {
                arr[i] = function.apply(nextInt());
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public <T> T[] nextLongArray(int n, Function<Long, T> function, Class<T> c) {
            T[] arr = (T[]) Array.newInstance(c, n);
            for (int i = 0; i < n; i++) {
                arr[i] = function.apply(nextLong());
            }
            return arr;
        }

        public int[][] nextIntMap(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = nextIntArray(m);
            }
            return map;
        }

        public long[][] nextLongMap(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = nextLongArray(m);
            }
            return map;
        }

        public char[][] nextCharMap(int n) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = next().toCharArray();
            }
            return map;
        }

        public void readColumns(Object[]... columns) {
            int n = columns[0].length;
            for (Object[] column : columns) {
                if (column.length != n) {
                    throw new RuntimeException("Arrays must have equals lengths");
                }
            }
            for (int i = 0; i < n; i++) {
                for (Object[] column : columns) {
                    column[i] = read(column[i].getClass());
                }
            }
        }

        public <T> T read(Class<T> c) {
            throw new UnsupportedOperationException("To be implemented");
        }

    }

}
