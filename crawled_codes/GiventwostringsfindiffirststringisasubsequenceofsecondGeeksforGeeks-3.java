//https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
//O(mn)
// Iterative Java program to check if a string
// is subsequence of another string
import java.io.*;

class GFG {

	// Returns true if str1[] is a subsequence
	// of str2[] m is length of str1 and n is
	// length of str2
	static boolean isSubSequence(String str1, String str2,
								int m, int n)
	{
		int j = 0;

		// Traverse str2 and str1, and compare
		// current character of str2 with first
		// unmatched char of str1, if matched
		// then move ahead in str1
		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		// If all characters of str1 were found
		// in str2
		return (j == m);
	}

	// Driver program to test methods of
	// graph class
	public static void main(String[] args)
	{
		String str1 = "gksrek";
		String str2 = "geeksforgeeks";
		int m = str1.length();
		int n = str2.length();
		boolean res = isSubSequence(str1, str2, m, n);

		if (res)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by Pramod Kumar
