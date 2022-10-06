//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//O(n)
//Fibonacci Series using Recursion
class fibonacci
{
	static int fib(int n)
	{
	if (n <= 1)
	return n;
	return fib(n-1) + fib(n-2);
	}
	
	public static void main (String args[])
	{
	int n = 9;
	System.out.println(fib(n));
	}
}
/* This code is contributed by Rajat Mishra */
