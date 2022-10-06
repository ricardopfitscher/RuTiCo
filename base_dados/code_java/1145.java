import java.util.*;
import java.math.*;
import java.io.*;

public class CF1068A {
	public CF1068A() {
		FS scan = new FS();
		long n = scan.nextLong(), m = scan.nextLong(), k = scan.nextLong(), l = scan.nextLong();
		long ceil = (k + l + m - 1) / m;
		if(k + l <= n && ceil * m <= n) System.out.println(ceil);
		else System.out.println(-1);
	}
	class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		public String next() {
			while(!st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
	public static void main(String[] args) { new CF1068A(); }
}
