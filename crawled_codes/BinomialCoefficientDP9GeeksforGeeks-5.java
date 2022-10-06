//https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
//O((min(r, n-r)^2 ) * log(n))
import java.util.*;
class GFG
{
	static int gcd(int a, int b) // function to find gcd of two numbers in O(log(min(a,b)))
	{
		if(b==0) return a;
		return gcd(b,a%b);
	}
	static int nCr(int n, int r)
	{
		if(r>n) // base case
			return 0;
		if(r>n-r) // C(n,r) = C(n,n-r) better time complexity for lesser r value
			r = n-r;
		int mod = 1000000007;
		int[] arr = new int[r]; // array of elements from n-r+1 to n
		for(int i=n-r+1; i<=n; i++)
		{
			arr[i+r-n-1] = i;
		}
		long ans = 1;
		for(int k=1;k<r+1;k++) // for numbers from 1 to r find arr[j] such that gcd(i,arr[j])>1
		{
			int j=0, i=k;
			while(j<arr.length)
			{
				int x = gcd(i,arr[j]);
				if(x>1)
				{
					arr[j] /= x; // if gcd>1, divide both by gcd
					i /= x;
				}
				if(i==1)
					break; // if i becomes 1, no need to search arr
				j += 1;
			}
		}
		for(int i : arr) // single pass to multiply the numerator
			ans = (ans*i)%mod;
		return (int)ans;
	}
	// Driver code
	public static void main(String[] args)
	{
		int n = 5, r = 2;
		System.out.print("Value of C(" + n+ ", " + r+ ") is "
			+nCr(n, r) +"\n");
	}
}
// This code is contributed by Gautam Wadhwani
