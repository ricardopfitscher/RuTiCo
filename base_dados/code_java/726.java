
import java.io.*;
import java.util.*;

public class B {

	static StringBuilder st = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		long n = sc.nextLong();
		long n_2 = (n * n + 1) / 2;
		int q = sc.nextInt();

		while (q-- > 0) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			long pos = x * n + y;
			
			if (x % 2 == 0) {
				if ((y & 1) == 0)
					out.println((pos >> 1) + 1);
				else
					out.println((pos + 1) / 2 + n_2);
			} else {
				if ((y & 1) == 0)
					out.println(pos / 2 + n_2 + 1);
				else
					out.println((pos >> 1) + 1);
				
			}
		}

		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Scanner() {
		}

		Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}
	}

	static void shuffle(long[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			long tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

	private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private static void tr(Object... o) {
		if (!oj)
			System.out.println(Arrays.deepToString(o));

	}
}