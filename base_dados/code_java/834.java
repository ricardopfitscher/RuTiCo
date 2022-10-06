import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main {
	
	static long N, M, R;
	static FastScanner input = new FastScanner(System.in);
	
	public static void main(String[] args) {
		N = input.nextLong();
		M = input.nextLong();
		R = input.nextLong();
		
		int K = input.nextInt();
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				long cmp = f(a.x, a.y) - f(b.x, b.y);
				if (cmp < 0) 	return 1;
				else if (cmp > 0) return -1;
				return 0;
			}
		});
		
		int[] lt = new int[(int) N + 1];
		int[] rt = new int[(int) N + 1];
		
		int y = (int) (M + 1) / 2;
		for (int x = 1; x <= N; x++) {
			pq.add(new Point(x, y));
			lt[x] = rt[x] = y;
		}
		
		long sum = 0;
		
		for (int i = 0; i < K; i++) {
			Point pp = pq.poll();
			
			sum += f(pp.x, pp.y);
			
			if (valid(pp.x, pp.y + 1) && pp.y == rt[pp.x]) {
				pq.add(new Point(pp.x, pp.y + 1));
				rt[pp.x]++;
			}
			if (valid(pp.x, pp.y - 1) && pp.y == lt[pp.x]) {
				pq.add(new Point(pp.x, pp.y - 1));
				lt[pp.x]--;
			}
		}
		
		System.out.println((double) sum / (N - R + 1) / (M - R + 1));
	}
	
	static boolean valid(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= M;
	}
	
	static long f(int x, int y) {
		return (Math.min(N + 1, x + R) - Math.max(x, R)) * (Math.min(M + 1, y + R) - Math.max(y, R));
	}
	
	// Matt Fontaine's Fast IO
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
