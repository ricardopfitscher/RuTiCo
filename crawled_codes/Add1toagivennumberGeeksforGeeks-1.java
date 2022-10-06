//https://www.geeksforgeeks.org/add-1-to-a-given-number/
//O(log n)
// Java code to add
// one to a given number
class GFG {

	static int addOne(int x)
	{
		int m = 1;
		
		// Flip all the set bits
		// until we find a 0
		while( (int)(x & m) >= 1)
		{
			x = x ^ m;
			m <<= 1;
		}
	
		// flip the rightmost 0 bit
		x = x ^ m;
		return x;
	}
	
	/* Driver program to test above functions*/
	public static void main(String[] args)
	{
		System.out.println(addOne(13));
	}
}

// This code is contributed by prerna saini.
