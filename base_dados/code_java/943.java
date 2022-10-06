import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Practice {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] arr1 = new String[n];
            String[] arr2 = new String[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = in.next();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = in.next();
            }
            int ans = 0;
            boolean arr[]=new boolean[n];
            boolean found=false;
            for (int i = 0; i < arr1.length; i++) {
                for(int j=0;j<arr1.length;j++){
                    found=false;
                    if(arr1[i].equals(arr2[j]) && !arr[j]){
                        found=true;
                        arr[j]=true;
                        break;
                    }
                }
                if(!found){
                    ans++;
                }
            }
            out.println(ans);
        }
    }

    public static boolean checkPrime(int n, int p) {
        for (int i = 2; i <= Math.sqrt(n) && i <= p; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
            int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
    }

    public long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static long nCr(int n, int r) {
        return n * (n - 1) / 2;
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
