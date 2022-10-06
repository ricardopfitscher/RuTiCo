//https://www.geeksforgeeks.org/birthday-paradox/
//O(log n)
// Java program to approximate number
// of people in Birthday Paradox problem
class GFG {
	
	// Returns approximate number of people
	// for a given probability
	static double find(double p) {
		
		return Math.ceil(Math.sqrt(2 *
			365 * Math.log(1 / (1 - p))));
	}
	
	// Driver code
	public static void main(String[] args)
	{
		
		System.out.println(find(0.70));
	}
}

// This code is contributed by Anant Agarwal.
