import java.io.*;
import java.util.*;

public class Solution{
    
    static class FastReader
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
    
    public static void main(String args[] ) {
        
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[105];
        
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            arr[a]++;
        }
        
        for(int i=1;i<=1000;i++){
            int sum=0;
            
            for(int a:arr){
                if(a!=0){
                    sum+=(a/i);
                }
            }
            
            
            if(sum<n){
                System.out.println(i-1);
                return;
            }
            
        }
    }

}
