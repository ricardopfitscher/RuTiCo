import java.io.*;
import java.util.*;
 
 
 
public class Main {
	
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	static long oo = 1000000000000L;
	static int[][] memo;
	
	public static void main(String[] args) throws IOException {
 
		int n = in.nextInt();
		int[] a = in.nextIntArray(n);
		if(n % 2 == 0) {
			for(int i = 0; i < n; ++i) {
				if(a[i] >= 0)
					a[i] = -a[i] - 1;
			}
		}
		else {
			int maxi = -1, max = -1;
			for(int i = 0; i < n; ++i) {
				int x = a[i] >= 0 ? -a[i] - 1 : a[i];
				x = -x;
				if(x > max) {
					max = x; maxi = i;
				}
			}
			if(max == 1) {
				a[0] = 0;
			}
			else {
				for(int i = 0; i < n; ++i) {
					if(i == maxi) {
						if(a[i] < 0)
							a[i] = -a[i] - 1;
					}
					else {
						if(a[i] >= 0)
							a[i] = -a[i] - 1;
					}
				}
			}
		}
		for(int x : a)
			System.out.print(x + " ");
		
		out.close();
	}
	
	
	
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	static boolean nextPermutation(int[] a) {
		for(int i = a.length - 2; i >= 0; --i) {
			if(a[i] < a[i+1]) {
				for(int j = a.length - 1; ; --j) {
					if(a[i] < a[j]) {
						int t = a[i];
						a[i] = a[j];
						a[j] = t;
						for(i++, j = a.length - 1; i < j; ++i, --j) {
							t = a[i];
							a[i] = a[j];
							a[j] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	static void shuffle(int[] a) {
		Random r = new Random();
		for(int i = a.length - 1; i > 0; --i) {
			int si = r.nextInt(i);
			int t = a[si];
			a[si] = a[i];
			a[i] = t;
		}
	}
	
	static void shuffle(long[] a) {
		Random r = new Random();
		for(int i = a.length - 1; i > 0; --i) {
			int si = r.nextInt(i);
			long t = a[si];
			a[si] = a[i];
			a[i] = t;
		}
	}
	
	static int lower_bound(int[] a, int n, int k) {
		int s = 0;
		int e = n;
		int m;
		while (e - s > 0) {
			m = (s + e) / 2;
			if (a[m] < k)
				s = m + 1;
			else
				e = m;
		}
		return e;
	}
	static int lower_bound(long[] a, int n, long k) {
		int s = 0;
		int e = n;
		int m;
		while (e - s > 0) {
			m = (s + e) / 2;
			if (a[m] < k)
				s = m + 1;
			else
				e = m;
		}
		return e;
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static class Pair implements Comparable<Pair> {
		int first, second;
 
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
 
		@Override
		public int compareTo(Pair o) {
			return this.first != o.first ? this.first - o.first : this.second - o.second;
		}
 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + first;
			result = prime * result + second;
			return result;
		}
 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (first != other.first)
				return false;
			if (second != other.second)
				return false;
			return true;
		}
	}
	
	
}
 
 
 
class InputReader {
 
	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;
 
	public InputReader(InputStream st) {
		this.stream = st;
	}
 
	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}
 
	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
 
}