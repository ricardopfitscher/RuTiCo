import java.io.PrintWriter;
import java.util.Scanner;

public class pr1023B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = sc.nextLong();
        long k = sc.nextLong();

        out.println(solve(n, k));
        out.flush();
        out.close();
    }


    static long solve(long n, long k) {
        if(k <= n) return (long)Math.floor((double)(k-1)/2);
        else{
            long mx = n;
            long mn = k-n;
            return Math.max(0, (long)Math.floor((double)(mx-mn+1)/2));
        }
    }
}
