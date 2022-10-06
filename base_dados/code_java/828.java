import java.io.BufferedReader;

import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int n = in.nextInt(), l[] = new int[n],
            p = -1000000, d_min = 1000000, min = 1000000000;
        for(int i = 0; i < n; i++) {
            l[i] = in.nextInt();
            min = Math.min(min, l[i]);
        }
        for(int i = 0; i < n; i++)
            if(l[i] == min) {
                d_min = Math.min(d_min, i - p);
                p = i;
            }
        out.print(d_min);
        out.close();
    }
    
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;
        
        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        
        public String next() throws IOException {
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        
        public String nextLine() throws IOException {
            while(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            String r = st.nextToken("\n");
            st = new StringTokenizer(br.readLine(), " ");
            return r;
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}