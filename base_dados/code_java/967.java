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
        int l;
        int r;
        public card(int ch,int i)
        {
            this.l=ch;
            this.r=i;
        }
    }
    static class sort implements Comparator<card>
    {
        public int compare(card o1,card o2)
        {
            if(o1.l!=o2.l)
                return (int)(o1.l-o2.l);
            else
                return (int)(o1.r-o2.r);
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
    }
    static int ans1=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE,ans4=Integer.MAX_VALUE;
    static boolean v[]=new boolean[101];
    static void dfs(Integer so,Set<Integer> s[]){
    if(!v[so.intValue()])
    {
    v[so]=true;
    for(Integer h:s[so.intValue()])
    {
    if(!v[h.intValue()])
    dfs(h,s);
    }
    }
    }
    static class Print{
    public PrintWriter out;
    Print(OutputStream o)
    {
    out=new PrintWriter(o);
    }
    }
    static int CeilIndex(int A[], int l, int r, int key) 
    { 
    while (r - l > 1) { 
    int m = l + (r - l) / 2; 
    if (A[m] >= key) 
    r = m; 
    else
    l = m; 
    } 

    return r; 
    } 

    static int LongestIncreasingSubsequenceLength(int A[], int size) 
    { 
    // Add boundary case, when array size is one 
    int[] tailTable = new int[size]; 
    int len; // always points empty slot 
    tailTable[0] = A[0]; 
    len = 1; 
    for (int i = 1; i < size; i++) { 
    if (A[i] < tailTable[0]) 
    // new smallest value 
    tailTable[0] = A[i]; 

    else if (A[i] > tailTable[len - 1]) 
    // A[i] wants to extend largest subsequence 
    tailTable[len++] = A[i]; 

    else
    // A[i] wants to be current end candidate of an existing 
    // subsequence. It will replace ceil value in tailTable 
    tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i]; 
    } 
    return len; 
    }*/
    /*static int binary(int n)
    {
    int s=1;
    while(n>0)
    {
    s=s<<1;
    n--;
    }
    return s-1;
    }
    static StringBuilder bin(int i,int n)
    {
    StringBuilder s=new StringBuilder();
    while(i>0)
    {
    s.append(i%2);
    i=i/2;
    }
    while(s.length()!=n)
    {
    s.append(0);
    }
    return s.reverse();
    }*/
    static boolean valid(int i,int j,int n,int m)
    {
        if(i<n && i>=0 && j<m && j>=0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) 
    {
        InputReader sc=new InputReader(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        card c[]=new card[n];
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            c[i]=new card(x,y);
        }
        Arrays.sort(c,new sort());
        int time=0;
        for(int i=n-1;i>=0;i--)
        {
            time+=s-c[i].l;
            if((c[i].r-time)>0)
            time+=c[i].r-time;
            s=c[i].l;
        }
        if(c[0].l!=0)
        time+=c[0].l;
        System.out.println(time);
    }
}