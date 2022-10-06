
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long n = in.nextLong();
		long k = in.nextLong();
		long s = in.nextLong();
		if (k > s || k * (n - 1) < s) {
			out.println("NO");
		} else {
			out.println("YES");
			long cur = 1;
			while (k > 0) {
				long x = Math.min(n - 1, s - k + 1);
				cur = ( cur - x > 0 ? cur  - x : cur + x);
				out.print(cur + " ");
				s -= x;
				k--;
			}

		}
		out.flush();
		out.close();
	}

	static class FastReader {
		StringTokenizer st;
		BufferedReader br;

		public FastReader(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public FastReader(FileReader fileReader) {
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}