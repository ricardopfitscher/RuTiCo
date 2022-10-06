//https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
//O(n)
class Subset_sum
{
	static int countStrings(int n)
	{
		int a[] = new int [n];
		int b[] = new int [n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++)
		{
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		return a[n-1] + b[n-1];
	}
	/* Driver program to test above function */
	public static void main (String args[])
	{
		System.out.println(countStrings(3));
	}
}/* This code is contributed by Rajat Mishra */
