import java.util.*;

public class Main {
	static int mod = 1000000007;
  static int size = 200000;
	static long[] fac = new long[size];
	static long[] finv = new long[size];
	static long[] inv = new long[size];
	static int INF = Integer.MAX_VALUE;

 	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String[] s = new String[2];
		for(int i = 0; i < 2; i++){
			s[i] = scanner.next();
		}
		int n = s[0].length();
		char[][] c = new char[2][n];
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < n; j++){
				c[i][j] = s[i].charAt(j);
			}
		}
		int count = 0;
		for(int i = 0; i < n-1; i++){
			if(c[0][i] == '0' && c[1][i] == '0' && c[0][i+1] == '0'){
				c[0][i] = 'X';
				c[1][i] = 'X';
				c[0][i+1] = 'X';
				count++;
			}
			if(c[0][i] == '0' && c[1][i] == '0' && c[1][i+1] == '0'){
				c[0][i] = 'X';
				c[1][i] = 'X';
				c[1][i+1] = 'X';
				count++;
			}
			if(c[0][i] == '0' && c[0][i+1] == '0' && c[1][i+1] == '0'){
				c[0][i] = 'X';
				c[0][i+1] = 'X';
				c[1][i+1] = 'X';
				count++;
			}
			if(c[0][i+1] == '0' && c[1][i+1] == '0' && c[1][i] == '0'){
				c[1][i] = 'X';
				c[0][i+1] = 'X';
				c[1][i+1] = 'X';
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean isPrime(int n){
		if(n == 1) return false;
		if(n == 2 || n == 3) return true;
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0) return false;
		}
		return true;
	}

	static boolean compare(String tar, String src) {
		if (src == null) return true;
		if (src.length() == tar.length()) {
			int len = tar.length();
			for (int i = 0; i < len; i++) {
				if (src.charAt(i) > tar.charAt(i)) {
					return false;
				} else if (src.charAt(i) < tar.charAt(i)) {
					return true;
				}
			}
			return tar.compareTo(src) > 0 ? true : false;
		} else if (src.length() < tar.length()) {
			return true;
		} else if (src.length() > tar.length()) {
			return false;
		}
		return false;
	}
	public static class Edge{
		int to;
		Edge(int to){
			this.to = to;
		}
	}
	public static void swap(long a, long b){
		long tmp = 0;
		if(a > b){
			tmp = a;
			a = b;
			b = tmp;
		}
	}
  static class Pair implements Comparable<Pair>{
    int first, second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return first == p.first && second == p.second;
    }
    @Override
    public int compareTo(Pair p){
        return first == p.first ? second - p.second : first - p.first;
        //return (first == p.first ? second - p.second : first - p.first) * -1;
        //return second == p.second ? first - p.first : second - p.second;
        //return (second == p.second ? first - p.first : second - p.second)*-1;
    }
  }

  public static long pow(long x, long n){
    long ans = 1;
    while(n > 0){
      if((n & 1) == 1){
        ans = ans * x;
        ans %= mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return ans;
  }

	public static long div(long x, long y){
		return (x*pow(y, mod-2))%mod;
	}

	public static  void initComb(){
		fac[0] = finv[0] = inv[0] = fac[1] = finv[1] = inv[1] = 1;
		for (int i = 2; i < size; ++i) {
			fac[i] = fac[i - 1] * i % mod;
			inv[i] = mod - (mod / i) * inv[(int) (mod % i)] % mod;
			finv[i] = finv[i - 1] * inv[i] % mod;
		}
	}

	public static long comb(int n, int k){
		return fac[n] * finv[k] % mod * finv[n - k] % mod;
	}

	public static long fact(int n){
		return fac[n];
	}

	public static long finv(int n){
		return finv[n];
	}

  static class UnionFind {
    int[] parent;
    public UnionFind(int size) {
      parent = new int[size];
      Arrays.fill(parent, -1);
    }
    public boolean unite(int x, int y) {
      x = root(x);
      y = root(y);
      if (x != y) {
        if (parent[y] < parent[x]) {
          int tmp = y;
          y = x;
          x = tmp;
        }
        parent[x] += parent[y];
        parent[y] = x;
        return true;
      }
      return false;
    }
    public boolean same(int x, int y) {
      return root(x) == root(y);
    }
    public int root(int x) {
      return parent[x] < 0 ? x : (parent[x] = root(parent[x]));
    }
    public int size(int x) {
      return -parent[root(x)];
    }
  }
	public static int upperBound(int[] array, int value) {
			 int low = 0;
			 int high = array.length;
			 int mid;
			 while( low < high ) {
					 mid = ((high - low) >>> 1) + low; // (high + low) / 2
					 if( array[mid] <= value ) {
							 low = mid + 1;
					 } else {
							 high = mid;
					 }
			 }
			 return low;
	 }
	 public static final int lowerBound(final int[] arr, final int value) {
    	int low = 0;
    	int high = arr.length;
    	int mid;
    	while (low < high){
        	mid = ((high - low) >>> 1) + low;
        	if (arr[mid] < value) {
          	low = mid + 1;
        	} else {
            high = mid;
        	}
    	}
    	return low;
		}

  public static long gcd(long n, long m){
    if(m > n) return gcd(m,n);
    if(m == 0) return n;
    return gcd(m, n%m);
  }

	private class Pair2 implements Comparable<Pair2> {
		String s;
		int p;
		int index;
		public Pair2(String s, int p, int index) {
				this.s = s;
				this.p = p;
				this.index = index;
		}

		public int compareTo(Pair2 other) {
				if (s.equals(other.s)) {
						return other.p - this.p;
				}
				return this.s.compareTo(other.s);
		}
	}

public static int c2i(char c){
	if('A' <= c && c <= 'Z'){
		return c - 'A';
	}else{
		return c - 'a' + 26;
	}
}

public static char i2c(int i){
	if(0 <= i && i < 26){
			return (char)(i + 'A');
	}else{
			return (char)(i + 'a' - 26);
	}
}

}
