import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import java.lang.Math.*;

public class two_squares {

	public static void main(String[] args) throws Exception {
		new two_squares().run();
	}

	public void run() throws Exception {
		FastIO file = new FastIO();
		double x1 = file.nextInt();
		double y1 = file.nextInt();
		double x2 = file.nextInt();
		double y2 = file.nextInt();
		double x3 = file.nextInt();
		double y3 = file.nextInt();
		double x4 = file.nextInt();
		double y4 = file.nextInt();
		double minx1, maxx1, miny1, maxy1;
		minx1 = Math.min(x1, Math.min(x2, Math.min(x3, x4)));
		maxx1 = Math.max(x1, Math.max(x2, Math.max(x3, x4)));
		miny1 = Math.min(y1, Math.min(y2, Math.min(y3, y4)));
		maxy1 = Math.max(y1, Math.max(y2, Math.max(y3, y4)));
		double x5 = file.nextInt();
		double y5 = file.nextInt();
		double x6 = file.nextInt();
		double y6 = file.nextInt();
		double x7 = file.nextInt();
		double y7 = file.nextInt();
		double x8 = file.nextInt();
		double y8 = file.nextInt();
		double minx2, maxx2, miny2, maxy2;
		minx2 = Math.min(x5, Math.min(x6, Math.min(x7, x8)));
		maxx2 = Math.max(x5, Math.max(x6, Math.max(x7, x8)));
		miny2 = Math.min(y5, Math.min(y6, Math.min(y7, y8)));
		maxy2 = Math.max(y5, Math.max(y6, Math.max(y7, y8)));
		Point _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16;
		_1 = new Point(x1, y1);
		_2 = new Point(x2, y2);
		_3 = new Point(x3, y3);
		_4 = new Point(x4, y4);
		_5 = new Point(x5, y5);
		_6 = new Point(x6, y6);
		_7 = new Point(x7, y7);
		_8 = new Point(x8, y8);
		_9 = new Point(minx1, maxy1);
		_10 = new Point(minx1, miny1);
		_11 = new Point(maxx1, maxy1);
		_12 = new Point(maxx1, miny1);
		double m1 = (minx2 + maxx2) / 2;
		double m2 = (miny2 + maxy2) / 2;
		_13 = new Point(minx2, m2);
		_14 = new Point(m1, miny2);
		_15 = new Point(maxx2, m2);
		_16 = new Point(m1, maxy2);
		Point[] a = {_1, _2, _3, _4};
		Point[] b = {_5, _6, _7, _8};
		boolean works = false;
		Line[] aa = {new Line(_9,_10), new Line(_10, _12), new Line(_12, _11), new Line(_11, _9)};
		Line[] bb = {new Line(_13, _14), new Line(_14, _15), new Line(_15, _16), new Line(_16, _13)};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (aa[i].intersection(bb[i]) != null) {
					works = true;
				}
			}
		}
		for (Point p : b) {
			if (p.x >= minx1 && p.x <= maxx1 && p.y >= miny1 && p.y <= maxy1) {
				works = true;
			}
		}
		for (Point p : a) {
			boolean result = false;
		      for (int i = 0, j = b.length - 1; i < b.length; j = i++) {
		        if ((b[i].y > p.y) != (b[j].y > p.y) &&
		            (p.x < (b[j].x - b[i].x) * (p.y - b[i].y) / (b[j].y-b[i].y) + b[i].x)) {
		          result = !result;
		         }
		      }
		      if (result) works = true;
		}
		System.out.println(works ? "YES" : "NO");
	}
	public static class Point {
		double x, y;
		public Point(double a, double b) {
			x = a;
			y = b;
		}
	}
	public static class Line {
		Point a, b;
		public Line(Point x, Point y) {
			a = x;
			b = y;
		}
		public Point intersection(Line o) {
			double x1 = a.x;
			double y1 = a.y;
			double x2 = b.x;
			double y2 = b.y;
			double x3 = o.a.x;
			double y3 = o.a.y;
			double x4 = o.b.x;
			double y4 = o.b.y;
			double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
			  double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
			  double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
			    if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
			        return new Point((int) (x1 + ua*(x2 - x1)), (int) (y1 + ua*(y2 - y1)));
			    }

			  return null;
		}
	}
	public static class FastIO {
		BufferedReader br;
		StringTokenizer st;

		public FastIO() {
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

	public static long pow(long n, long p, long mod) {
		if (p == 0)
			return 1;
		if (p == 1)
			return n % mod;
		if (p % 2 == 0) {
			long temp = pow(n, p / 2, mod);
			return (temp * temp) % mod;
		} else {
			long temp = pow(n, p / 2, mod);
			temp = (temp * temp) % mod;
			return (temp * n) % mod;

		}
	}

	public static long pow(long n, long p) {
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		if (p % 2 == 0) {
			long temp = pow(n, p / 2);
			return (temp * temp);
		} else {
			long temp = pow(n, p / 2);
			temp = (temp * temp);
			return (temp * n);

		}
	}

	public static long gcd(long x, long y) {
		if (x == 0)
			return y;
		else
			return gcd(y % x, x);
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
}
