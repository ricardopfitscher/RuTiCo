//https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/
//O(1)
// Java program to check if a given
// instance of 8 puzzle is solvable or not
class GFG
{
	
// A utility function to count
// inversions in given array 'arr[]'
static int getInvCount(int[][] arr)
{
	int inv_count = 0;
	for (int i = 0; i < 3 - 1; i++)
		for (int j = i + 1; j < 3; j++)
		
			// Value 0 is used for empty space
			if (arr[j][i] > 0 &&
							arr[j][i] > arr[i][j])
				inv_count++;
	return inv_count;
}

// This function returns true
// if given 8 puzzle is solvable.
static boolean isSolvable(int[][] puzzle)
{
	// Count inversions in given 8 puzzle
	int invCount = getInvCount(puzzle);

	// return true if inversion count is even.
	return (invCount % 2 == 0);
}

/* Driver code */
public static void main (String[] args)
{
	int[][] puzzle = {{1, 8, 2},{0, 4, 3},{7, 6, 5}};
	if(isSolvable(puzzle))
		System.out.println("Solvable");
	else
	System.out.println("Not Solvable");
}
}

// This code is contributed by chandan_jnu
