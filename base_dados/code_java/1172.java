import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.flush();out.close();
    }
        static class TaskE {
          long mod=(long)(1E9)+7;
          long rpe(long a,long b){
           long ans=1;
           while(b!=0){
            if(b%2!=0)ans=ans*a%mod;
            a=a*a%mod;b/=2;
           }return ans;
          }
          public void solve(int testNumber, InputReader in, PrintWriter out) {
              long x=in.nextLong(),k=in.nextLong();
              if(x==0){
               out.print(0);return;
              }
              x%=mod;
              long p2=rpe(2,k);
              out.print((p2*2L%mod*x%mod-p2+1L+mod)%mod);
          }
          //          int ja[][],from[],to[],c[];
    //              void make(int n,int m,InputReader in){
    //               ja=new int[n+1][];from=new int[m];to=new int[m];c=new int[n+1];
    //               for(int i=0;i<m;i++){
    //                from[i]=in.nextInt();to[i]=in.nextInt();
    //                c[from[i]]++;c[to[i]]++;
    //               }
    //               for(int i=1;i<=n;i++){
    //                ja[i]=new int[c[i]];c[i]=0;
    //               }
    //               for(int i=0;i<m;i++){
    //                ja[from[i]][c[from[i]]++]=to[i];
    //                ja[to[i]][c[to[i]]++]=from[i];
    //               }
    //              }
//            int[] radixSort(int[] f){ return radixSort(f, f.length); }
//    	int[] radixSort(int[] f, int n)
//    	{
//    		int[] to = new int[n];
//    		{
//    			int[] b = new int[65537];
//    			for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
//    			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//    			for(int i = 0;i < n;i++){
//                             to[b[f[i]&0xffff]++] = f[i];
//                            }
//    			int[] d = f; f = to;to = d;
//    		}
//    		{
//    			int[] b = new int[65537];
//    			for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
//    			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//    			for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
//    			int[] d = f; f = to;to = d;
//    		}
//    		return f;
//    	}
    
       }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
}