import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Main {
    void solve() {
        int n=ni(),m=ni();

        long x[]=new long[n+m+1];
        int y[]=new int[n+m+1];
        for(int i=1;i<=n+m;i++) x[i]=nl();
        for(int i=1;i<=n+m;i++) y[i]=ni();
        int prev[]=new int[n+m+1];
        int nxt[]=new int[n+m+1];
        prev[0]=-1;
        for(int i=1;i<=n+m;i++){
            if(y[i]==1){
                prev[i]=i;
            }else {
                prev[i]=prev[i-1];
            }
        }

        nxt[n+m]=-1;
        if(y[n+m]==1) nxt[n+m]=n+m;
        for(int i=n+m-1;i>=1;i--){
            if(y[i]==1){
                nxt[i]=i;
            }else {
                nxt[i]=nxt[i+1];
            }
        }
        int ans[]=new int[n+m+1];
        for(int i=1;i<=n+m;i++){
            if(y[i]==0){
                if(prev[i]!=-1 && nxt[i]!=-1){
                    if(x[i]-x[prev[i]]<=x[nxt[i]]-x[i]) ans[prev[i]]++;
                    else ans[nxt[i]]++;
                }else if(prev[i]!=-1){
                    ans[prev[i]]++;
                }else {
                    ans[nxt[i]]++;
                }
            }
        }
        for(int i=1;i<=n+m;i++) if(y[i]==1) pw.print(ans[i]+" ");
        pw.println("");

    }

    long M =(long)1e9+7;
    InputStream is;
    PrintWriter pw;
    String INPUT = "";

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");


    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }

}