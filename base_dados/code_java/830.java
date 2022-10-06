import java.io.*;
import java.util.*;

public class b {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner zizo = new Scanner(System.in);
		PrintWriter wr = new PrintWriter(System.out);
		
		int n1 = 0,n2 = 0,n3 = 0,n4 = 0;
		int n = 3;
		while(n --> 0) {
			int x = zizo.nextInt();
			switch(x) {
			case 1:n1++;break;
			case 4:n4++;break;
			case 2:n2++;break;
			case 3:n3++;break;
			}
		}
		n2 += n4/2;
		if(n1>0 || n2>1 || n3>2)
			System.out.println("YES");
		else System.out.println("NO");
		wr.close();
	}
}
class pair{
	int l,r;
	pair(int a,int b){l = a;r = b;}
}

class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if(x.charAt(0) == '-')
		{
			neg = true;
			start++;
		}
		for(int i = start; i < x.length(); i++)
			if(x.charAt(i) == '.')
			{
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			}
			else
			{
				sb.append(x.charAt(i));
				if(dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
}