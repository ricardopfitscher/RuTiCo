import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            TreeMap<Integer, Integer> aPos = new TreeMap<>();
            int height = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                height = Math.max(height, a[i]);
                aPos.put(a[i], i);
            }
            TreeMap<seg, seg> segs = new TreeMap<>();
            segs.put(new seg(0, n - 1), new seg(0, n - 1));
            int[] cntSize = new int[n + 1];
            cntSize[n] = 1;
            TreeSet<Integer> segType = new TreeSet<>();
            int maxSegCnt = 0;
            for (int key : aPos.descendingKeySet()) {
                int pos = aPos.get(key);
                seg cur = segs.get(new seg(pos, pos));
                segs.remove(cur);
                cntSize[cur.r - cur.l + 1]--;
                if (cntSize[cur.r - cur.l + 1] == 0) {
                    segType.remove(cur.r - cur.l + 1);
                }
                if (cur.l <= pos - 1) {
                    seg left = new seg(cur.l, pos - 1);
                    segs.put(left, left);
                    if (cntSize[left.r - left.l + 1] == 0) {
                        segType.add(left.r - left.l + 1);
                    }
                    cntSize[left.r - left.l + 1]++;
                }
                if (pos + 1 <= cur.r) {
                    seg right = new seg(pos + 1, cur.r);
                    segs.put(right, right);
                    if (cntSize[right.r - right.l + 1] == 0) {
                        segType.add(right.r - right.l + 1);
                    }
                    cntSize[right.r - right.l + 1]++;
                }
                if (segType.size() == 1) {
                    if (cntSize[segType.first()] >= maxSegCnt) {
                        maxSegCnt = cntSize[segType.first()];
                        height = key;
                    }
                }
            }
            int ans = 0;
            if (n == 1) {
                ans = height + 1;
            } else {
                for (int i = 0; i < n; i++) {
                    if (a[i] < height) {
                        ans = Math.max(ans, a[i]);
                    }
                }
                ans++;
            }
            out.println(ans);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class seg implements Comparable {
        int l;
        int r;

        seg(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public int compareTo(Object o) {
            seg other = (seg) o;
            if (other.r < l) return 1;
            if (other.l > r) return -1;
            return 0;
        }

    }
}

