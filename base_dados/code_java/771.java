import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
    static final long mod=(int)1e9+7;
    public static void main(String[] args) throws Exception
    {
    	FastReader in=new FastReader();
    	PrintWriter pw=new PrintWriter(System.out);
    	int n=in.nextInt();
    	long ans=0;
    	for(int i=2;2*i<=n;i++)
    	{
    		ans+=i*(n/i-1);
    	}
    	ans*=4;
    	pw.print(ans);
    	pw.flush();
    }
}

class pair
{
	int f,s;
}

class FastReader
{
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
    }
 
    public String next() throws IOException
    {
        if(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
 
    public int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
 
    public long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
}