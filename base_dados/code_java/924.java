import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class gr1 {

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

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
    }

    static class card{
        long a;
        int cnt;
        int i;
        public card(long a,int cnt,int i)
        {
            this.a=a;
            this.cnt=cnt;
            this.i=i;
        }
    }

    static class ascend implements Comparator<pair>
    {
        public int compare(pair o1,pair o2)
        {
            if(o1.b!=o2.b)
                return (int)(o1.b-o2.b);
            else 
                return (int)(o1.a-o2.a);
        }
    }

    /*static class descend implements Comparator<pair>
    {
    public int compare(pair o1,pair o2)
    {
    if(o1.a!=o2.a){
    return (o1.a-o2.a)*-1;
    } else {
    return (o1.b-o2.b);
    }
    }
    }*/

    static class extra
    {

        static void shuffle(long a[])
        {
            List<Long> l=new ArrayList<>();
            for(int i=0;i<a.length;i++)
                l.add(a[i]);
            Collections.shuffle(l);
            for(int i=0;i<a.length;i++)
                a[i]=l.get(i);
        }

        static long gcd(long a,long b)
        {
            if(b==0)
                return a;
            else
                return gcd(b,a%b);
        }

        static boolean valid(int i,int j,int r,int c)
        {
            if(i>=0 && i<r && j>=0 && j<c)
                return true;
            else
                return false;
        }

        static boolean v[]=new boolean[100001];
        static List<Integer> l=new ArrayList<>();
        static int t;
        static void seive()
        {
            for(int i=2;i<100001;i++)
            {
                if(!v[i])
                {
                    t++;
                    l.add(i);
                    for(int j=2*i;j<100001;j+=i)
                        v[j]=true;
                }
            }
        }

        static int binary(pair a[],int val,int n)
        {
            int mid=0,l=0,r=n-1,ans=0;
            while(l<=r)
            {
                mid=(l+r)>>1;
                if(a[mid].a==val)
                {
                    r=mid-1;
                    ans=mid;
                }
                else if(a[mid].a>val)
                    r=mid-1;
                else
                {
                    l=mid+1;
                    ans=l;
                }
            }
            return (ans);
        }
    }

    static class pair{
        long a;
        int b;
        public pair(long a,int n)
        {
            this.a=a;
            this.b=n;
        }
    }
    static InputReader sc=new InputReader(System.in);
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) {
        solver s=new solver();
        int t=1;
        while(t>0)
        {
            s.solve();
            t--;
        }
    }
    static class solver
    {
        void solve()
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum+=a[i];
            }
            Arrays.sort(a);
            int k=(int)Math.round(4.5*n)-sum;
           // System.out.println((int)Math.round(4.5*n)+" "+k+" "+sum);
            if(k<=0)
            {
                System.out.println(0);
            }
            else
            {
                int p=0,ans=0;
                for(int i=0;i<n;i++)
                {
                    if(a[i]!=5)
                    {
                        p+=5-a[i];
                        if(p>=k){
                            ans++;
                            System.out.println(ans);
                            break;
                        }
                        ans++;
                    }
                }
            }
        }
    }
}