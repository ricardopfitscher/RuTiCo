import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static String conv(String str) {
		boolean[] Arr = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			Arr[str.charAt(i) - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (Arr[i])
				sb.append((char) (i + 'a'));
		}
		return "" + sb;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		HashSet<String> hs = new HashSet<String>();
		int[] Arr = new int[14];
		long max = 0;
		for (int i = 0; i < 14; i++) {
			Arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 14; i++) {
			int[] arr = Arr.clone();

			long sum = 0;
			int r = arr[i];
			arr[i] = 0;
			for (int j = i + 1; j < arr.length && r > 0; j++) {
				arr[j]++;
				r--;
			}
			for (int j = 0; j < arr.length; j++) {
				arr[j] +=( r / 14);
				if (j + 1 <= (r % 14)) {
					arr[j]++;
				}
				if (arr[j] % 2 == 0) {
					sum += arr[j];
				}
			}
			max = Math.max(max, sum);

		}
		System.out.println(max);
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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
