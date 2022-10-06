import java.io.*;
import java.util.*;

public class C
{

	static StringBuilder st = new StringBuilder();
	
	public static void main(String[] args) throws Exception 
	{

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int [] freq = new int [5] ; 
		
		int k = 3;  
		while(k -- >0)
		{
			int x = sc.nextInt();
			
			if(x <= 4) freq[x]++;
			
		}
		freq[2] += freq[4]/ 2 ;
		
		if(freq[1] >= 1 || freq[2] >= 2 || freq[3] >= 3)
			out.println("YES");
		else
			out.println("NO");
		
		
		out.flush();
		out.close();

	}
	
	static class Scanner 
	{
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) 
		{
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