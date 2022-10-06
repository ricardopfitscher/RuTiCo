
// LM10: The next Ballon d'or
import java.util.*;
import java.io.*;
import java.math.*;
import javafx.util.Pair;
public class Main
{
    static class FastReader
    {
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public FastReader() { this(System.in); }public FastReader(InputStream is) { mIs = is;}
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];}
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;}
        public String next(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();}
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;}
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;}
        public double d() throws IOException {return Double.parseDouble(next()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; }
        public void scanIntArr(int [] arr){ for(int li=0;li<arr.length;++li){ arr[li]=i();}}
        public void scanLongArr(long [] arr){for (int i=0;i<arr.length;++i){arr[i]=l();}}
        public void shuffle(int [] arr){ for(int i=arr.length;i>0;--i) { int r=(int)(Math.random()*i); int temp=arr[i-1]; arr[i-1]=arr[r]; arr[r]=temp; } }
    }
    public static void main(String[] args)throws IOException {
        /*
inputCopy
4
2 1 2 1
outputCopy
4
inputCopy
5
0 -1 -1 -1 -1
outputCopy
4
*/
        PrintWriter pw = new PrintWriter(System.out);
        FastReader fr = new FastReader();
        int n=fr.i();
        int [] arr=new int[n];
        fr.scanIntArr(arr);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        long sum=0;
        if(n==1)
        {
            pw.println(arr[0]);
            pw.flush();
            pw.close();
            return;
        }
        for(int i=0;i<n;++i)
        {
            if(arr[i]<min)
                min=arr[i];
            if(arr[i]>max)
                max=arr[i];
            sum+=Math.abs(arr[i]);
        }
        if(min>0)
        {
            sum-=2*min;
        }
        if(max<0)
        {
            sum+=2*max;
        }
        pw.println(sum);
        pw.flush();
        pw.close();
    }
}