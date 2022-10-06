/**
 * Created by Baelish on 7/30/2018.
 */

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class B {
    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int ans = -1;
        int f[] = new int[(int)2e5+50];
        int g[] = new int[(int)2e5+50];

        int n = in.nextInt(), x = in.nextInt();

        int arr[] = new int[n+1];
        for (int i = 1; i <= n && ans == -1; i++) {
            int a = in.nextInt();
            if(f[a] > 0){
                ans = 0; break;
            }
            f[a]++;
            arr[i] = a;
        }

        for (int i = 1; i <= n && ans == -1; i++) {
            int a = arr[i] & x;
            if( (a == arr[i] && f[a] > 1) || (a != arr[i] && f[a] > 0)){
                ans = 1; break;
            }
            
            g[a]++;
        }

        for (int i = 1; i <= n && ans == -1; i++) {
            int a = arr[i] & x;
            if(g[a] > 1){
                ans = 2; break;
            }
            //g[a]++;
        }

        pw.println(ans);



        pw.close();
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is){
            for(int i='0';i<='9';i++) ints[i]=i-'0';
            this.is = is;
        }

        public int readByte(){
            if(lenbuf == -1)throw new InputMismatchException();
            if(ptrbuf >= lenbuf){
                ptrbuf = 0;
                try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                if(lenbuf <= 0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() {
            int b;
            while((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next(){
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt(){
            int num = 0, b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
       /* public char nextChar() {
            return (char)skip();
        }*/

        public char[] next(int n){
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while(p < n && !(isSpaceChar(b))){
                buf[p++] = (char)b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        /*private char buff[] = new char[1005];
        public char[] nextCharArray(){
            int b = skip(), p = 0;
            while(!(isSpaceChar(b))){
                buff[p++] = (char)b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }*/
    }
}