
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static Scanner sc;
    private static Printer pr;
    static boolean []visited;
    static int []color;
    static int []pow=new int[(int)3e5+1];
    static int []count;
    static boolean check=true;
    static boolean checkBip=true;
    static ArrayList<Integer>[]list;
    private static long aLong=(long)(Math.pow(10,9)+7);
    static final long div=998244353;
    static  int answer=0;
    static int[]countSubTree;
    static int cnt=0;
    private static void solve() throws IOException {
        int n=sc.nextInt(),k1=sc.nextInt(),k2=sc.nextInt();
        int op=k1+k2;
        int []arrA=new int[n];
        int []arrB=new int[n];
        PriorityQueue<Integer>integers=new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<n;i++) arrA[i]=sc.nextInt();
        for (int i=0;i<n;i++) arrB[i]=sc.nextInt();
        for (int i=0;i<n;i++){
            int sub=Math.abs(arrA[i]-arrB[i]);
            if (sub!=0) integers.add(sub);
        }
        long sum=0;
        //System.out.println(integers);
        if (integers.size()==0){
            System.out.println(sum+(op%2));
            System.exit(0);
        }
        boolean b=true;
        int rem=0;
        for (int i=1;i<=op;i++){
            if (integers.size()!=0) {
                int max = integers.remove();
                if (max != 0) {
                    max--;
                    integers.add(max);
                } else {
                    rem = (op - i + 1) % 2;
                    //System.out.println("i:"+i);
                    //System.out.println("rem:"+rem);
                    b = false;
                    break;
                }
            }
        }
        if (!b) sum+=rem;
        else {
            for (int i:integers){
                sum+=Math.pow(i,2);
            }
        }
        pr.println(sum);
        //pr.println(sum);
    }
    public static class pairTask implements Comparable<pairTask>{
        long x,y;
        public pairTask(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pairTask o) {
            if (o.x<this.x)return 1;
            else if (o.x>this.x)return -1;
            return 0;
        }
    }
    public static void subTree(int src,int parent){
        countSubTree[src]=1;
        for (int v:list[src]){
            if (v==parent)
                continue;
            subTree(v,src);
            countSubTree[src]+=countSubTree[v];
        }
    }
    public static boolean prime(int src){
        for (int i=2;i*i<=src;i++){
            if (src%i==0)
                return false;
        }
        return true;
    }
    public static void bfsColor(int src){
        Queue<Integer>queue = new ArrayDeque<>();
        queue.add(src);
        while (!queue.isEmpty()){
            boolean b=false;
            int vertex=-1,p=-1;
            int poll=queue.remove();
            for (int v:list[poll]){
                if (color [v]==0){
                    vertex=v;
                    break;
                }
            }
            for (int v:list[poll]){
                if (color [v]!=0&&v!=vertex){
                    p=v;
                    break;
                }
            }
            for (int v:list[p]){
                if (color [v]!=0){
                    color[vertex]=color[v];
                    b=true;
                    break;
                }
            }
            if (!b){
                color[vertex]=color[poll]+1;
            }
        }
    }
    static int add(int a,int b ){
        if (a+b>=div)
            return (int)(a+b-div);
        return (int)a+b;
    }
    public static int isBipartite(ArrayList<Integer>[]list,int src){
        color[src]=0;
        Queue<Integer>queue=new LinkedList<>();
        int []ans={0,0};
        queue.add(src);
        while (!queue.isEmpty()){
            ans[color[src=queue.poll()]]++;
            for (int v:list[src]){
                if (color[v]==-1){
                    queue.add(v);
                    color[v]=color[src]^1;
                }else if (color[v]==color[src])
                    check=false;
            }
        }
        return add(pow[ans[0]],pow[ans[1]]);
    }
    public static int powerMod(long b, long e){
        long ans=1;
        while (e-->0){
            ans=ans*b%div;
        }
        return (int)ans;
    }
    public static int dfs(int s){
        int ans=1;
        visited[s]=true;
        for (int k:list[s]){
            if (!visited[k]){
                ans+=dfs(k);
            }
        }
        return ans;
    }
    public static int[] radixSort(int[] f) {
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) b[1 + (f[i] & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < f.length; i++) to[b[f[i] & 0xffff]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) b[1 + (f[i] >>> 16)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < f.length; i++) to[b[f[i] >>> 16]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        return f;
    }
    public static long []primeFactor(int n){
        long []prime=new long[n+1];
        prime[1]=1;
        for (int i=2;i<=n;i++)
            prime[i]=((i&1)==0)?2:i;
        for (int i=3;i*i<=n;i++){
            if (prime[i]==i){
                for (int j=i*i;j<=n;j+=i){
                    if (prime[j]==j)
                        prime[j]=i;
                }
            }
        }
        return prime;
    }
    public static StringBuilder binaryradix(long number){
        StringBuilder builder=new StringBuilder();
        long remainder;
        while (number!=0) {
            remainder = number % 2;
            number >>= 1;
            builder.append(remainder);
        }
        builder.reverse();
        return builder;
    }
    public static int binarySearch(long[] a, int index,long target) {
            int l = index;
            int h = a.length - 1;
            while (l<=h) {
                int med = l + (h-l)/2;
                if(a[med] - target <= target) {
                    l = med + 1;
                }
                else h = med  - 1;
            }
            return h;
    }
    public static int val(char c){
        return c-'0';
    }
    public static long gcd(long a,long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
        private static class Pair implements Comparable<Pair> {
            long x;
            long y;

            Pair() {
                this.x = 0;
                this.y = 0;
            }

            Pair(long x, long y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) return false;
                Pair other = (Pair) obj;
                if (this.x == other.x && this.y == other.y) {
                    return true;
                }
                return false;
            }

            @Override
            public int compareTo(Pair other) {
                if (this.x != other.x) return Long.compare(this.x, other.x);
                return Long.compare(this.y*other.x, this.x*other.y);
            }
    }

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pr = new Printer(System.out);
        solve();

        pr.close();
       // sc.close();
    }
    private static class Scanner {
        BufferedReader br;

        Scanner (InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        private boolean isPrintable(int ch) {
            return ch >= '!' && ch <= '~';
        }

        private boolean isCRLF(int ch) {
            return ch == '\n' || ch == '\r' || ch == -1;
        }

        private int nextPrintable() {
            try {
                int ch;
                while (!isPrintable(ch = br.read())) {
                    if (ch == -1) {
                        throw new NoSuchElementException();
                    }
                }

                return ch;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        String next() {
            try {
                int ch = nextPrintable();
                StringBuilder sb = new StringBuilder();
                do {
                    sb.appendCodePoint(ch);
                } while (isPrintable(ch = br.read()));

                return sb.toString();
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        int nextInt() {
            try {
                // parseInt from Integer.parseInt()
                boolean negative = false;
                int res = 0;
                int limit = -Integer.MAX_VALUE;
                int radix = 10;

                int fc = nextPrintable();
                if (fc < '0') {
                    if (fc == '-') {
                        negative = true;
                        limit = Integer.MIN_VALUE;
                    } else if (fc != '+') {
                        throw new NumberFormatException();
                    }
                    fc = br.read();
                }
                int multmin = limit / radix;

                int ch = fc;
                do {
                    int digit = ch - '0';
                    if (digit < 0 || digit >= radix) {
                        throw new NumberFormatException();
                    }
                    if (res < multmin) {
                        throw new NumberFormatException();
                    }
                    res *= radix;
                    if (res < limit + digit) {
                        throw new NumberFormatException();
                    }
                    res -= digit;

                } while (isPrintable(ch = br.read()));

                return negative ? res : -res;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        long nextLong() {
            try {
                // parseLong from Long.parseLong()
                boolean negative = false;
                long res = 0;
                long limit = -Long.MAX_VALUE;
                int radix = 10;

                int fc = nextPrintable();
                if (fc < '0') {
                    if (fc == '-') {
                        negative = true;
                        limit = Long.MIN_VALUE;
                    } else if (fc != '+') {
                        throw new NumberFormatException();
                    }
                    fc = br.read();
                }
                long multmin = limit / radix;

                int ch = fc;
                do {
                    int digit = ch - '0';
                    if (digit < 0 || digit >= radix) {
                        throw new NumberFormatException();
                    }
                    if (res < multmin) {
                        throw new NumberFormatException();
                    }
                    res *= radix;
                    if (res < limit + digit) {
                        throw new NumberFormatException();
                    }
                    res -= digit;

                } while (isPrintable(ch = br.read()));

                return negative ? res : -res;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                int ch;
                while (isCRLF(ch = br.read())) {
                    if (ch == -1) {
                        throw new NoSuchElementException();
                    }
                }
                StringBuilder sb = new StringBuilder();
                do {
                    sb.appendCodePoint(ch);
                } while (!isCRLF(ch = br.read()));

                return sb.toString();
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
//				throw new NoSuchElementException();
            }
        }
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

    }

    static class List {
        String Word;
        int length;

        List(String Word, int length) {
            this.Word = Word;
            this.length = length;
        }
    }
    private static class Printer extends PrintWriter {
        Printer(PrintStream out) {
            super(out);
        }
    }
}