import java.util.*;
import java.awt.List;
import java.io.*;
import java.lang.*;

public  class graph {

	public static long mod = (long) Math.pow(10, 9) + 7;
	public static InputReader in = new InputReader(System.in);
	public static PrintWriter pw = new PrintWriter(System.out);
	public static ArrayList<Integer>[] adj;
	public static ArrayList<Integer>[] child;

	public static long[] v;
	public static int[] dis;
	public static int[] fin;
	public static int  count = 0;
	
	public static long[] w;
	public static boolean[] vis;
	public static boolean[] l;
	
	public static long[] gcd;
	
	public static void main(String[] args) {

		// Code starts..

		
		
		
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		vis = new boolean[n+1];

		dis = new int[n+1];
		fin = new int[n+1];
		adj = new ArrayList[n+1];
		for(int i=0; i<=n; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<n-1; i++)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			
			
			adj[u].add(v);
			adj[v].add(u);
			
		}
		
		
		count=1;
		dfs(x);
		dis[x] = 0;
		long a1 = count(y)+1;
//		for(int i=1; i<=n; i++)
//			pw.println(dis[i]+" "+fin[i]);
//		
//		pw.println(a1);
		
		count=1;
		vis = new boolean[n+1];
		dfs(y);
		dis[y] = 0;
		long a2 = count(x)+1;
//		for(int i=1; i<=n; i++)
//			pw.println(dis[i]+" "+fin[i]);
////		
		
//		pw.println(a1+" "+a2);
		pw.print(n*(long)(n-1) - a1*a2);
		
		
		
				
		
		
		// code ends...

		pw.flush();
		pw.close();
		
		
	}
	
	
	
	/*
	 * public static void dfs(int s) {
	 * 
	 * vis[s] = true; for(int p: adj[s]) { par[p] = s; if(!vis[p]) { dfs(p); val[s]
	 * += val[p]; vis[p] = true; }
	 * }
	 * }
	 */	

	
	public static void dfs(int s) {
		
		vis[s] = true;
		
		for(int p: adj[s])
		{
			if(!vis[p])
			{
				dis[p] = count++;
				vis[p] = true;
				dfs(p);
			}
		}
		
		fin[s] = count++;
		
	}
	
	public static int count(int x)
	{
		int ans = 0;
		for(int i=1; i<=vis.length-1; i++)
		{
			if(dis[i] > dis[x] && fin[i] < fin[x])
			{
//				System.out.println(i);
				ans++;
			}
		}
		return ans;
	}
	
	
	

	public static void bfs(int s) {

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
		while (!que.isEmpty()) {
			int p = que.poll();
			vis[p] = true;
			for (int q : adj[p]) {
				if (!vis[q])
				{
					que.add(q);
					vis[q] = true;
					child[p].add(q);
				}
				
			}
		}

	}
	public static int[] bfs2(int s, int k, int n) {

		int[] ans = new int[2];
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
//		pw.println(s+"--"+k);
		ans[1] = s;
		if(s>n)
			return ans; 
		ans[0] = (int) (w[s] ^ k);
		while (!que.isEmpty()) {
			int p = que.poll();
			for (int q : child[p]) {
				if((w[q] ^ k) > ans[0] || ((w[q] ^ k)==k && q < ans[1]))
				{
					ans[0] = (int) (w[q] ^ k);
					ans[1] = q;
				}
				
			}
		}

		return ans;
	}
	
	public static long bs(long[] a, long k, long m) {
		long l = 0;
		long r = a.length+1;
		long mid = 0;
		long ans = -1;
		
		while (r - l > 0) {
			
			mid = (r + l) / 2;
			boolean flag = fun(a, k, m, mid);
			if(flag)
			{
				ans = mid;
				r = mid;
			}
			else
				l = mid+1;
		
			
		}

		return ans;
	}

	public static boolean fun(long[] a, long k, long m, long mid) {
		// pw.println(mid);
		int n = a.length;
		long cur = 0;
		for (int i = 0; i < m; i++) {
			long min = (long) Math.ceil((a[n - 2] - cur) / (m - i));
			long ll = 0;
			if (cur - 1 >= 0)
				ll = lowerboundArray(a, cur - 1) + 1;
			long max = 0;
			if (ll + mid <= n - 2)
				max = a[(int) (ll + mid)] - 1;
			else
				max = a[n - 1];

			if (max < min)
				return false;
			cur = Math.min(cur + k, max);
			// pw.println(ll+" "+max+" "+cur+" ");
		}
		// pw.print(cur);
		if (cur >= a[n - 2])
			return true;
		else
			return false;

	}
	
	
	public static Comparator<Integer> cmp = new Comparator<Integer>() {
		@Override
		public int compare(Integer t1, Integer t2) {
			return t2 - t1;
		}
	};
	
	public static int lcs(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				if (L[i][j] >= 100)
					return 100;
			}

		}
		return L[m][n];
	}

	public static void factSieve(int[] fact, long n) {

		for (int i = 2; i <= n; i += 2)
			fact[i] = 2;

		for (int i = 3; i <= n; i += 2) {
			if (fact[i] == 0) {
				fact[i] = i;

				for (int j = i; (long) j * i <= n; j++) {
					fact[(int) ((long) i * j)] = i;
				}
			}
		}

		/*
		 * int k = 1000; while(k!=1) { System.out.print(a[k]+" "); k /= a[k];
		 * 
		 * }
		 */
	}

	public static int gcd(int p2, int p22) {
		if (p2 == 0)
			return (int) p22;
		return gcd(p22 % p2, p2);
	}

	public static void nextGreater(long[] a, int[] ans) {

		Stack<Integer> stk = new Stack<>();
		stk.push(0);

		for (int i = 1; i < a.length; i++) {

			if (!stk.isEmpty()) {
				int s = stk.pop();
				while (a[s] < a[i]) {
					ans[s] = i;
					if (!stk.isEmpty())
						s = stk.pop();
					else
						break;
				}
				if (a[s] >= a[i])
					stk.push(s);
			}

			stk.push(i);

		}
		return;

	}

	public static void nextGreaterRev(long[] a, int[] ans) {

		int n = a.length;
		int[] pans = new int[n];
		Arrays.fill(pans, -1);
		long[] arev = new long[n];
		for (int i = 0; i < n; i++)
			arev[i] = a[n - 1 - i];

		Stack<Integer> stk = new Stack<>();
		stk.push(0);

		for (int i = 1; i < n; i++) {

			if (!stk.isEmpty()) {
				int s = stk.pop();
				while (arev[s] < arev[i]) {
					pans[s] = n - i - 1;
					if (!stk.isEmpty())
						s = stk.pop();
					else
						break;
				}
				if (arev[s] >= arev[i])
					stk.push(s);
			}

			stk.push(i);

		}

		// for(int i=0; i<n; i++)
		// System.out.print(pans[i]+" ");

		for (int i = 0; i < n; i++)
			ans[i] = pans[n - i - 1];

		return;

	}

	public static void nextSmaller(long[] a, int[] ans) {

		Stack<Integer> stk = new Stack<>();
		stk.push(0);

		for (int i = 1; i < a.length; i++) {

			if (!stk.isEmpty()) {
				int s = stk.pop();
				while (a[s] > a[i]) {
					ans[s] = i;
					if (!stk.isEmpty())
						s = stk.pop();
					else
						break;
				}
				if (a[s] <= a[i])
					stk.push(s);
			}

			stk.push(i);

		}
		return;

	}

	public static long lcm(int[] numbers) {
		long lcm = 1;
		int divisor = 2;
		while (true) {
			int cnt = 0;
			boolean divisible = false;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == 0) {
					return 0;
				} else if (numbers[i] < 0) {
					numbers[i] = numbers[i] * (-1);
				}
				if (numbers[i] == 1) {
					cnt++;
				}
				if (numbers[i] % divisor == 0) {
					divisible = true;
					numbers[i] = numbers[i] / divisor;
				}
			}
			if (divisible) {
				lcm = lcm * divisor;
			} else {
				divisor++;
			}
			if (cnt == numbers.length) {
				return lcm;
			}
		}
	}

	public static long fact(long n) {

		long factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static long choose(long total, long choose) {
		if (total < choose)
			return 0;
		if (choose == 0 || choose == total)
			return 1;
		return (choose(total - 1, choose - 1) + choose(total - 1, choose)) % mod;
	}

	public static int[] suffle(int[] a, Random gen) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int ind = gen.nextInt(n - i) + i;
			int temp = a[ind];
			a[ind] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static int[] sort(int[] a) {
		int n = a.length;
		Random gen = new Random();
		for (int i = 0; i < n; i++) {
			int ind = gen.nextInt(n - i) + i;
			int temp = a[ind];
			a[ind] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
		return a;
	}
	

	public static long[] sort(long[] a) {
		int n = a.length;
		Random gen = new Random();
		for (int i = 0; i < n; i++) {
			int ind = gen.nextInt(n - i) + i;
			long temp = a[ind];
			a[ind] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
		return a;
	}


	public static int floorSearch(int arr[], int low, int high, int x) {
		if (low > high)
			return -1;

		if (x > arr[high])
			return high;
		int mid = (low + high) / 2;

		if (mid > 0 && arr[mid - 1] < x && x < arr[mid])
			return mid - 1;

		if (x < arr[mid])
			return floorSearch(arr, low, mid - 1, x);

		return floorSearch(arr, mid + 1, high, x);
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static ArrayList<Integer> primeFactorization(int n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				a.add(i);
				n /= i;
			}
		}
		if (n != 1)
			a.add(n);
		return a;
	}

	public static void sieve(boolean[] isPrime, int n) {
		for (int i = 1; i < n; i++)
			isPrime[i] = true;

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i < n; i++) {
			if (isPrime[i] == true) {
				for (int j = (2 * i); j < n; j += i)
					isPrime[j] = false;
			}
		}
	}

	public static int lowerbound(ArrayList<Long> net, long c2) {
		int i = Collections.binarySearch(net, c2);
		if (i < 0)
			i = -(i + 2);
		return i;

	}

	public static int lowerboundArray(long[] a, long cur) {
		int i = Arrays.binarySearch(a, cur);

		if (i < 0)
			i = -(i + 2);
		return i;

	}

	public static int uperbound(ArrayList<Integer> list, int c2) {
		int i = Collections.binarySearch(list, c2);
		if (i < 0)
			i = -(i + 1);
		return i;

	}

	public static int uperboundArray(int[] dis, int c2) {
		int i = Arrays.binarySearch(dis, c2);
		if (i < 0)
			i = -(i + 1);
		return i;

	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}

	public static long GCD(long a, long b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}

	public static int d1;
	public static int p1;
	public static int q1;

	public static void extendedEuclid(int A, int B) {
		if (B == 0) {
			d1 = A;
			p1 = 1;
			q1 = 0;
		} else {
			extendedEuclid(B, A % B);
			int temp = p1;
			p1 = q1;
			q1 = temp - (A / B) * q1;
		}
	}

	public static long LCM(long a, long b) {
		return (a / GCD(a, b))*b;
	}

	public static int LCM(int a, int b) {
		return (a * b) / GCD(a, b);
	}

	public static int binaryExponentiation(int x, int n) {
		int result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = result * x;
			x = x * x;
			n = n / 2;
		}
		return result;
	}

	public static int[] countDer(int n) {
		int der[] = new int[n + 1];

		der[0] = 1;
		der[1] = 0;
		der[2] = 1;

		for (int i = 3; i <= n; ++i)
			der[i] = (i - 1) * (der[i - 1] + der[i - 2]);

		// Return result for n
		return der;
	}

	static long binomialCoeff(int n, int k) {
		long C[][] = new long[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using previosly stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[n][k];
	}

	public static long binaryExponentiation(long x, long n) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = result * x;
			x = (x % mod * x % mod) % mod;
			n = n / 2;
		}
		return result;
	}

	public static int modularExponentiation(int x, int n, int M) {
		int result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	public static long modularExponentiation(long x, long n, long M) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	public static long pow(long x, long n, long M) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	public static long modInverse(long q, long mod2) {
		return modularExponentiation(q, mod2 - 2, mod2);
	}

	public static long sie(long A, long M) {
		return modularExponentiation(A, M - 2, M);
	}

	public static boolean isPrime(int n) {

		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}

		return true;
	}

	static class pair implements Comparable<pair>

	{
		Long x, y;

		pair(long bi, long wi) {
			this.x = bi;
			this.y = wi;
		}

		public int compareTo(pair o) {
			int result = x.compareTo(o.x);
			if (result == 0)
				result = y.compareTo(o.y);

			return result;
		}

		public String toString() {
			return x + " " + y;
		}

		public boolean equals(Object o) {
			if (o instanceof pair) {
				pair p = (pair) o;
				return (p.x -x == 0) && (p.y  - y == 0);
			}
			return false;
		}

		public int hashCode() {
			return new Long(x).hashCode() * 31 + new Long(y).hashCode();
		}

	}

	
	static class tripletD implements Comparable<tripletD>

	{
		Double x, y, z;

		tripletD(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int compareTo(tripletD o) {
			int result = x.compareTo(o.x);
			if (result == 0) {
				double x1 = o.x + o.y;
				result = ((Double) x1).compareTo((double) (x + y));
			}

			return result;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public boolean equals(Object o) {
			if (o instanceof tripletD) {
				tripletD p = (tripletD) o;
				return (p.x - x == 0) && (p.y - y==0)  && (p.z - z==0);
			}
			return false;
		}

		public int hashCode() {
			return new Double(x).hashCode() * 31 + new Double(y).hashCode();
		}

	}

	static class tripletL implements Comparable<tripletL> {
		Long x, y, z;

		tripletL(long x, long y, long z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int compareTo(tripletL o) {
			int result = x.compareTo(o.x);
			if (result == 0)
				result = y.compareTo(o.y);
			if (result == 0)
				result = z.compareTo(o.z);

			return result;
		}

		public boolean equlas(Object o) {
			if (o instanceof tripletL) {
				tripletL p = (tripletL) o;
				return (x - p.x == 0) && (y - p.y ==0 ) && (z - p.z == 0);
			}
			return false;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int hashCode() {
			return new Long(x).hashCode() * 31 + new Long(y).hashCode() + new Long(z).hashCode();
		}
	}
	
	static class triplet implements Comparable<triplet> {
		Integer x, y, z;

		triplet(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int compareTo(triplet o) {
			int result = x.compareTo(o.x);
			if (result == 0)
				result = y.compareTo(o.y);
			if (result == 0)
				result = z.compareTo(o.z);

			return result;
		}

		public boolean equlas(Object o) {
			if (o instanceof triplet) {
				triplet p = (triplet) o;
				return (x - p.x == 0) && (y - p.y == 0) && (z - p.z == 0);
			}
			return false;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int hashCode() {
			return new Long(x).hashCode() * 31 + new Long(y).hashCode() + new Long(z).hashCode();
		}
	}
	
	/*
	 * static class node implements Comparable<node>
	 * 
	 * { Integer x, y, z; node(int x,int y, int z) { this.x=x; this.y=y; this.z=z; }
	 * 
	 * public int compareTo(pair o) { int result = x.compareTo(o.x); if(result==0)
	 * result = y.compareTo(o.y); if(result==0) result = z.compareTo(z); return
	 * result; }
	 * 
	 * @Override public int compareTo(node o) { // TODO Auto-generated method stub
	 * return 0; } }
	 */


  static class InputReader {
  
  private final InputStream stream; private final byte[] buf = new byte[8192];
  private int curChar, snumChars; private SpaceCharFilter filter;
  
  public InputReader(InputStream stream) { this.stream = stream; }
  
  public int snext() { if (snumChars == -1) throw new InputMismatchException();
  if (curChar >= snumChars) { curChar = 0; try { snumChars = stream.read(buf);
  } catch (IOException e) { throw new InputMismatchException(); } if (snumChars
  <= 0) return -1; } return buf[curChar++]; }
  
  public int nextInt() { int c = snext(); while (isSpaceChar(c)) { c = snext();
  } int sgn = 1; if (c == '-') { sgn = -1; c = snext(); } int res = 0; do { if
  (c < '0' || c > '9') throw new InputMismatchException(); res *= 10; res += c
  - '0'; c = snext(); } while (!isSpaceChar(c)); return res * sgn; }
  
  public long nextLong() { int c = snext(); while (isSpaceChar(c)) { c =
  snext(); } int sgn = 1; if (c == '-') { sgn = -1; c = snext(); } long res =
  0; do { if (c < '0' || c > '9') throw new InputMismatchException(); res *=
  10; res += c - '0'; c = snext(); } while (!isSpaceChar(c)); return res * sgn;
  }
  
  public int[] nextIntArray(int n) { int a[] = new int[n]; for (int i = 0; i <
  n; i++) { a[i] = nextInt(); } return a; }
  
  public String readString() { int c = snext(); while (isSpaceChar(c)) { c =
  snext(); } StringBuilder res = new StringBuilder(); do {
  res.appendCodePoint(c); c = snext(); } while (!isSpaceChar(c)); return
  res.toString(); }
  
  public String nextLine() { int c = snext(); while (isSpaceChar(c)) c =
  snext(); StringBuilder res = new StringBuilder(); do {
  res.appendCodePoint(c); c = snext(); } while (!isEndOfLine(c)); return
  res.toString(); }
  
  public boolean isSpaceChar(int c) { if (filter != null) return
  filter.isSpaceChar(c); return c == ' ' || c == '\n' || c == '\r' || c == '\t'
  || c == -1; }
  
  private boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c ==
  -1; }
  
  public interface SpaceCharFilter { public boolean isSpaceChar(int ch); } }
  
  }
 