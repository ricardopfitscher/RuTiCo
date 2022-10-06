import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
	static FastReader scan;
	static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		Solver solver = new Solver();
		scan = new FastReader();
		out = new PrintWriter(System.out);
		int testCases = 1;
		for(int i = 1; i <= testCases; i++) {
//			out.print("Case #" + i + ": ");
			solver.solve();
		}
		out.close();
	}

	static class Solver {
		
		void solve() {
			int a = scan.nextInt(), b = scan.nextInt();
			if(b <= a) out.println(1);
			else out.println(b/a + Math.min(1, b%a));
		}
		
	}

	// Sathvik's Template Stuff BELOW!!!!!!!!!!!!!!!!!!!!!!

	static class DSU {
		int[] root, size;
		int n;

		DSU(int n) {
			this.n = n;
			root = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
				size[i] = 1;
			}
		}

		int findParent(int idx) {
			while (root[idx] != idx) {
				root[idx] = root[root[idx]];
				idx = root[idx];
			}
			return idx;
		}

		boolean union(int x, int y) {
			int parX = findParent(x);
			int parY = findParent(y);
			if (parX == parY)
				return false;
			if (size[parX] < size[parY]) {
				root[parY] = parX;
				size[parX] += size[parY];
			} else {
				root[parX] = parY;
				size[parY] += size[parX];
			}
			return true;
		}
	}

	static class Extra {
		static void sort(int[] a) {
			Integer[] aa = new Integer[a.length];
			for (int i = 0; i < aa.length; i++)
				aa[i] = a[i];
			Arrays.sort(aa);
			for (int i = 0; i < aa.length; i++)
				a[i] = aa[i];
		}

		static void sort(long[] a) {
			Long[] aa = new Long[a.length];
			for (int i = 0; i < aa.length; i++)
				aa[i] = a[i];
			Arrays.sort(aa);
			for (int i = 0; i < aa.length; i++)
				a[i] = aa[i];
		}

		static void sort(double[] a) {
			Double[] aa = new Double[a.length];
			for (int i = 0; i < aa.length; i++)
				aa[i] = a[i];
			Arrays.sort(aa);
			for (int i = 0; i < aa.length; i++)
				a[i] = aa[i];
		}

		static void sort(char[] a) {
			Character[] aa = new Character[a.length];
			for (int i = 0; i < aa.length; i++)
				aa[i] = a[i];
			Arrays.sort(aa);
			for (int i = 0; i < aa.length; i++)
				a[i] = aa[i];
		}

		static long gcd(long a, long b) {
			while (b > 0) {
				long temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}

		static long lcm(long a, long b) {
			return a * (b / gcd(a, b));
		}

		static boolean isPrime(long n) {
			if (n <= 1)
				return false;
			if (n <= 3)
				return true;
			if (n % 2 == 0 || n % 3 == 0)
				return false;
			for (long i = 5; i * i <= n; i = i + 6) {
				if (n % i == 0 || n % (i + 2) == 0)
					return false;
			}
			return true;
		}

		static HashSet<Integer> sieve(int n) {
			boolean[] prime = new boolean[n + 1];
			HashSet<Integer> res = new HashSet<>();
			for (int p = 2; p * p <= n; p++) {
				if (!prime[p]) {
					res.add(p);
					for (int i = p * p; i <= n; i += p)
						prime[i] = true;
				}
			}
			return res;
		}

		static HashMap<Long, Integer> primeFactorization(long n) {
			HashMap<Long, Integer> res = new HashMap<>();
			while (n % 2 == 0) {
				res.put(2L, res.getOrDefault(2L, 0) + 1);
				n /= 2;
			}
			for (long i = 3; i * i <= n; i += 2) {
				while (n % i == 0) {
					res.put(i, res.getOrDefault(i, 0) + 1);
					n /= i;
				}
			}
			if (n > 2)
				res.put(n, 1);
			return res;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
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

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++)
				a[i] = nextDouble();
			return a;
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}