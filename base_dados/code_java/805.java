
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Phan
 */
public class p1096f {
    static long MOD = 998244353;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BIT invert = new BIT(n+5);
        BIT neg = new BIT(n+5);
        long res = 0;
        int[] arr = new int[n];
        boolean[] has = new boolean[n+1];
        long num1 = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if(arr[i] != -1) {
                res += invert.read(n+5)-invert.read(arr[i]);
                res %= MOD;
                invert.update(arr[i], 1);
                has[arr[i]] = true;
            } else num1++;
        }
        if(num1 == 0) {
            System.out.println(res);
            return;
        }
        for(int i = 1; i <= n; i++) if(!has[i]) neg.update(i, 1);
        long invertNum1 = modInv(num1, MOD);
        res += ((num1*(num1-1))%MOD)*modInv(4, MOD);
        res %= MOD;
        long cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == -1) {
                cnt++;
                continue;
            }
            res += (((neg.read(n+5)-neg.read(arr[i]))*cnt)%MOD)*invertNum1;
            res %= MOD;
        }
        cnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] == -1) {
                cnt++;
                continue;
            }
            res += (((neg.read(arr[i]))*cnt)%MOD)*invertNum1;
            res %= MOD;
        }
        System.out.println(res);
    }
    
    //@
    static class BIT {
            int n;
            int[] tree;
            public BIT(int n) {
                    this.n = n;
                    tree = new int[n + 1];
            }

            int read(int i) {
                    int sum = 0;
                    while (i > 0) {
                            sum += tree[i];
                            i -= i & -i;
                    }
                    return sum;
            }

            void update(int i, int val) {
                    while (i <= n) {
                            tree[i] += val;
                            i += i & -i;
                    }
            }
            //$
    }

    
    //@
    // Computes the modular inverse of x
    // Returns 0 if the GCD of x and mod is not 1
    // O(log n)  :  Can be converted to use BigIntegers
    static long modInv(long x, long mod) {
        return (BigInteger.valueOf(x).modInverse(BigInteger.valueOf(mod))).longValue();
    }

    static long modInv(long a, long b, long y0, long y1, long q0, long q1) {
            long y2 = y0 - y1*q0;
            return b == 0 ? y2 : modInv(b, a % b, y1, y2, q1, a / b);
    }
    
    //@
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }


}
