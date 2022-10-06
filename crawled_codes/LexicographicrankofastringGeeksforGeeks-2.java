//https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
//O(n)
// A O(n) solution for finding rank of string

class GFG {

	static int MAX_CHAR = 256;

	// A utility function to find factorial of n
	static int fact(int n)
	{
		return (n <= 1) ? 1 : n * fact(n - 1);
	}

	// Construct a count array where value at every index
	// contains count of smaller characters in whole string
	static void populateAndIncreaseCount(int[] count, char[] str)
	{
		int i;

		for (i = 0; i < str.length; ++i)
			++count[str[i]];

		for (i = 1; i < MAX_CHAR; ++i)
			count[i] += count[i - 1];
	}

	// Removes a character ch from count[] array
	// constructed by populateAndIncreaseCount()
	static void updatecount(int[] count, char ch)
	{
		int i;
		for (i = ch; i < MAX_CHAR; ++i)
			--count[i];
	}

	// A function to find rank of a string in all permutations
	// of characters
	static int findRank(char[] str)
	{
		int len = str.length;
		int mul = fact(len);
		int rank = 1, i;

		// all elements of count[] are initialized with 0
		int count[] = new int[MAX_CHAR];

		// Populate the count array such that count[i]
		// contains count of characters which are present
		// in str and are smaller than i
		populateAndIncreaseCount(count, str);

		for (i = 0; i < len; ++i) {
			mul /= len - i;

			// count number of chars smaller than str[i]
			// from str[i+1] to str[len-1]
			rank += count[str[i] - 1] * mul;

			// Reduce count of characters greater than str[i]
			updatecount(count, str[i]);
		}

		return rank;
	}

	// Driver code
	public static void main(String args[])
	{
		char str[] = "string".toCharArray();
		System.out.println(findRank(str));
	}
}

// This code has been contributed by 29AjayKumar
