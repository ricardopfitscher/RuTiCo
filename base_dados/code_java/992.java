import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CodeForces {

	public static int difference(String s, String b, int n, int k) {
		int min = Integer.MAX_VALUE;
		int[] pre = new int[n];
		for (int i = 1; i < n; i++) {
			if (i == 1) {
				pre[i - 1] = (s.charAt(i-1) == b.charAt(i-1) ? 0 : 1);
			}
			pre[i] = pre[i - 1] + (s.charAt(i) == b.charAt(i) ? 0 : 1);
		}
		int v = -1;
		for (int i = k - 1; i < n; i++) {
			min = Math.min(min, pre[i] - (v == -1 ? 0 : pre[v]));
			v++;
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		O: while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.nextLine();
			int c = 1;
			StringBuilder R = new StringBuilder();
			StringBuilder G = new StringBuilder();
			StringBuilder B = new StringBuilder();

			for (int i = 0; i < n; i++) {
				if (c % 3 == 1) {
					R.append("R") ;
					G.append("G");
					B.append("B");
				} else if (c % 3 == 2) {
					R.append("G");
					G.append("B");
					B.append("R");
				} else {
					R.append("B");
					G.append("R");
					B.append("G");
				}
				c++;
			}
			String RR = R.toString(),BB = B.toString() , GG = G.toString();
			String[] arr = new String[] { RR, BB, GG };
			int i = 0;
			int j = k;
			int min = Integer.MAX_VALUE;
			while (i < 3) {
				min = Math.min(min, difference(s, arr[i], n, k));
				i++;
			}
			pw.println(min);
		}
		pw.close();
	}

	static class SegmentTree {
		static int[] S, in;
		static int N;

		public SegmentTree(int[] arr) {
			in = arr;
			N = in.length - 1;
			S = new int[N << 1];
			build(1, 1, N);
		}

		static int stat;

		void build(int node, int b, int e) {
			if (b == e) {
				S[node] = in[b];
				stat = 1;
			} else {
				int mid = (b + e) / 2;
				build(node << 1, b, mid);
				build(node << 1 | 1, mid + 1, e);
				if (stat == 1) {
					S[node] = S[node << 1] | S[node << 1 | 1];

				} else {
					S[node] = S[node << 1] ^ S[node << 1 | 1];
				}
				stat = 1 - stat;
			}
		}

		int update(int idx, int val) {
			idx += (N - 1);

			S[idx] = val;
			int stat = 1;
			while (idx > 1) {
				idx >>= 1;
				if (stat == 1) {
					S[idx] = S[idx << 1] | S[idx << 1 | 1];
					stat = 0;
				} else {
					S[idx] = S[idx << 1] ^ S[idx << 1 | 1];
					stat = 1;
				}
			}
			return S[1];
		}

	}

	public static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair A) {
			if (a != A.a)
				return A.a - a;
			return A.b - b;
		}

		public String toString() {
			return a + " " + b;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}