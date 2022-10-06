import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.InputStream ;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        //Scanner sc = new Scanner();
        Reader in = new Reader();
        Main solver = new Main();
        solver.solve(out, in);
        out.flush();
        out.close();

    }
    
    
    void solve(PrintWriter out, Reader in) throws IOException{   
        int n = in.nextInt();
        int m = in.nextInt();
        
        
        
        int[] vert = new int[n+1];
        for(int i=0 ;i<n ;i++) vert[i] = in.nextInt();
        vert[n] = (int)1e9;
        
        int cnt=0,x,y;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0 ;i<m ;i++) {
            x = in.nextInt();
            y = in.nextInt();
            in.nextInt();
            
            if(x==1) arr.add(y);
        }
        
        horz = new int[arr.size()];
        for(int i=0 ;i<arr.size();i++) horz[i] = arr.get(i);
        
        Arrays.sort(horz);
        Arrays.sort(vert);
        
        int ans = 2*(int)1e5+10;
        for(int i=0 ;i<=n ;i++){
            int lesshorz = bs(vert[i],horz.length);
            ans = Math.min(ans,i+horz.length-lesshorz-1);
        }
        out.println(ans);
    }
    
    static int[] horz;
    
    static int bs(int num,int m){
        int mid,lo=0,hi=m-1,r=-1;
        
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(horz[mid]<num){
                lo = mid+1;
                r = mid;
            }else{
                hi =mid-1;
            }
        }
        return r;
    }
    
    static class Reader {
 
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
     
        public Reader() {
            this(System.in);
        }
     
        public Reader(InputStream is) {
            mIs = is;
        }
     
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
        
        }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
     
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
     
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
     
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
     
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
    }
}
