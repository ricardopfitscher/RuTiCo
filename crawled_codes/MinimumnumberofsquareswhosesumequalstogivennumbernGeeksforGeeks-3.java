//https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
//O(n)
import java.util.*;

class GFG {

	static int minCount(int n)

	{

		int[] minSquaresRequired = new int[n + 1];

		minSquaresRequired[0] = 0;

		minSquaresRequired[1] = 1;

		for (int i = 2; i <= n; ++i)

		{

			minSquaresRequired[i] = Integer.MAX_VALUE;

			for (int j = 1; i - (j * j) >= 0; ++j)

			{

				minSquaresRequired[i] = Math.min(minSquaresRequired[i], minSquaresRequired[i - (j * j)]);
			}

			minSquaresRequired[i] += 1;
		}

		int result = minSquaresRequired[n];

		return result;
	}

	// Driver code
	public static void main(String[] args) {
		System.out.print(minCount(6));
	}
}

// This code contributed by gauravrajput1
