import java.io.*;
import java.util.*;

public class LectureSleep {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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

        public float nextFloat() {
            return Float.parseFloat(next());
        }

    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) {
        int n = r.nextInt(); // duration of lecture
        int k = r.nextInt(); // number of minutes keep mishka awake
        int[] theorems = new int[n+1];
        for(int i = 1; i <= n; i++){
            theorems[i] = r.nextInt();
        }
        int[] mishka = new int[n+1];
        for(int i = 1; i <= n; i++){
            mishka[i] = r.nextInt();
        }
        int[] sums = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(mishka[i] == 0){
                sums[i] = sums[i-1] + theorems[i];
            } else{
                sums[i] = sums[i-1];
            }
        }
        int max = 0;
        for(int i = 1; i <= n-k+1; i++){
            int sum = sums[i+k-1] - sums[i-1];
            max = Math.max(max, sum);
        }
        int totalSum = 0;
        for(int i = 1; i <= n; i++){
            if(mishka[i] == 1){
                totalSum += theorems[i];
            }
        }

        pw.println(totalSum + max);

        pw.close();
    }
}