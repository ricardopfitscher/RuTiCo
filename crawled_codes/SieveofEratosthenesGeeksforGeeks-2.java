//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
//O(n*log(log(n)
// Java program for the above approach
import java.io.*;
public class GFG {

static int[] Primes = new int[500001];

static void SieveOfEratosthenes(int n)
{
	Primes[0] = 1;
	for (int i = 3; i * i <= n; i += 2) {
	if (Primes[i / 2] == 0) {
		for (int j = 3 * i; j <= n; j += 2 * i)
		Primes[j / 2] = 1;
	}
	}
}

// Driver Code
public static void main(String[] args)
{

	int n = 100;
	SieveOfEratosthenes(n);
	for (int i = 1; i <= n; i++) {
	if (i == 2)
		System.out.print(i + " ");
	else if (i % 2 == 1 && Primes[i / 2] == 0)
		System.out.print(i + " ");
	}
}
}

// This code is contributed by ukasp.
