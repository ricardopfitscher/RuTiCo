import java.util.*;
import java.io.*;
public class C{
    static PrintWriter out;
    static InputReader in;
    public static void main(String args[]){
        out = new PrintWriter(System.out);
        in = new InputReader();
        new C();
        out.flush(); out.close();
    }   
    C(){
       int w = solve();
       out.print(w == 0 ? "sjfnb" : "cslnb");
    }
    int n;
    long a[];
    int solve(){
        n = in.nextInt(); a = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++)sum += a[i] = in.nextLong();
        if(sum == 0){
            return 1;
        }
        Arrays.sort(a);
        int c = 0, c0 = 0; long p = -1, max = 0;
        int f = 0;
        long t = -1; int pp = -1;
        for(int i = 0; i < n; i++){
            if(a[i] == p){
                c++;
            }else{
                if(p == 0)c0 = c;
                if(c >= 2){f++; t = p; pp = i - 2;}
                max = Math.max(max, c);
                p = a[i];
                c = 1;
            }
        }
        max = Math.max(max, c);
        sum = 0;
        if(c >= 2){f++; t = p; pp = n - 2;}
        if(max > 2 || c0 > 1 || f > 1)return 1;
        if(f == 1){
            long v = Arrays.binarySearch(a, t - 1);
            if(v >= 0)return 1;
            a[pp]--; sum = 1;
        }

        p = -1;
        for(int i = 0; i < n; i++){
            sum += a[i] - (p + 1);
            a[i] = p + 1;
            p = a[i];
        }

        return 1 - (int)(sum % 2);
    }
    public static class InputReader{
        BufferedReader br;
        StringTokenizer st;
        InputReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){}
            }
            return st.nextToken();
        }
    }
}
        