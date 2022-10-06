//https://www.geeksforgeeks.org/add-1-to-a-given-number/
//O(1)
// Java code to Add 1 to a given number
class GFG
{
	static int addOne(int x)
	{
		return (-(~x));
	}
	
	// Driver program
	public static void main(String[] args)
	{
		System.out.printf("%d", addOne(13));
	}
}

// This code is contributed
// by Smitha Dinesh Semwal
