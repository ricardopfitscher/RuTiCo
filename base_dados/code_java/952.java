import java.util.*;
import java.io.*;
import java.math.*;
import java.util.HashMap;

public class Main
{
    static class Reader 
    { 
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;} 
        public String s(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();} 
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;} 
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public double d() throws IOException {return Double.parseDouble(s()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
    } 
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void main(String args[])
    {
        Reader sc=new Reader();
        PrintWriter out=new PrintWriter(System.out);
        int n=sc.i();
        String s1=sc.s();
        String s2=sc.s();
        int pos1=-1;
        int pos2=-1;
        int arr[][][]=new int[100][100][2];
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(arr[s2.charAt(i)-97][s1.charAt(i)-97][0]==1)
                {
                    pos2=i;
                    pos1=arr[s2.charAt(i)-97][s1.charAt(i)-97][1];
                    break;
                }
                arr[s1.charAt(i)-97][s2.charAt(i)-97][0]=1;
                arr[s1.charAt(i)-97][s2.charAt(i)-97][1]=i;
            }
        }
        int ham=0;
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            ham++;
        }
        if(pos1!=-1&&pos2!=-1)
        {
            System.out.println(ham-2);
            System.out.println(pos1+1+" "+(pos2+1));
            System.exit(0);
        }
        
        int arr1[][]=new int[100][2];
        int arr2[][]=new int[100][2];
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(arr1[s1.charAt(i)-97][0]==1)
                {
                    pos2=i;
                    pos1=arr1[s1.charAt(i)-97][1];
                    break;
                }
                if(arr2[s2.charAt(i)-97][0]==1)
                {
                    pos2=i;
                    pos1=arr2[s2.charAt(i)-97][1];
                    break;
                }
                arr1[s2.charAt(i)-97][0]=1;
                arr1[s2.charAt(i)-97][1]=i;
                arr2[s1.charAt(i)-97][0]=1;
                arr2[s1.charAt(i)-97][1]=i;
            }
        }
        if(pos1!=-1&&pos2!=-1)
        {
            System.out.println(ham-1);
            System.out.println(pos1+1+" "+(pos2+1));
            System.exit(0);
        }
        System.out.println(ham);
        System.out.println(pos1+" "+pos2);
    }
}