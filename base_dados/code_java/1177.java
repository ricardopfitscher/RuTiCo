
import java.util.*;
import java.io.*;
import java.math.*;
public class loser
{
    static class InputReader {
        public BufferedReader br;
        public StringTokenizer token;
        public InputReader(InputStream stream)
        {
            br=new BufferedReader(new InputStreamReader(stream),32768);
            token=null;
        }

        public String next()
        {
            while(token==null || !token.hasMoreTokens())
            {
                try
                {
                    token=new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return token.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }
    }
    static class card{
        long a;
        int i;
        public card(long a,int i)
        {
            this.a=a;
            this.i=i;
        }
    }
    static class sort implements Comparator<pair>
    {
        public int compare(pair o1,pair o2)
        {
            if(o1.a!=o2.a)
                return (int)(o1.a-o2.a);
            else
                return (int)(o1.b-o2.b);
        }
    }
    static void shuffle(long a[])
    {
        List<Long> l=new ArrayList<>();
        for(int i=0;i<a.length;i++)
            l.add(a[i]);
        Collections.shuffle(l);
        for(int i=0;i<a.length;i++)
            a[i]=l.get(i);
    }

    /*static long gcd(long a,long b)
    {
    if(b==0)
    return a;
    else
    return gcd(b,a%b);
    }*/
    /*static boolean valid(int i,int j)
    {
    if(i<4 && i>=0 && j<4 && j>=0)
    return true;
    else
    return false;
    }*/
    static class pair{
        int a,b;
        public pair(int a,int b)
        {
            this.a=a;
            this.b=b;
        }
    }
    public  static void main(String[] args) 
    {
        InputReader sc=new InputReader(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int s=sc.nextInt();
        int p=sc.nextInt();
        long d=(long)Math.ceil((double)n/s);
        if(d==0)
        d=1;
        d=k*d;
        long ans=(long)Math.ceil((double)d/p);
        System.out.println(ans);
    }
}