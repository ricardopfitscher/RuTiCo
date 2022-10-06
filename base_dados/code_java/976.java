import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOOL {
    static char [][]ch;
    static int n,m;
private static FastReader in =new FastReader();
    public static void main(String[] args) {
    int n=in.nextInt();
    int a[]=new int[1000002];
    int dp[]=new int[1000002],ans=0;
    for(int i=0;i<n;i++){a[in.nextInt()]=in.nextInt();}
    dp[0]=a[0]==0?0:1;
    for(int i=1;i<1000002;i++){
    if(a[i]==0){dp[i]=dp[i-1];}
    else{
    if(a[i]>=i){dp[i]=1;}
    else{
    dp[i]=dp[i-a[i]-1]+1;
    }}
    if(dp[i]>=ans)ans=dp[i];
    }
        System.out.println(n-ans);
    }}
class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
}
