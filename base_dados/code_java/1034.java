import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
//BigInteger A;
//A= BigInteger.valueOf(54);
//ArrayList<Integer> a=new ArrayList<>();
//TreeSet<Integer> ts=new TreeSet<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
public final class Cf
{
    public static void main(String[]args)
    {
        FastReader ob=new FastReader();
        //int t=ob.nextInt();
        //while(t-->0)
        {
            int n=ob.nextInt();
            int k=ob.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=ob.nextInt();
            int x=a[n-1]-a[0];
            ArrayList<Integer> b=new ArrayList<>();
            for(int i=0;i<n-1;i++)
            b.add(-a[i+1]+a[i]);
            Collections.sort(b);
            for(int i=0;i<k-1;i++)
            x+=b.get(i);
            System.out.println(x);
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public String nextLine()
    {
        String s="";
        try {
        s=br.readLine();
        } catch (IOException e)  {
                e.printStackTrace();
            }
        return s;
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}