import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

import java.util.Arrays;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        long n = in.nextLong(), m = in.nextLong();
        out.print(m / n + (m % n == 0 ? 0 : 1));
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
        
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}