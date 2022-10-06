import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;
public class D527A2 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int N = in.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int num = in.nextInt() % 2;
			if(stack.size() >= 1 && stack.lastElement() == num)
				stack.pop();
			else
				stack.add(num);
		}
		
		System.out.println(stack.size() <= 1 ? "YES" : "NO");
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
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

		public String nextLine() {
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
/*
5
2 1 1 2 5
outputCopy
YES
inputCopy
3
4 5 3
outputCopy
YES
inputCopy
2
10 10
outputCopy
YES
inputCopy
3
1 2 3
outputCopy
NO

5
2 3 2 2 3

YES
*/