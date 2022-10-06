import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Problem
{

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    static int[] rt;
    static int[] size;

    static void initialize(int n){
        rt = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i < rt.length; i++){
            rt[i] = i;
            size[i] = 1;
        }
    }
    
    static int root(int x){
        while(rt[x] != x){
            rt[x] = rt[rt[x]];
            x = rt[x];
        }
        return x;
    }
    
    static long union(int x,int y){
        int root_x = root(x);
        int root_y = root(y);
        if(root_x == root_y) return 0;
        long val = size[root_x] *1l* size[root_y];
        if(size[root_x]<size[root_y]){
            rt[root_x] = rt[root_y];
            size[root_y] += size[root_x];
        }
        else{
            rt[root_y] = rt[root_x];
            size[root_x] += size[root_y];            
        }
        
        return val;
    }
    
    static void solve()
    {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);            
        
        int t = 1;
        
        while(t-- > 0){
            int n = in.nextInt();
            int[] arr = in.nextIntArray(n);
            ArrayList<Pair> list = new ArrayList<>();
            
            for(int i = 1; i < n; i++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                list.add(new Pair(u, v, Math.max(arr[u],arr[v])));
            }
            list.sort((p1,p2) -> Integer.compare(p1.i, p2.i));
            initialize(n);
            long s1 = 0;
            for(int i = 0; i < list.size(); i++){
                s1 += union(list.get(i).x, list.get(i).y) * list.get(i).i;
            }
            for(int i = 0; i < list.size(); i++){
                Pair p = list.get(i);
                p.i = Math.min(arr[p.x],arr[p.y]);
            }
            list.sort((p1,p2) -> -Integer.compare(p1.i, p2.i));
            initialize(n);
            long s2 = 0;
            for(int i = 0; i < list.size(); i++){
                s2 += union(list.get(i).x, list.get(i).y) * list.get(i).i;
            }
            
            out.println(s1 - s2);
        }
        
        out.close();
    }
    
    public static void main(String[] args)
    {
        new Thread(null ,new Runnable(){
            public void run(){
                try{
                    solve();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"1",1<<26).start();
        
    }

    static class Pair implements Comparable<Pair>
    {

        int x,y;
        int i;


        Pair (int x,int y)
        {
                this.x = x;
                this.y = y;
        }

        Pair (int x,int y, int i)
        {
                this.x = x;
                this.y = y;
                this.i = i;
        }

        public int compareTo(Pair o)
        {
            if(this.x != o.x)
                return -Integer.compare(this.x, o.y);
            return -Integer.compare(this.y,o.y);
                //return 0;
        }

        public boolean equals(Object o)
        {
            if (o instanceof Pair)
            {
                Pair p = (Pair)o;
                return p.x == x && p.y==y;
            }
            return false;
        }

        @Override
        public String toString()
        {
            return x + " "+ y + " "+i;
        }

        /*public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }*/

    } 

    static long add(long a,long b){
        long x=(a+b);
        while(x>=mod) x-=mod;
        return x;
    }

    static long sub(long a,long b){
        long x=(a-b);
        while(x<0) x+=mod;
        return x;
    }
    
    static long mul(long a,long b){
        long x=(a*b);
        while(x>=mod) x-=mod;
        return x;
    }
    
    static String rev(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    
    static long gcd(long x,long y)
    {
        if(y==0)
                return x;
        else
                return gcd(y,x%y);
    }

    static int gcd(int x,int y)
    {
        if(y==0)
                return x;
        else 
                return gcd(y,x%y);
    }

    static long pow(long n,long p,long m)
    {
         long  result = 1;
          if(p==0){
            return n;
          }
          
        while(p!=0)
        {
            if(p%2==1)
                result *= n;
            if(result >= m)
               result %= m;
            p >>=1;
            n*=n;
            if(n >= m)
                n%=m;
        }
        
        return result;
    }

    static long pow(long n,long p)
    {
        long  result = 1;
          if(p==0)
            return 1;

        while(p!=0)
        {
            if(p%2==1)
                result *= n;	    
            p >>=1;
            n*=n;	    
        }
        return result;
    }

    static void debug(Object... o)
    {
            System.out.println(Arrays.deepToString(o));
    }

    static class InputReader
    {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
                this.stream = stream;
        }

        public int snext()
        {
                if (snumChars == -1)
                        throw new InputMismatchException();
                if (curChar >= snumChars)
                {
                        curChar = 0;
                        try
                        {
                                snumChars = stream.read(buf);
                        } catch (IOException e)
                        {
                                throw new InputMismatchException();
                        }
                        if (snumChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }

        public int nextInt()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                int res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public long nextLong()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                long res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public int[] nextIntArray(int n)
        {
                int a[] = new int[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextInt();
                }
                return a;
        }

        public long[] nextLongArray(int n)
        {
                long a[] = new long[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextLong();
                }
                return a;
        }

        public String readString()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
        }

        public String nextLine()
        {
                int c = snext();
                while (isSpaceChar(c))
                        c = snext();
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c)
        {
                return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter
        {
                public boolean isSpaceChar(int ch);
        }

    }
}    
