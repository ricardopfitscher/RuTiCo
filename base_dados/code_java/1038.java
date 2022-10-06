import java.util.*;
 
import javax.lang.model.util.ElementScanner6;
 
import java.io.*;
 
public class Main {
 
    public static void main(String[] args) {
 
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
 
    }
 
 
 
 
 
    static class Solver {

        class pair implements Comparable<pair>{

            int i;
            long dist;
            public pair(int i,long dist)
            {
                this.i=i;
                this.dist=dist;
            }

            public int compareTo(pair p)
            {
                return Long.compare(this.dist,p.dist);
            }

        }
 
        class Node implements Comparable < Node > {
            int i;
            int cnt;
 
            Node(int i, int cnt) {
                this.i = i;
                this.cnt = cnt;
            }
 
            public int compareTo(Node n) {
                if (this.cnt == n.cnt) {
                    return Integer.compare(this.i, n.i);
                }
                return Integer.compare(this.cnt, n.cnt);
            }
        }
 
        public boolean done(int[] sp, int[] par) {
            int root;
 
            root = findSet(sp[0], par);
 
            for (int i = 1; i < sp.length; i++) {
                if (root != findSet(sp[i], par))
                    return false;
            }
            return true;
        }
        public int findSet(int i, int[] par) {
            int x = i;
            boolean flag = false;
            while (par[i] >= 0) {
                flag = true;
                i = par[i];
            }
            if (flag)
                par[x] = i;
            return i;
        }
 
        public void unionSet(int i, int j, int[] par) {
            int x = findSet(i, par);
            int y = findSet(j, par);
            if (x < y) {
                par[y] = x;
            } else {
                par[x] = y;
            }
        }
 
        public long pow(long a, long b, long MOD) {
            if (b == 0) {
                return 1;
            }
            if (b == 1) {
                return a;
            }
            long val = pow(a, b / 2, MOD);
            if (b % 2 == 0) {
                return val * val % MOD;
            } else {
                return val * (val * a % MOD) % MOD;
 
            }
 
        }

        public boolean isPrime(int n)
        {
            for(int i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    return false;
                }
            }
            return true;
        }
 
 
        public void minPrimeFactor(int n, int[] s) {
            boolean prime[] = new boolean[n + 1];
            Arrays.fill(prime, true);
            s[1] = 1;
            s[2] = 2;
            for (int i = 4; i <= n; i += 2) {
                prime[i] = false;
                s[i] = 2;
            }
 
            for (int i = 3; i <= n; i += 2) {
                if (prime[i]) {
                    s[i] = i;
                    for (int j = 2 * i; j <= n; j += i) {
                        prime[j] = false;
                        s[j] = i;
                    }
                }
            }
 
        }
 
 
        public void findAllPrime(int n, ArrayList < Node > al, int s[]) {
            int curr = s[n];
            int cnt = 1;
            while (n > 1) {
                n /= s[n];
                if (curr == s[n]) {
                    cnt++;
                    continue;
 
                }
                Node n1 = new Node(curr, cnt);
                al.add(n1);
 
                curr = s[n];
                cnt = 1;
            }
        }
 
 
 
        public int binarySearch(int n, int k) {
            int left = 1;
            int right = 100000000 + 5;
            int ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (n / mid >= k) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
 
            return ans;
        }
        public boolean checkPallindrom(String s) {
            char ch[] = s.toCharArray();
 
            for (int i = 0; i < s.length() / 2; i++) {
                if (ch[i] != ch[s.length() - 1 - i])
                    return false;
            }
            return true;
        }
 
 
 
 
        public void remove(ArrayList < Integer > [] al, int x) {
            for (int i = 0; i < al.length; i++) {
                for (int j = 0; j < al[i].size(); j++) {
 
                    if (al[i].get(j) == x)
                        al[i].remove(j);
 
                }
            }
        }
 
        public long gcd(long a, long b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }
 
 
        public void printDivisors(long n, ArrayList < Long > al) {
            // Note that this loop runs till square root 
            for (long i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    // If divisors are equal, print only one 
                    if (n / i == i) {
                        al.add(i);
                    } else // Otherwise print both 
                    {
                        al.add(i);
                        al.add(n / i);
                    }
 
                }
            }
        }
 
        public static long constructSegment(long seg[], long arr[], int low, int high, int pos) {
            if (low == high) {
                seg[pos] = arr[low];
                return seg[pos];
            }
            int mid = (low + high) / 2;
            long t1 = constructSegment(seg, arr, low, mid, (2 * pos) + 1);
            long t2 = constructSegment(seg, arr, mid + 1, high, (2 * pos) + 2);
            seg[pos] = t1 + t2;
            return seg[pos];
 
        }
        public static long querySegment(long seg[], int low, int high, int qlow, int qhigh, int pos) {
 
            if (qlow <= low && qhigh >= high) {
                return seg[pos];
            } else if (qlow > high || qhigh < low) {
                return 0;
            } else {
                long ans = 0;
                int mid = (low + high) / 2;
                ans += querySegment(seg, low, mid, qlow, qhigh, (2 * pos) + 1);
                ans += querySegment(seg, mid + 1, high, qlow, qhigh, (2 * pos) + 2);
                return ans;
            }
 
        }
        public static int lcs(char[] X, char[] Y, int m, int n) {
            if (m == 0 || n == 0)
                return 0;
            if (X[m - 1] == Y[n - 1])
                return 1 + lcs(X, Y, m - 1, n - 1);
            else
                return Integer.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
        }
 
        public static long recursion(long start, long end, long cnt[], int a, int b) {
 
            long min = 0;
            long count = 0;
            int ans1 = -1;
            int ans2 = -1;
            int l = 0;
            int r = cnt.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (cnt[mid] >= start) {
                    ans1 = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
 
            l = 0;
            r = cnt.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (cnt[mid] <= end) {
                    ans2 = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
 
            if (ans1 == -1 || ans2 == -1 || ans2 < ans1) {
                // System.out.println("min1 "+min);
                min = a;
                return a;
 
            } else {
                min = b * (end - start + 1) * (ans2 - ans1 + 1);
            }
            if (start == end) {
                // System.out.println("min "+min);
                return min;
            }
            long mid = (end + start) / 2;
            min = Long.min(min, recursion(start, mid, cnt, a, b) + recursion(mid + 1, end, cnt, a, b));
            // System.out.println("min "+min);
            return min;
        }
 
 
 
 
 
        public int dfs_util(ArrayList < Integer > [] al, boolean vis[], int x, int[] s, int lvl[]) {
 
            vis[x] = true;
            int cnt = 1;
            for (int i = 0; i < al[x].size(); i++) {
 
                if (!vis[al[x].get(i)]) {
                    lvl[al[x].get(i)] = lvl[x] + 1;
                    cnt += dfs_util(al, vis, al[x].get(i), s, lvl);
 
 
                }
 
 
            }
            s[x] = cnt;
            return s[x];
        }
 
        public void dfs(ArrayList[] al, int[] s, int[] lvl) {
 
            boolean vis[] = new boolean[al.length];
            for (int i = 0; i < al.length; i++) {
                if (!vis[i]) {
                    lvl[i] = 1;
                    dfs_util(al, vis, i, s, lvl);
                }
            }
        }
 
        public int[] computeLps(String s)
        {
            int ans[] =new int[s.length()];
            char ch[] = s.toCharArray();
            int n = s.length();
            int i=1;
            int len=0;
            ans[0]=0;
            while(i<n)
            {
                if(ch[i]==ch[len])
                {
                    len++;
                    ans[i]=len;
                    i++;
                }
                else
                {
                    if(len!=0)
                    {
                        len=ans[len-1];
                    }
                    else
                    {
                        ans[i]=len;
                        i++;
                    }
                }
            }

            return ans;

        }
 
 
        private void solve(InputReader inp, PrintWriter out1) {
            int n = inp.nextInt();
            int m = inp.nextInt();
            long k = inp.nextLong();
            long arr[] = new long[n];

            for(int i=0;i<n;i++)
            {
                arr[i] = inp.nextLong();

            }
            long ans=0;
            for(int i=0;i<m;i++)
            {
                long sum=0;
                for(int j=i;j<n;j++)
                {
                    

                    if(j%m==i)
                    {
                        if(sum<0)
                        {
                           sum=0;
                        }
                        sum-=k;
                    }
                    
                    sum+=arr[j];
                    
                    ans=Math.max(ans,sum);
                }

            

            }

            System.out.println(ans);
           

           
            
        }
 
 
}
 
 
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
class ele implements Comparable < ele > {
    int value;
    int i;
    boolean flag;
    public ele(int value, int i) {
        this.value = value;
        this.i = i;
        this.flag = false;
    }
    public int compareTo(ele e) {
        return Integer.compare(this.value, e.value);
    }
}