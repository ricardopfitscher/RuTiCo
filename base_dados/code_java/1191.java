import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
 
public class Main {
 
    private static final FS scanner = new FS(System.in);
	//private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {

        int n = scanner.nextInt();
        int sumA = 0;
        int sumB = 0;
        int rem = n % 4;
        for (int i = rem; i >= 1 ; i--) {
            if (sumB <= sumA) {
                sumB += i;
            }
            else {
                sumA +=i;
            }
        }

        System.out.println(Math.abs(sumA - sumB));
    }
	
    static class FS {
        BufferedReader br;
        StringTokenizer st;

        public FS(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
 
}