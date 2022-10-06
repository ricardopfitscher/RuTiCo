import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder data;
    final static FastReader in = new FastReader();


    public static void main(String[] args) {
        int n = in.nextInt(), k = in.nextInt();
               long answ = 0;
        if (n * 2 > k) {
         if((n*2)%k==0){
             answ+=(n*2)/k;
         }else{
             answ+=((n*2)/k)+1;
         }
        }else{
            answ++;
        }
        if (n * 5 > k) {
            if((n*5)%k==0){
                answ+=(n*5)/k;
            }else{
                answ+=((n*5)/k)+1;
            }
        }else{
            answ++;
        }
        if (n * 8 > k) {
            if((n*8)%k==0){
                answ+=(n*8)/k;
            }else{
                answ+=((n*8)/k)+1;
            }
        }else{
            answ++;
        }

        System.out.println(answ);
    }


    static void fileOut(String s) {
        File out = new File("output.txt");
        try {
            FileWriter fw = new FileWriter(out);
            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(String path) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(new FileInputStream(path)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }


        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}