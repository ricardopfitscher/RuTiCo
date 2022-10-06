//https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
//O(n*log(n))
import java.util.*;
class GFG {

	// pow(base,exp,mod) is used to find
	// (base^exp)%mod fast -> O(log(exp))
	static long pow(long b, long exp, long mod)
	{
		long ret = 1;
		while (exp > 0) {
			if ((exp & 1) > 0)
				ret = (ret * b) % mod;
			b = (b * b) % mod;
			exp >>= 1;
		}
		return ret;
	}
	static int nCr(int n, int r)
	{
		if (r > n) // base case
			return 0;
	
		// C(n,r) = C(n,n-r) Complexity for
		// this code is lesser for lower n-r
		if (n - r > r)
			r = n - r;
	
		// list to smallest prime factor
		// of each number from 1 to n
		int[] SPF = new int[n + 1];
	
		// set smallest prime factor of each
		// number as itself
		for (int i = 1; i <= n; i++)
			SPF[i] = i;
	
		// set smallest prime factor of all
		// even numbers as 2
		for (int i = 4; i <= n; i += 2)
			SPF[i] = 2;
	
		for (int i = 3; i * i < n + 1; i += 2)
		{
			
			// Check if i is prime
			if (SPF[i] == i)
			{
			
				// All multiples of i are
				// composite (and divisible by
				// i) so add i to their prime
				// factorization getpow(j,i)
				// times
				for (int j = i * i; j < n + 1; j += i)
					if (SPF[j] == j) {
						SPF[j] = i;
					}
			}
		}
	
	// Hash Map to store power of
	// each prime in C(n,r)
	Map<Integer, Integer> prime_pow
			= new HashMap<>();
	
		// For numerator count frequency of each prime factor
		for (int i = r + 1; i < n + 1; i++)
		{
			int t = i;
			
			// Recursive division to find
			// prime factorization of i
			while (t > 1)
			{
				prime_pow.put(SPF[t],
					prime_pow.getOrDefault(SPF[t], 0) + 1);
				t /= SPF[t];
			}
		}
	
		// For denominator subtract the power of
		// each prime factor
		for (int i = 1; i < n - r + 1; i++)
		{
			int t = i;
		
			// Recursive division to find
			// prime factorization of i
			while (t > 1)
			{
				prime_pow.put(SPF[t],
							prime_pow.get(SPF[t]) - 1);
				t /= SPF[t];
			}
		}
	
		// long because mod is large and a%mod
		// * b%mod can overflow int
		long ans = 1, mod = 1000000007;
	
		// use (a*b)%mod = (a%mod * b%mod)%mod
		for (int i : prime_pow.keySet())
		
			// pow(base,exp,mod) is used to
			// find (base^exp)%mod fast
			ans = (ans * pow(i, prime_pow.get(i), mod))
				% mod;
		return (int)ans;
	}

	// Driver code
	public static void main(String[] args)
	{
		int n = 5, r = 2;
		System.out.print("Value of C(" + n + ", " + r
						+ ") is " + nCr(n, r) + "\n");
	}
}
// This code is contributed by Gautam Wadhwani
