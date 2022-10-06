import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dont {
    static BufferedReader jin = new BufferedReader( new InputStreamReader( System.in ) );
    static long n;
    static long x, y;

    public static void main(String[] args) throws Exception {
        n = nextLong();
        x = nextLong();
        y = nextLong();
        System.out.println( (max(n-x, n-y) < max(x-1, y-1))? "Black" : "White" );
    }

    static long max(long a, long b) {
        return (a > b)? a : b ;
    }

    static long nextLong() throws Exception {
        long res = 0;
        int ch = jin.read();
        while(ch < '0' || '9' < ch) ch = jin.read();
        while('0'<= ch && ch <= '9') {
            res = res*10 + ch - '0';
            ch = jin.read();
        }
        return res;
    }
}