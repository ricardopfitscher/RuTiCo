import com.sun.org.apache.xalan.internal.xslt.Process;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        init();//"prizes.in", "prizes.out");
        int x = nextInt();
        int y = nextInt();
        int z = nextInt();
        int t1 = nextInt();
        int t2 = nextInt();
        int t3 = nextInt();
        int lift = Math.abs(z - x) * t2 + 2 * t3 + Math.abs(x - y) * t2 + t3;
        int stair = Math.abs(x - y) * t1;
        if (lift <= stair) {
            pw.print("YES");
        } else {
            pw.print("NO");
        }
        pw.close();
    }

    static StringTokenizer st;
    static BufferedReader sc;
    static PrintWriter pw;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(sc.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static void init(String in, String out) throws IOException {
        sc = new BufferedReader(new FileReader(in));
        pw = new PrintWriter(out);
    }

    static void init() {
        sc = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
}

class DSU {
    int parent[];
    public DSU(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int get(int i){
        if (i == parent[i]){
            return i;
        }
        int p = get(parent[i]);
        parent[i] = p;
        return p;
    }

    boolean union(int a, int b){
        a = get(a);
        b = get(b);
        if (a == b) return false;
        parent[a] = b;
        return true;
    }
}