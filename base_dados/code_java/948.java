
import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;

// _ h _ r _ t r _
// _ t _ t _ s t _




public class TaskA implements Runnable {
    long m = (int)1e9+7;
    PrintWriter w;
    InputReader c;
    final int MAXN = (int)1e6 + 100;
    public void run() {
        c = new InputReader(System.in);
        w = new PrintWriter(System.out);

        int n = c.nextInt(), hamming_distance = 0;
        char[] s = c.next().toCharArray(), t = c.next().toCharArray();
        HashMap<Character, HashSet<Character>> replace = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<n;++i) if(s[i] != t[i]) {
            HashSet<Character> temp;
            if(replace.containsKey(s[i])){
                temp = replace.get(s[i]);
                temp.add(t[i]);
            } else {
                temp = new HashSet<>();
                temp.add(t[i]);
            }
            map.put(s[i],i);
            replace.put(s[i], temp);
            hamming_distance++;
        }

        int l = -1, r = -1;
        boolean global_check = false;
        for(int i=0;i<n;i++) if(s[i] != t[i]) {
            if(replace.containsKey(t[i])) {
                HashSet<Character> indices = replace.get(t[i]);
                int ind = map.get(t[i]);
                l = i + 1;
                r = ind + 1;
                if (indices.contains(s[i])) {
                    hamming_distance -= 2;
                    global_check = true;
                    break;
                }
            }
            if(global_check) break;
        }

        if(!global_check && l!=-1) hamming_distance--;
        else if(global_check){
            for(int i=0;i<n;i++) {
                if(t[i] == s[l-1] && s[i] == t[l-1]){
                    r = i + 1;
                    break;
                }
            }
        }
        w.println(hamming_distance);
        w.println(l+" "+r);

        w.close();
    }
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void sortbyColumn(int arr[][], int col){
        Arrays.sort(arr, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2){
                return(Integer.valueOf(o1[col]).compareTo(o2[col]));
            }
        });

    }
    public static class DJSet {
        public int[] upper;

        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }

        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }

        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }

        public boolean union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }
    }
    public static int[] radixSort(int[] f)    {
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
    }
    public void printArray(int[] a){
        for(int i=0;i<a.length;i++)
            w.print(a[i]+" ");
        w.println();
    }
    public int[] scanArrayI(int n){
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = c.nextInt();
        return a;
    }
    public long[] scanArrayL(int n){
        long a[] = new long[n];
        for(int i=0;i<n;i++)
            a[i] = c.nextLong();
        return a;
    }
    public void printArray(long[] a){
        for(int i=0;i<a.length;i++)
            w.print(a[i]+" ");
        w.println();
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String args[]) throws Exception {
        new Thread(null, new TaskA(),"TaskA",1<<26).start();
    }
}