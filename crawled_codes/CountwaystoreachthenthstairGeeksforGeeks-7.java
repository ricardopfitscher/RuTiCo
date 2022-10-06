//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
//O(log n)
import java.util.*;

class GFG
{

	// Computes A*B
	// where A,B are square matrices
	static long[][] mul(long[][] A, long[][] B, long MOD) {
		int K = A.length;
		long[][] C = new long[K][K];
		for (int i = 1; i < K; i++)
			for (int j = 1; j < K; j++)
				for (int k = 1; k < K; k++)
					C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
		return C;
	}

	// Computes A^n
	static long[][] power(long[][] A, long n) {
		if (n == 1)
			return A;
		if (n % 2 != 0)
		{
		
			// n is odd
			// A^n = A * [ A^(n-1) ]
			A = mul(A, power(A, n - 1), 1000000007);
		}
	else
	{
			// n is even
			// A^n = [ A^(n/2) ] * [ A^(n/2) ]
			A = power(A, n / 2);
			A = mul(A, A, 1000000007);
		}
		return A;
	}

	static long ways(int n) {
		long[] F = new long[3];
		F[1] = 1;
		F[2] = 2;
		int K = 2;
		long MOD = 1000000007;
	
		// create K*K matrix
		long[][] C = new long[K + 1][K + 1];
		/*
		* A matrix with (i+1)th element as 1 and last row contains constants [ [0 1 0 0
		* ... 0] [0 0 1 0 ... 0] [0 0 0 1 ... 0] [. . . . ... .] [. . . . ... .] [c(k)
		* c(k-1) c(k-2) ... c1] ]
		*/
		for (int i = 1; i < K; ++i) {
			C[i][i + 1] = 1;
		}
		// Last row is the constants c(k) c(k-1) ... c1
		// f(n) = 1*f(n-1) + 1*f(n-2)
		C[K][1] = 1;
		C[K][2] = 1;

		if (n <= 2)
			return F[n];

		// f(n) = C^(n-1)*F
		C = power(C, n - 1);

		long result = 0;

		// result will be the first row of C^(n-1)*F
		for (int i = 1; i <= K; ++i) {
			result = (result + C[1][i] * F[i]) % MOD;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.print("Number of ways = " + ways(n) + "\n");
	}
}

// This code is contributed by umadevi9616
