import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;


import java.util.StringTokenizer;


 public class Test
 {
    
     static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args)throws Exception
    {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int p = Reader.nextInt();
        int L = Reader.nextInt();
        int R = Reader.nextInt();
        int a = 1;
        int b = n;
        int res = 0;
        
        if(a == L && b == R)
        {
            res = 0;
        }
        else if(L != a && R != b && p >= L && p <= R)
        {
            res = Math.min(p-L, R-p);
            res += R- L + 2;
        }
        else if(L != a && R != b && p < L )
        {
            res += L-p + 1;
            res += R - L +1;
        }
        else if(L != a && R != b && p > R)
        {
            res += p-R + 1;
            res += R - L +1;
        }
        else if(a == L && p >=L && p<=R)
        {
            res += R - p + 1;
        }
        else if(R == b && p>=L && p<=R)
        {
            res += p - L + 1;
        }
        else if(a == L && p > R)
        {
            res += p - R + 1;
        }
        else if(R == b && p<L)
        {
            res += L - p + 1;
        }
            
            
        pw.print(res);
        pw.close();
 
    }
        
}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    public static int pars(String x) {
        int num = 0;
        int i = 0;
        if (x.charAt(0) == '-') {
            i = 1;
        }
        for (; i < x.length(); i++) {
            num = num * 10 + (x.charAt(i) - '0');
        }

        if (x.charAt(0) == '-') {
            return -num;
        }

        return num;
    }

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static void init(FileReader input) {
        reader = new BufferedReader(input);
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return pars(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}