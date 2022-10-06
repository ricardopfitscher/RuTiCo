//https://www.geeksforgeeks.org/lexicographic-permutations-of-string/
//O(n x n!)
import java.util.*;

// An optimized version that uses reverse instead of sort
// for finding the next permutation
class GFG
{

	// A utility function two swap two characters a and b
	static void swap(char[] str, int i, int j)
	{
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}

	// A utility function to reverse a string str[l..h]
	static void reverse(char str[], int l, int h)
	{
		while (l < h) {
			swap(str, l, h);
			l++;
			h--;
		}
	}

	// This function finds the index of the smallest
	// character which is greater than 'first' and is
	// present in str[l..h]
	static int findCeil(char str[], char first, int l,
						int h)
	{
		// initialize index of ceiling element
		int ceilIndex = l;

		// Now iterate through rest of the elements and find
		// the smallest character greater than 'first'
		for (int i = l + 1; i <= h; i++)
			if (str[i] > first && str[i] < str[ceilIndex])
				ceilIndex = i;

		return ceilIndex;
	}

	// Print all permutations of str in sorted order
	static void sortedPermutations(char str[])
	{
		// Get size of string
		int size = str.length;

		// Sort the string in increasing order
		Arrays.sort(str);

		// Print permutations one by one
		boolean isFinished = false;
		while (!isFinished) {
			// print this permutation
			System.out.println(str);

			// Find the rightmost character which is
			// smaller than its next character.
			// Let us call it 'first char'
			int i;
			for (i = size - 2; i >= 0; --i)
				if (str[i] < str[i + 1])
					break;

			// If there is no such character, all are
			// sorted in decreasing order, means we
			// just printed the last permutation and we are
			// done.
			if (i == -1)
				isFinished = true;
			else {
				// Find the ceil of 'first char' in
				// right of first character.
				// Ceil of a character is the smallest
				// character greater than it
				int ceilIndex = findCeil(str, str[i], i + 1,
										size - 1);

				// Swap first and second characters
				swap(str, i, ceilIndex);

				// reverse the string on right of 'first
				// char'
				reverse(str, i + 1, size - 1);
			}
		}
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		char str[] = "ABCD".toCharArray();
		sortedPermutations(str);
	}
}

// This code is contributed by Swarn Pallav Bhaskar
