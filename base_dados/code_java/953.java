import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;

public class l {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMMMM      MMMMMM      OOO      OOO        SSSS   SSS     EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEE           MMMM MMM  MMM MMMM    OOO          OOO    SSSS       SSS   EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM  MMMMMM  MMMM   OOO            OOO   SSSS             EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM  OOO              OOO   SSSSSSS         EEEEE          /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO      SSSSSS       EEEEEEEEEEE    /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO         SSSSSSS   EEEEEEEEEEE    /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM   OOO            OOO              SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM    OOO          OOO     SSS       SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM      OOO      OOO        SSS    SSSS    EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static long mod = (int) (1e9 + 7);
    static int n;
    static StringBuilder sol;

    static class pair implements Comparable<pair> {
        int L,R;
        public pair( int x,int y) {
            L=x;R=y;
        }


        public int compareTo(pair o) {
            if (L!=o.L)return L-o.L;
            return o.R-R;
        }
        public String toString(){
            return L+" "+R;
        }
    }
    static boolean is;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //FileWriter f = new FileWriter("C:\\Users\\Ibrahim\\out.txt");
        PrintWriter pw = new PrintWriter(System.out);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        TreeSet<Integer>length= new TreeSet<>();
        length.add(0);
        length.add(n);
        TreeSet<Integer>width= new TreeSet<>();
        width.add(0);
        width.add(m);
        TreeMap<Integer,Integer>len= new TreeMap<>();
        len.put(n,1);
        TreeMap<Integer,Integer>wid= new TreeMap<>();
        wid.put(m,1);
        while (q-->0){
            String t= sc.next();
            if (t.equals("H")) {
                int x = sc.nextInt();
                int k1 = length.ceiling(x);
                int k2 = length.floor(x);
                if (x != k1) {
                    int s = k1 - k2;
                    int con = len.get(s);
                    if (con == 1) len.remove(s);
                    else len.put(s, con - 1);
                    len.put((k1 - x), len.getOrDefault((k1 - x), 0) + 1);
                    len.put((x - k2), len.getOrDefault((x - k2), 0) + 1);
                    length.add(x);
                }
            }
            else {
                int x = sc.nextInt();
                int k1 = width.ceiling(x);
                int k2 = width.floor(x);
                if (x != k1) {
                    int s = k1 - k2;
                    //System.out.println(s+" "+k1+" "+k2);
                    int con = wid.get(s);
                    if (con == 1) wid.remove(s);
                    else wid.put(s, con - 1);
                    wid.put((k1 - x), wid.getOrDefault((k1 - x), 0) + 1);
                    wid.put((x - k2), wid.getOrDefault((x - k2), 0) + 1);
                    width.add(x);
                }
            }
            pw.println(1l*len.lastKey()*wid.lastKey());
        }

        pw.flush();
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
        public boolean ready() throws IOException {
            return br.ready();
        }


    }

}