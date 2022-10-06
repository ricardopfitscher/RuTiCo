import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int x = in.nextInt(),
            y = in.nextInt(),
            z = in.nextInt(),
            t1 = in.nextInt(),
            t2 = in.nextInt(),
            t3 = in.nextInt()*3,
            d = Math.abs(x - y);
        out.print(((Math.abs(x - z) + d) * t2 + t3 > d * t1 ? "NO" : "YES"));
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
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}