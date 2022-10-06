import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B 
{
	
	static StringBuilder st ; 
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner () ;
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String first = "" ; 
		String second = "" ; 
		
		
		for(int i = 0 ; i < 126 ;i++ )
		{
			first+= "9";
			second+="9";
		}
		
		for(int i = 0 ; i < 125 ;i++ )
			first+= "0";
		
		first += "1";
		
		out.println(first+" "+second);
		
		out.flush();
		out.close();
	
	}
	
	static int sumDigits(int num)
	{
		int ans = 0 ;
		
		while(num > 0)
		{
			ans += num % 10  ;
			
			num /= 10;
		}
		
		return ans ;
		
	}
	
	static class Scanner 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception 
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception { return Integer.parseInt(next()); }
		
		long nextLong() throws Exception { return Long.parseLong(next()); }

		double nextDouble() throws Exception { return Double.parseDouble(next()); }

		char nextChar() throws Exception { return next().charAt(0); }
		
		char [] nextCharArray() throws Exception{ return next().toCharArray() ; }
	}

}
