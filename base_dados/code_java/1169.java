import java.util.*;
import java.lang.*;
public class Main {
    static long m = 1000000007;
    static long powmod(long x, long y, long p)
    {
        // Initialize result
        long res = 1;

        // Update x if it is more
        // than or equal to p
        x = x % p;

        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;

            // y must be even now
            // y = y / 2
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long mulmod(long a, long b, long mod){
        long res=0;
        a = a % mod;
        while (b > 0)
        {
            // If b is odd, add 'a' to result
            if (b % 2 == 1)
                res = (res + a) % mod;

            // Multiply 'a' with 2
            a = (a * 2) % mod;

            // Divide b by 2
            b /= 2;
        }

        // Return result
        return res % mod;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long k = sc.nextLong();
        if(x>0) {
            long d= powmod(2,k,m);
            long ans= mulmod(d,2,m)%m;
            ans= mulmod(ans,x,m)%m;
            ans++;
            ans%=m;
            ans= (ans-d+m)%m;
            System.out.println(ans);
        }
        else
            System.out.println(0);
    }
}