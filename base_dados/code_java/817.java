import java.awt.geom.QuadCurve2D;
import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static String INPUT = "";
    static InputStream inStream = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());

    static int[] heights;
    static int[] line; //linear representation of hills starting and ending at highest hill
    static int[] left; //left[i] = index of first hill to the left of i that is higher than i
    static int[] right; //right[i] = index of first hill to right of i that is higher than i
    static int[] middle; //middle[i] = # of hills to right of i that are same height as i

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        heights = new int[n];
        line = new int[n+1];
        left = new int[n+1];
        right = new int[n+1];
        middle = new int[n+1];
        int maxHeight = -1;
        int maxIndex = -1;

        for(int i=0; i<n; i++){
            heights[i]=nextInt();
            if(heights[i]>maxHeight){
                maxHeight = heights[i];
                maxIndex=i;
            }
        }
        int index = maxIndex;
        for(int i=0; i<n; i++){
            line[i]=heights[index];
            index++;
            if(index==n)
                index=0;
        }
        line[n]=maxHeight;

        //make left
        for(int i=1; i<n; i++){
            left[i]=i-1;
            while(left[i]>0 && line[i]>=line[left[i]])
                left[i] = left[left[i]];
        }

        //make middle and right
        for(int i=n-1; i>=0; i--){
            right[i]=i+1;
            while(right[i]<n && line[i]>line[right[i]]){
                right[i] = right[right[i]];
            }
            if(right[i]<n && line[i]==line[right[i]]){
                middle[i] = middle[right[i]]+1;
                right[i] = right[right[i]];
            }
        }

        //each hill will at least match witha ll other hills of the same size
        //each hill will also give two other matches.
        long answer = middle[0];
        for(int i=1; i<n; i++){
            answer += middle[i];
            if(line[i]<maxHeight && left[i]==0 && right[i]==n)
                answer += 1;
            else if(line[i]<maxHeight)
                answer += 2;
        }

        out.println(answer);
        out.flush();

    }


    private static boolean eof() {
        if (lenbuf == -1) return true;
        int lptr = ptrbuf;
        while (lptr < lenbuf) if (!isSpaceChar(inbuf[lptr++])) return false;
        try {
            inStream.mark(1000);
            while (true) {
                int b = inStream.read();
                if (b == -1) {
                    inStream.reset();
                    return true;
                } else if (!isSpaceChar(b)) {
                    inStream.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }

    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;

    private static int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = inStream.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private static double nextDouble() {
        return Double.parseDouble(nextString());
    }

    private static char nextChar() {
        return (char) skip();
    }

    private static String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static char[] nextString(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private static char[][] nextMap(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++)
            map[i] = nextString(m);
        return map;
    }

    private static int[] nextArray0(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    private static int[] nextArray1(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = nextInt();
        return a;
    }

    private static long[] nextArrayLong1(int n) {
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = nextLong();
        return a;
    }

    private static long[] nextArrayLong0(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }

    private static int nextInt() {
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

    private static long nextLong() {
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
}
