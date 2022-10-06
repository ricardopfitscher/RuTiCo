import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static char returnLetter(int n)
	{
		if(n%4==1)
		{
			return 'A';
		}
		else if(n%4==3)
		{
			return 'B';
		}
		else if(n%4==2)
		{
			return 'C';
		}
		else
		{
			return 'D';
		}
	}
	/*public static void main(String[] args) throws IOException {
		int n=sc.nextInt();
		
		int zero=n;
		int one=n+1;
		int two=n+2;
		char z=returnLetter(zero);
		char o=returnLetter(one);
		char t=returnLetter(two);
		
		if(z<o && z<t)
		{
			System.out.println("0 " + z);
		}
		else if(o<z && o<t)
		{
			System.out.println("1 " + o);
		}
		else if(t<z && o>t)
		{
			System.out.println("2 " + t);
		}
	}*/
	
	public static void main(String[] args) throws IOException {
		String[] a= new String[3];
		
		for (int i = 0; i < a.length; i++) {
			a[i]=sc.next();
		}
		boolean equal=true;
		
		for (int i = 1; i < a.length; i++) {
			if(a[i].charAt(1)!=a[i-1].charAt(1) || a[i].charAt(0)!=a[i-1].charAt(0))
			{
				equal=false;break;
			}
		}
		if(equal)
		{
			System.out.println(0);
		}
		else
		{
			Arrays.sort(a);
			boolean ord=true;
			
			for (int i = 1; i < a.length; i++) {
				if(a[i].charAt(1)!=a[i-1].charAt(1) || a[i].charAt(0)-a[i-1].charAt(0)!=1)
				{
					ord=false;break;
				}
			}
			if(ord)
			{
				System.out.println(0);
			}
			else
			{
				if(a[1].charAt(1)==a[0].charAt(1) && a[1].charAt(0)-a[0].charAt(0)==2)
				{
					System.out.println(1);
				}
				else if(a[2].charAt(1)==a[1].charAt(1) && a[2].charAt(0)-a[1].charAt(0)==2)
				{
					System.out.println(1);

				}
				else if(a[2].charAt(1)==a[0].charAt(1) && a[2].charAt(0)-a[0].charAt(0)==2)
				{
					System.out.println(1);

				}
				else if(a[0].charAt(1)==a[1].charAt(1) && a[0].charAt(0)-a[1].charAt(0)==2)
				{
					System.out.println(1);

				}
				else if(a[1].charAt(1)==a[2].charAt(1) && a[1].charAt(0)-a[2].charAt(0)==2)
				{
					System.out.println(1);

				}
				else if(a[0].charAt(1)==a[2].charAt(1) && a[0].charAt(0)-a[2].charAt(0)==2)
				{
					System.out.println(1);

				}
				else if(a[1].charAt(1)==a[0].charAt(1) && a[1].charAt(0)-a[0].charAt(0)==1)
				{
					System.out.println(1);

				}
				else if(a[2].charAt(1)==a[1].charAt(1) && a[2].charAt(0)-a[1].charAt(0)==1)
				{
					System.out.println(1);
				}
				else if(a[2].charAt(1)==a[0].charAt(1) && a[2].charAt(0)-a[0].charAt(0)==1)
				{
					System.out.println(1);
				}
				else if(a[0].charAt(1)==a[1].charAt(1) && a[0].charAt(0)-a[1].charAt(0)==1)
				{
					System.out.println(1);

				}
				else if(a[1].charAt(1)==a[2].charAt(1) && a[1].charAt(0)-a[2].charAt(0)==1)
				{
					System.out.println(1);

				}
				else if(a[0].charAt(1)==a[2].charAt(1) && a[0].charAt(0)-a[2].charAt(0)==1)
				{
					System.out.println(1);

				}
				else if(a[1].charAt(1)==a[0].charAt(1) && a[1].charAt(0)==a[0].charAt(0))
				{
					System.out.println(1);

				}
				else if(a[2].charAt(1)==a[1].charAt(1) && a[1].charAt(0)==a[2].charAt(0))
				{
					System.out.println(1);

				}
				else
				{
					System.out.println(2);
				}
				
			}
		}
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			int start = 0;
			boolean dec = false, neg = false;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
	}
}
