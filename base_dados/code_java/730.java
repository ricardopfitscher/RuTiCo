import java.io.*;
import java.util.*;

public class E implements Runnable{
	public static void main (String[] args) {new Thread(null, new E(), "_cf", 1 << 28).start();}

	int MAX = 511, MOD = 998244353, INV = 499122177;

	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		int n = fs.nextInt();
		int k = fs.nextInt();
		if(n == 1) {
			System.out.println(0);
			return;
		}
		
		int[][] dp = new int[MAX][MAX];
		dp[1][1] = 2;
		for(int pos = 0; pos < n; pos++) {
			int[][] ndp = new int[MAX][MAX];
			
			for(int i = 1; i <= Math.min(k, n); i++) {
				for(int j = 1; j <= Math.min(k, n); j++) {
					int nm = Math.max(i, j+1);
					ndp[nm][j+1] = add(ndp[nm][j+1], dp[i][j]);
					ndp[i][1] = add(ndp[i][1], dp[i][j]);
					
				}
			}
			if(pos != n-1)
				dp = ndp;
		}

		int[] nums = new int[MAX];
		int[] div2 = new int[MAX];
		for(int i = 1; i <= Math.min(n, k); i++) {
			for(int j = 1; j <= Math.min(n, k); j++) {
				nums[i] = add(nums[i], dp[i][j]);
			}
		}
		for(int i = 1; i <= n; i++) div2[i] = mult(nums[i], INV);

		int res = 0;
		for(int i = 1; i <= Math.min(n, k); i++) {
			for(int j = 1; j <= Math.min(n, k); j++) {
				if(i * j < k) {
					res = add(res, mult(2, mult(div2[i], div2[j])));
				}
			}
		}
		
		out.println(res);
		out.close();
	}
	
	int mult(int a, int b) {
		long aa = a;
		if(aa >= MOD) aa -= MOD;
		if(b >= MOD) b -= MOD;
		aa *= b;
		if(aa >= MOD) aa %= MOD;
		return (int)aa;
	}
	
	int add(int a, int b) {
		if(a >= MOD) a -= MOD;
		if(b >= MOD) b -= MOD;
		a += b;
		if(a >= MOD) a-= MOD;
		return a;
	}

	void sort (int[] a) {
		int n = a.length;
		for(int i = 0; i < 50; i++) {
			Random r = new Random();
			int x = r.nextInt(n), y = r.nextInt(n);
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		Arrays.sort(a);
	}

	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}

}