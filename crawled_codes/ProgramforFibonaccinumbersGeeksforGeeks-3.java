//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//O(n)
// Java program for Fibonacci Series using Space
// Optimized Method
class fibonacci
{
	static int fib(int n)
	{
		int a = 0, b = 1, c;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main (String args[])
	{
		int n = 9;
		System.out.println(fib(n));
	}
}

// This code is contributed by Mihir Joshi
