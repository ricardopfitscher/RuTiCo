//https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
//O(1)
// Java Program to Detect
// if two integers have opposite signs.

class GFG {

	static boolean oppositeSigns(int x, int y)
	{
		return ((x ^ y) < 0);
	}
	
	public static void main(String[] args)
	{
		int x = 100, y = -100;
		if (oppositeSigns(x, y) == true)
			System.out.println("Signs are opposite");
		else
			System.out.println("Signs are not opposite");
	}
}

// This code is contributed by prerna saini.
