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
       int a = solve();
       out.print(a == 0 ? "tokitsukaze" : a == 1 ? "quailty" : "once again");
    }
    int n, k;
    char ch[]; int a[], c0 = 0, c1 = 0;
    TreeSet<Integer> ts[] = new TreeSet[2];
    boolean check(){
        int min = 0, max = n;
        if(!ts[0].isEmpty()){
            min = ts[0].first(); max = ts[0].last();
            if(max - min + 1 > k)return true;
        }
        if(!ts[1].isEmpty()){
            min = ts[1].first(); max = ts[1].last();
            if(max - min + 1 > k)return true;   
        }
        return false;
    }
    int solve(){
        n  = in.nextInt(); k = in.nextInt();
        ch = in.next().trim().toCharArray(); a = new int[n];
        for(int i = 0; i < n; i++)c1 += a[i] = ch[i] - '0';
        c0 = n - c1;
        for(int i = 0; i < k; i++){
            if(a[i] == 0)c0--; else c1--;
        }
        if(c0 == 0 || c1 == 0)return 0;
        for(int i = k; i < n; i++){
            if(a[i] == 0)c0--; else c1--;
            if(a[i - k] == 0)c0++; else c1++;
            if(c0 == 0 || c1 == 0)return 0;
        }

        for(int i = 0; i < 2; i++)ts[i] = new TreeSet<>();
        for(int i = 0; i < n; i++){
            ts[a[i]].add(i);
        }
        for(int i = 0; i < k; i++){
            ts[a[i]].remove(i);
        }
        if(check())return 2;
        for(int i = k; i < n; i++){
            ts[a[i]].remove(i); ts[a[i - k]].add(i - k);
            if(check())return 2;
        }
        return 1;
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
        