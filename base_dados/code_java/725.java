import java.io.*;
import java.util.*;

public class F
{
	static final double EPS = 1e-9 ; 
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in) ; 
		PrintWriter out = new PrintWriter(System.out) ; 
		
		int n = sc.nextInt() ; 
		
		Point [] pts = new Point [n] ; 
		
		for(int i = 0 ;i < n ;i++)pts[i] = new Point(sc.nextInt() , sc.nextInt()) ; 
		long ans = 0 ; 
		
		for(int i = 0 ;i < n ;i++)
		{
			Point [] down = new Point [n - 1] ; 
			Point [] up = new Point [n - 1] ; 
			
			int cntUp = 0 , cntDown = 0 ; 
			
			for(int j = 0 ;j < n ;j++)
				if(i != j)
				{
					Point curr = new Point(pts[j].x - pts[i].x , pts[j].y - pts[i].y) ; 
					if(curr.angle < EPS)
						down[cntDown++] = curr ; 
					else 
						up[cntUp ++] = curr ; 
				}
			
			up = Arrays.copyOf(up, cntUp) ;
			down = Arrays.copyOf(down,cntDown) ;
			
			Arrays.sort(up);
			Arrays.sort(down);
			
			int currUp = 0 , currDown = 0 ; 
			
			while(currUp < up.length && currDown < down.length)
			{
				if(down[currDown].angle + 180.0 < up[currUp].angle)
				{
					currDown ++ ; 
					
					ans += nCr(cntUp++, 2) * nCr(--cntDown, 2) ; 
					
					
				}
				else
				{
					currUp ++ ; 
					
					ans += nCr(--cntUp, 2) * nCr(cntDown++, 2) ; 
					
				}
				
			}
			while(currDown < down.length)
			{
				currDown ++ ; 
				
				ans += nCr(cntUp++, 2) * nCr(--cntDown, 2) ; 
				
			}
			while(currUp < up.length)
			{
				currUp ++ ; 
				ans += nCr(--cntUp, 2) * nCr(cntDown++, 2) ; 
				
			}
		}
		out.println(ans / 2);
		out.flush();
		out.close(); 
	}
	
	static long nCr(int N, int K)		
	{
		if(K > N)
			return 0;
		long res = 1;
		
		for(int i = 1; i <= K; ++i)
			res = (N - K + i) * res / i;
		return res;
	}
	static class Point implements Comparable<Point>
	{
		int x , y ;
		double angle ; 
		
		Point(int a , int b){x = a ; y = b ; angle = Math.atan2(y, x) * 180.0 / Math.PI; }
		
		public int compareTo(Point o) 
		{
			if(Math.abs(angle - o.angle) <= EPS) return 0;
			
			return Double.compare(angle, o.angle);
			
		}
		@Override
		public String toString() 
		{
			return x+" "+y+" "+angle ; 
		}
	}

	static class Scanner 
	{
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) 
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception 
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine()); // check it 
			
			return st.nextToken();
		}

		int nextInt() throws Exception { return Integer.parseInt(next()); }

		long nextLong() throws Exception { return Long.parseLong(next()); }

		double nextDouble() throws Exception { return Double.parseDouble(next());}

	}
}