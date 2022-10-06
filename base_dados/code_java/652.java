import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kessido
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskG solver = new TaskG();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskG {
        static int[][] g;
        static int n;
        static int[] a;
        static int[][] edges;
        static long[] dp;
        static long[] dpPathToRootWithDetours;
        static int time = 0;
        static int[] appearance;
        static int[] firstAppearance;
        static int[] depth;

        public static void dfs(int i, int parE) {
            firstAppearance[i] = time;
            appearance[time++] = i;
            dp[i] = a[i];
            for (int eIndex : g[i]) {
                if (eIndex == parE) continue;
                int child = i ^ edges[eIndex][0] ^ edges[eIndex][1];
                dfs(child, eIndex);
                appearance[time++] = i;
                dp[i] += Math.max(dp[child] - edges[eIndex][2] * 2, 0);
            }
        }

        public static void dfs2(int i, int parE) {
            if (i == 0) {
                dpPathToRootWithDetours[i] = dp[i];
            } else {
                int par = i ^ edges[parE][0] ^ edges[parE][1];
                depth[i] = depth[par] + 1;
                dpPathToRootWithDetours[i] = dpPathToRootWithDetours[par] - Math.max(0, dp[i] - edges[parE][2] * 2);
                dpPathToRootWithDetours[i] -= edges[parE][2];
                dpPathToRootWithDetours[i] += dp[i];

                long myPathWeight = Math.max(dp[i] - edges[parE][2] * 2, 0);
                long change = dp[par] - myPathWeight - edges[parE][2] * 2;
                change = Math.max(change, 0);
                dp[i] += change;
            }
            for (int eIndex : g[i]) {
                if (eIndex == parE) continue;
                dfs2(i ^ edges[eIndex][0] ^ edges[eIndex][1], eIndex);
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.NextInt();
            int q = in.NextInt();
            a = in.NextIntArray(n);
            edges = new int[n - 1][3];
            {
                long[] count = new long[n];
                for (int i = 0; i < n - 1; i++) {
                    int u = in.NextInt() - 1;
                    int v = in.NextInt() - 1;
                    int w = in.NextInt();
                    edges[i][0] = u;
                    edges[i][1] = v;
                    edges[i][2] = w;
                    count[u]++;
                    count[v]++;
                }

                g = new int[n][];
                for (int i = 0; i < n; i++) {
                    g[i] = new int[(int) count[i]];
                }
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < 2; j++) {
                        g[edges[i][j]][(int) --count[edges[i][j]]] = i;
                    }
                }
            }
            dp = new long[n];
            dpPathToRootWithDetours = new long[n];
            depth = new int[n];
            firstAppearance = new int[n];
            appearance = new int[(n - 1) * 2 + 1];
            dfs(0, -1);
            dfs2(0, -1);
            GraphLowestCommonAncestor.LCA lca = GraphLowestCommonAncestor.createLCA(appearance, firstAppearance, depth);
            firstAppearance = null;
            depth = null;
            appearance = null;
            edges = null;
            g = null;
            for (int i = 0; i < q; i++) {
                int u = in.NextInt() - 1;
                int v = in.NextInt() - 1;
                int lcaI = lca.getLCA(u, v);
                long res = dpPathToRootWithDetours[u] + dpPathToRootWithDetours[v] - 2 * dpPathToRootWithDetours[lcaI] + dp[lcaI];
                out.println(res);
            }
        }

    }

    static class MinRangeSparseTable implements ISearchInRange {
        private final int[][] sparseTables;
        private final long[] array;
        private final boolean reverseOrdered;

        public MinRangeSparseTable(long[] array, boolean reverseOrdered) {
            this.reverseOrdered = reverseOrdered;
            this.array = array;
            int LCALength = IntegerExtension.getNumberOfBits(array.length);
            sparseTables = new int[LCALength][];
            sparseTables[0] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                sparseTables[0][i] = i;
            }
            for (int i = 1; i < LCALength; i++) {
                int size = 1 << i;
                int jumpSize = 1 << (i - 1);
                sparseTables[i] = new int[sparseTables[0].length - size + 1];
                for (int j = 0; j < sparseTables[i].length; j++) {
                    sparseTables[i][j] = min(sparseTables[i - 1][j], sparseTables[i - 1][j + jumpSize]);
                }
            }
        }

        private int min(int a, int b) {
            return ((array[a] < array[b]) ^ reverseOrdered) ? a : b;
        }


        public Pair<Long, Long> queryIndexValueInRange(long l, long r) {
            int size = (int) (r - l + 1);
            int LCAIndex = IntegerExtension.getNumberOfBits(size) - 1;
            int sizeNeeded = 1 << LCAIndex;
            int res = min(sparseTables[LCAIndex][(int) l], sparseTables[LCAIndex][(int) (r - sizeNeeded + 1)]);
            return new Pair<>((long) res, array[res]);
        }

        public MinRangeSparseTable(long[] array) {
            this(array, false);
        }

    }

    static class GraphLowestCommonAncestor {
        public static GraphLowestCommonAncestor.LCA createLCA(int[] appearances, final int[] firstAppearance, final int[] depth) {
            return new GraphLowestCommonAncestor.LCA_MinRangeSparseTable(appearances, firstAppearance, depth);
        }

        public interface LCA {
            int getLCA(int a, int b);

        }

        private static class LCA_MinRangeSparseTable implements GraphLowestCommonAncestor.LCA {
            private final MinRangeSparseTable minRangeSparseTable;
            private final int[] firstAppearance;
            private final int[] indexToNode;

            public LCA_MinRangeSparseTable(int[] appearances, final int[] firstAppearance, final int[] depth) {
                this.firstAppearance = firstAppearance;
                this.indexToNode = appearances;
                long[] depthOrder = new long[appearances.length];
                for (int i = 0; i < depthOrder.length; i++) {
                    depthOrder[i] = depth[appearances[i]];
                }
                minRangeSparseTable = new MinRangeSparseTable(depthOrder);
            }


            public int getLCA(int a, int b) {
                a = firstAppearance[a];
                b = firstAppearance[b];
                int l = Math.min(a, b), r = Math.max(a, b);
                return indexToNode[(int) (long) minRangeSparseTable.queryIndexValueInRange(l, r).first];
            }

        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NextInt() {
            return Integer.parseInt(next());
        }

        public int[] NextIntArray(int n) {
            return NextIntArray(n, 0);
        }

        public int[] NextIntArray(int n, int offset) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = NextInt() + offset;
            }
            return a;
        }

    }

    static interface ISearchInRange {
    }

    static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair(T1 f, T2 s) {
            first = f;
            second = s;
        }

    }

    static class IntegerExtension {
        public static int getNumberOfBits(long i) {
            return 64 - Long.numberOfLeadingZeros(i);
        }

    }
}

