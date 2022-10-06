import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.math.*;
 
public class Main{
	
	static ArrayList a[]=new ArrayList[200001];
	static int Count(int a[][],int n) {
		dsu d=new dsu(n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==0) {
					d.union(i, j);
				}
			}
		}
		int cnt=0;
		boolean chk[]=new boolean [n];
		for(int i=0;i<n;i++) {
			int p=d.root(i);
			if(!chk[p]) {
				chk[p]=true;
				cnt++;
			}
		}
	    return cnt;
	}
	public void solve () {
		InputReader in = new InputReader(System.in);
	    PrintWriter pw = new PrintWriter(System.out); 
	    int n=in.nextInt();
	    int a=in.nextInt();
	    int b=in.nextInt();
	    if(a==1 || b==1) {
	    	int ans[][]=new int [n][n];
	    	int temp=(a==1)?b:a;
	    	for(int i=1;i<=n-temp;i++) {
	    		ans[i][i-1]=1;
	    		ans[i-1][i]=1;
	    	}
	    	int freq=Count(ans,n);
	    	if(freq!=1) {
	    		pw.println("NO");
	    	}
	    	else {
	    		pw.println("YES");
	    		for(int i=0;i<n;i++) {
	    			for(int j=0;j<n;j++) {
	    				if(i==j) {
	    					pw.print(0);
	    				}
	    				else
	    					pw.print((ans[i][j]+((temp==b)?1:0))%2);
	    			}
	    			pw.println();
	    		}
	    	}
	    }
	    else {
	    	pw.print("NO");
	    }
		pw.flush();
		pw.close();
	}
	public static void main(String[] args) throws Exception {
        
        
        new Thread(null,new Runnable() {
        	public void run() {
        		new Main().solve();
        	}
        },"1",1<<26).start();
        
        
    }
    static void debug(Object... o) {
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
                } 
                catch (IOException e) 
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
        public static long mod = 1000000007;
        public static int d;
        public static int p;
        public static int q;
        public void extended(int a,int b) {
        	if(b==0) {
        		d=a;
        		p=1;
        		q=0;
        	}
        	else
        	{
        		extended(b,a%b);
        		int temp=p;
        		p=q;
        		q=temp-(a/b)*q;
        	}
        }
        public static long[] shuffle(long[] a,Random gen)
        {
            int n = a.length;
            for(int i=0;i<n;i++)
            {
                int ind = gen.nextInt(n-i)+i;
                long temp = a[ind];
                a[ind] = a[i];
                a[i] = temp;
            }
            return a;
        }
        
        public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        public static HashSet<Integer> primeFactorization(int n)
        {
            HashSet<Integer> a =new HashSet<Integer>();
            for(int i=2;i*i<=n;i++)
            {
                while(n%i==0)
                {
                    a.add(i);
                    n/=i;
                }
            }
            if(n!=1)
                a.add(n);
            return a;
        }
        
        public static void sieve(boolean[] isPrime,int n)
        {
            for(int i=1;i<n;i++)
                isPrime[i] = true;
            
            isPrime[0] = false;
            isPrime[1] = false;
            
            for(int i=2;i*i<n;i++)
            {
                if(isPrime[i] == true)
                {
                    for(int j=(2*i);j<n;j+=i)
                        isPrime[j] = false;
                }
            }
        }
        
        public static int GCD(int a,int b)
        {
            if(b==0)
                return a;
            else
                return GCD(b,a%b);
        }
        
        static class pair implements Comparable<pair>
        {
            Integer x;
            Long y;
            pair(int x,long y)
            {
                this.x=x;
                this.y=y;
                
            }
            
           
            public int compareTo(pair o) {
                int result = x.compareTo(o.x);
                if(result==0)
                    result = y.compareTo(o.y);
                
                return result;
            }  
            
            public String toString()
            {
                return x+" "+y;
            }
            
            public boolean equals(Object o)
            {
                if (o instanceof pair)
                {
                    pair p = (pair)o;
                    return p.x == x && p.y == y ;
                }
                return false;
            }
            
            public int hashCode()
            {
                return new Long(x).hashCode()*31 + new Long(y).hashCode();
            }
        }
        
    
}
class pair implements Comparable<pair>
{
    Integer x;
    Long y;
    pair(int x,long y)
    {
        this.x=x;
        this.y=y;
        
    }
    
   
    public int compareTo(pair o) {
        int result = x.compareTo(o.x);
        if(result==0)
            result = y.compareTo(o.y);
        
        return result;
    }  
    
    public String toString()
    {
        return x+" "+y;
    }
    
    public boolean equals(Object o)
    {
        if (o instanceof pair)
        {
            pair p = (pair)o;
            return p.x == x && p.y == y ;
        }
        return false;
    }
    
    public int hashCode()
    {
        return new Long(x).hashCode()*31 + new Long(y).hashCode();
    }
}
class dsu{
	int parent[];
	dsu(int n){
		parent=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
		}
	}
	int root(int n) {
		while(parent[n]!=n)
		{ 
			parent[n]=parent[parent[n]];
			n=parent[n];
		}
		return n;
	}
	void union(int _a,int _b) {
		int p_a=root(_a);
		int p_b=root(_b);
		
			parent[p_a]=p_b;
		
			
	}
	boolean find(int a,int b) {
		if(root(a)==root(b))
			return true;
		else
			return  false;
	}
	
	
}
