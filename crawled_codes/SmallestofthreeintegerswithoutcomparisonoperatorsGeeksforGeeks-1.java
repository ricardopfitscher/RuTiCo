//https://www.geeksforgeeks.org/smallest-of-three-integers-without-comparison-operators/
//O(min(x, y, z))
// Java program to find Smallest
// of three integers without
// comparison operators
class GFG {

	static int smallest(int x, int y, int z)
	{
		int c = 0;

		while (x != 0 && y != 0 && z != 0) {
			x--;
			y--;
			z--;
			c++;
		}

		return c;
	}

	public static void main(String[] args)
	{
		int x = 12, y = 15, z = 5;

		System.out.printf("Minimum of 3"
							+ " numbers is %d",
						smallest(x, y, z));
	}
}

// This code is contributed by Smitha Dinesh Semwal.
