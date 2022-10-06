//https://www.geeksforgeeks.org/pattern-searching-set-5-efficient-constructtion-of-finite-automata/
//O(m*no_of_chars)
/* A Java program to answer queries to check whether
the substrings are palindrome or not efficiently */

class GFG
{

	static int NO_OF_CHARS = 256;

	/* This function builds the TF table
	which represents Finite Automata for a
	given pattern */
	static void computeTransFun(char[] pat,
								int M, int TF[][])
	{
		int i, lps = 0, x;

		// Fill entries in first row
		for (x = 0; x < NO_OF_CHARS; x++)
		{
			TF[0][x] = 0;
		}
		TF[0][pat[0]] = 1;

		// Fill entries in other rows
		for (i = 1; i < M; i++)
		{
			// Copy values from row at index lps
			for (x = 0; x < NO_OF_CHARS; x++)
			{
				TF[i][x] = TF[lps][x];
			}

			// Update the entry corresponding to this character
			TF[i][pat[i]] = i + 1;

			// Update lps for next row to be filled
			if (i < M)
			{
				lps = TF[lps][pat[i]];
			}
		}
	}

	/* Prints all occurrences of pat in txt */
	static void search(char pat[], char txt[])
	{
		int M = pat.length;
		int N = txt.length;

		int[][] TF = new int[M + 1][NO_OF_CHARS];

		computeTransFun(pat, M, TF);

		// process text over FA.
		int i, j = 0;
		for (i = 0; i < N; i++)
		{
			j = TF[j][txt[i]];
			if (j == M)
			{
				System.out.println("pattern found at index " +
												(i - M + 1));
			}
		}
	}

	/* Driver code */
	public static void main(String[] args)
	{
		char txt[] = "GEEKS FOR GEEKS".toCharArray();
		char pat[] = "GEEKS".toCharArray();
		search(pat, txt);
	}
}

// This code is contributed by Princi Singh
