/**
 * Created by Baelish on 8/28/2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class F_DSU {
    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextInt();
        
        int brr[] = new int[2*n];
        for (int i = 0; i < 2*n; i+= 2) {
            brr[i] = in.nextInt();
            brr[i+1] = in.nextInt();
        }

        arr = shrink(brr);
        int imap[] = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            imap[arr[i]] = brr[i];
        }

        int idx = binarySearch(arr.length);
        if(idx >= arr.length) pw.println(-1);
        else pw.println(imap[idx]);

        pw.close();
    }
    static int n, arr[];

    static int binarySearch(int H) {
        int lo = 0, hi = H, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (check(mid)) hi = mid;
            else lo = mid + 1;
        }
        if(lo > 0 && check(lo-1)) return lo-1;
        return lo;
    }

    static boolean check(int m){
        DSU dsu = new DSU(2*n);
        for (int i = 0; i < n; i++) {
            int u = arr[2*i], v = arr[2*i+1];
            if(u > m) return false;
            if(v > m){
                if(++dsu.cycle[dsu.find(u)] >= 2) return false;
            }
            else{
                if(!dsu.union(u, v)){
                    if(++dsu.cycle[dsu.find(u)] >= 2) return false;
                }
                else{
                    if(dsu.cycle[dsu.find(u)] >= 2) return false;
                }
            }
        }
        return true;
    }

    static class DSU{
        int parent[], cycle[], n;
        DSU(int N){
            n = N;
            parent = new int[N];
            cycle = new int[N];
            for(int i = 0; i < N; i++){
                parent[i] = i;
            }
        }

        DSU(int [] p){
            parent = p; n = p.length;
        }

        int find(int i) {
            int p = parent[i];
            if (i == p) return i;
            return parent[i] = find(p);
        }

        boolean equiv(int u, int v){
            return find(u) == find(v);
        }

        boolean union(int u, int v){
            u = find(u); v = find(v);
            if(u != v) {
                parent[u] = parent[v];
                cycle[v] += cycle[u];
            }
            return u != v;
        }

        int count(){
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(i == find(i)) cnt++;
            }
            return cnt;
        }
    }

    public static int[] shrink(int[] a) {
        int n = a.length;
        long[] b = new long[n];
        for(int i = 0;i < n;i++)b[i] = (long)a[i]<<32|i;
        Arrays.sort(b);
        int[] ret = new int[n];
        int p = 0;
        for(int i = 0;i < n;i++) {
            if(i>0 && (b[i]^b[i-1])>>32!=0)p++;
            ret[(int)b[i]] = p;
        }
        return ret;
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