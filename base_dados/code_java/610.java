import java.util.*;
import java.io.*;
import java.awt.Point;
import java.math.BigInteger;

public class stacks {

	public static void main(String[] args) throws Exception {
		FastIO sc = new FastIO(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long remove = 0;
		
		int[] heights = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			heights[i] = sc.nextInt();
			remove += heights[i];
		}
		
		Arrays.sort(heights);
		//System.out.println(Arrays.toString(heights));
		long keep = 0;
		for(int i = n; i> 0; i--) {
			if(heights[i-1] >= heights[i]) {
				heights[i-1] = heights[i]-1;
			}
			keep += heights[i] - heights[i-1];
		}
		//System.out.println(Arrays.toString(heights));
		
		pw.println(remove - keep);
		pw.close();
	}

	static class FastIO {

		//Is your Fast I/O being bad?

		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;

		public FastIO(String fileName) throws Exception {
			dis = new FileInputStream(fileName);
		}

		public FastIO(InputStream is) throws Exception {
			dis = is;
		}

		int nextInt() throws Exception {
			int ret = 0;

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}

			return (negative) ? -ret : ret;
		}

		long nextLong() throws Exception {
			long ret = 0;

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}

			return (negative) ? -ret : ret;
		}

		byte nextByte() throws Exception {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}

		String next() throws Exception {
			StringBuffer ret = new StringBuffer();

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}

			return ret.toString();
		}

	}
}
