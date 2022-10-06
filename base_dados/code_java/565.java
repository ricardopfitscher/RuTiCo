import java.util.*;
import java.io.*;

public class PartySweet {
	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = nextInt(), m = nextInt();
		int[] b = new int[n];
		int[] g = new int[m];
		for(int i = 0; i < n; i++)
			b[i] = nextInt();
		for(int i = 0; i < m; i++)
			g[i] = nextInt();
		int total = 0;
		int max = 0, max2 = 0;
		for(int i = 0; i < n; i++) {
			if(b[i] > b[max]) {
				max2 = max;
				max = i;
			}
			else if(b[max2] < b[i])
				max2 = i;
		}
		total += b[max] - b[max2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(b[i] > g[j]) {
					System.out.println(-1);
					return;
				}
				if(i != max)
					total += b[i];
				else
					total += g[j];
			}
		}
		System.out.println(total);
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
