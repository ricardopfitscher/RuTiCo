import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C {

	static StringBuilder st = new StringBuilder();

		public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Point [] square = new Point [4] ; 
		Point [] rotSquare = new Point[4] ; 
		
		for(int i = 0 ; i < 4 ;i++)
			square[i] = new Point(sc.nextInt() , sc.nextInt());
		
		for(int i = 0 ; i < 4 ;i++)
			rotSquare[i] = new Point(sc.nextInt() , sc.nextInt());
		
		boolean can = false ; 
		
		for(int x = -100 ; x <= 100 ; x++)
			for(int y = -100 ; y <= 100 ; y++)
				can |= inside(new Point(x , y), square) & inside(new Point (x , y), rotSquare);
				
			
		
		
		out.println(can ? "YES" : "NO");
		
		out.flush();
		out.close();

	}
	static int crossProduct(Point a , Point b)
	{
		int ans = a.x * b.y - a.y * b.x ; 
		
		if(ans < 0)return -1 ;
		if(ans == 0) return 0 ;
		return 1 ; 
	}
	
	static boolean inside(Point a , Point [] points)
	{
		boolean allPos = true ; 
		boolean allNeg = true ; 
		
		for(int i = 0 ; i < 4 ; i++)
		{
			Point v1 = new Point (points[i].x - a.x , points[i].y - a.y) ; 
			Point v2 = new Point (points[(i + 1) % 4].x - a.x , points[(i + 1) % 4].y - a.y) ; 
			
			allPos &= crossProduct(v1, v2) >= 0;
			allNeg &= crossProduct(v1, v2) <= 0;
		}
		return allPos | allNeg ; 
		
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(System.in));
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

	static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

}