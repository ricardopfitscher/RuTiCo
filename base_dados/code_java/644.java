//package Contest573;


import java.io.*;
import java.util.StringTokenizer;

public class mainA {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);

    public static void main(String[] args) throws IOException {
        int x=enter.nextInt();
        if(x%4==0){
            System.out.println(1 +" A");
        }
        else if(x%4==1){
            System.out.println(0+" A");
        }
        else if(x%4==2){
            System.out.println(1+" B");
        }
        else if(x%4==3){
            System.out.println(2+" A");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
