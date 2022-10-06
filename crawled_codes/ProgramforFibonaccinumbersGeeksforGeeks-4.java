//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//O(n)
class fibonacci
{
	
	static int fib(int n)
	{
	int F[][] = new int[][]{{1,1},{1,0}};
	if (n == 0)
		return 0;
	power(F, n-1);
	
	return F[0][0];
	}
	
	/* Helper function that multiplies 2 matrices F and M of size 2*2, and
	puts the multiplication result back to F[][] */
	static void multiply(int F[][], int M[][])
	{
	int x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
	int y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
	int z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
	int w = F[1][0]*M[0][1] + F[1][1]*M[1][1];
	
	F[0][0] = x;
	F[0][1] = y;
	F[1][0] = z;
	F[1][1] = w;
	}

	/* Helper function that calculates F[][] raise to the power n and puts the
	result in F[][]
	Note that this function is designed only for fib() and won't work as general
	power function */
	static void power(int F[][], int n)
	{
	int i;
	int M[][] = new int[][]{{1,1},{1,0}};
	
	// n - 1 times multiply the matrix to {{1,0},{0,1}}
	for (i = 2; i <= n; i++)
		multiply(F, M);
	}
	
	/* Driver program to test above function */
	public static void main (String args[])
	{
	int n = 9;
	System.out.println(fib(n));
	}
}
/* This code is contributed by Rajat Mishra */
