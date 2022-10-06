import java.util.*;
import java.io.*;

public class Sol {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();
		Integer[] a = new Integer[n*k];
		for(int i = 0; i < n*k; i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		if (a[n - 1] - a[0] > l) {
			out.println(0);
		} else {
			int maxPos = n*k - 1;
			for (int i = 0; i < n*k; i++) {
				if (a[i] - a[0] > l) {
					maxPos = i-1;
					break;
				}
			}
			long o = a[0];
			int s = 0;
			int t = 1;
			for (int i = 1; i <= maxPos; i++) {
				//System.out.print(a[i]);
				if (s < k - 1 && maxPos-i+1 > n-t) {
					//System.out.println(" @");
					s++;
				} else {
					//System.out.println(" #");
					s = 0;
					t++;
					o += a[i];
				}
			}
			out.println(o);
		}
		out.close();
	}

	// -----------PrintWriter for faster output-------------
	public static PrintWriter out;

	// -----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
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
	// --------------------------------------------------------
}