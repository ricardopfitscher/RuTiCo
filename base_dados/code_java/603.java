
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		long i = sc.nextInt();
		long goal = sc.nextLong();
//	long goal=sum;
if(i>goal) {
	i=goal;
}
		int count = 0;
		while (goal >= 0) {
			if (goal - i >= 0) {
				goal = goal - i;
				count++;
			} else
				i--;
			if (goal == 0)
				break;
		}
		out.print(count);

		out.flush();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
